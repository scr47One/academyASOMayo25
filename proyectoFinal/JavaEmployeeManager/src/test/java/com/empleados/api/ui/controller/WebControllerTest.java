package com.empleados.api.ui.controller;

import com.empleados.api.dto.EmpleadoDTO;
import com.empleados.api.service.EmpleadoService;
import com.empleados.api.util.TestDataBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class WebControllerTest {

    @Mock
    private EmpleadoService empleadoService;

    @InjectMocks
    private WebController webController;

    private MockMvc mockMvc;
    private EmpleadoDTO empleadoDTO1;
    private EmpleadoDTO empleadoDTO2;
    private List<EmpleadoDTO> empleadosList;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(webController)
                .setViewResolvers((viewName, locale) -> {
                    // Mock view resolver que solo devuelve un mock view para evitar el error
                    return mock(org.springframework.web.servlet.View.class);
                })
                .build();
        
        // Configurar datos de prueba
        empleadoDTO1 = TestDataBuilder.createEmpleadoDTO();
        empleadoDTO2 = TestDataBuilder.createEmpleadoDTO2();
        empleadosList = Arrays.asList(empleadoDTO1, empleadoDTO2);
    }

    @Test
    @DisplayName("Debería mostrar el dashboard")
    void dashboard_ShouldDisplayDashboard() throws Exception {
        // Arrange
        when(empleadoService.getAllEmpleados()).thenReturn(empleadosList);

        // Act & Assert
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("totalEmpleados"))
                .andExpect(model().attributeExists("salarioPromedio"))
                .andExpect(model().attributeExists("departamentos"))
                .andExpect(model().attribute("totalEmpleados", 2));
        
        verify(empleadoService, times(1)).getAllEmpleados();
        
        // Verificar el nombre de la vista directamente
        Model model = mock(Model.class);
        String viewName = webController.dashboard(model);
        assertEquals("index", viewName);
    }

    @Test
    @DisplayName("Debería listar todos los empleados")
    void listarEmpleados_ShouldListAllEmpleados() throws Exception {
        // Arrange
        when(empleadoService.getAllEmpleados()).thenReturn(empleadosList);

        // Act & Assert
        mockMvc.perform(get("/empleados"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("empleados"))
                .andExpect(model().attribute("empleados", empleadosList));
        
        verify(empleadoService, times(1)).getAllEmpleados();
        
        // Verificar el nombre de la vista directamente
        Model model = mock(Model.class);
        String viewName = webController.listarEmpleados(model);
        assertEquals("empleados", viewName);
    }

    @Test
    @DisplayName("Debería mostrar formulario para nuevo empleado")
    void nuevoEmpleadoForm_ShouldShowFormForNewEmpleado() throws Exception {
        // Act & Assert
        mockMvc.perform(get("/empleados/nuevo"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("empleado"));
                
        // Verificar el nombre de la vista directamente
        Model model = mock(Model.class);
        String viewName = webController.nuevoEmpleadoForm(model);
        assertEquals("form", viewName);
    }

    @Test
    @DisplayName("Debería guardar nuevo empleado")
    void guardarEmpleado_WithValidData_ShouldSaveAndRedirect() throws Exception {
        // Arrange
        EmpleadoDTO newEmpleadoDTO = TestDataBuilder.createNewEmpleadoDTO();
        when(empleadoService.createEmpleado(any(EmpleadoDTO.class))).thenReturn(newEmpleadoDTO);
        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.hasErrors()).thenReturn(false);
        RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);

        // Act
        String result = webController.guardarEmpleado(newEmpleadoDTO, bindingResult, redirectAttributes);
        
        // Assert
        assertEquals("redirect:/empleados", result);
        verify(empleadoService, times(1)).createEmpleado(any(EmpleadoDTO.class));
        verify(redirectAttributes).addFlashAttribute(eq("mensajeExito"), anyString());
    }

    @Test
    @DisplayName("Debería mostrar formulario con datos del empleado a editar")
    void editarEmpleadoForm_ShouldShowFormWithEmpleadoData() throws Exception {
        // Arrange
        when(empleadoService.getEmpleadoById(1L)).thenReturn(empleadoDTO1);

        // Act & Assert
        mockMvc.perform(get("/empleados/editar/1"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("empleado"))
                .andExpect(model().attribute("empleado", empleadoDTO1));
        
        verify(empleadoService, times(1)).getEmpleadoById(1L);
        
        // Verificar el nombre de la vista directamente
        Model model = mock(Model.class);
        String viewName = webController.editarEmpleadoForm(1L, model);
        assertEquals("form", viewName);
    }

    @Test
    @DisplayName("Debería actualizar empleado existente")
    void actualizarEmpleado_WithValidData_ShouldUpdateAndRedirect() throws Exception {
        // Arrange
        EmpleadoDTO updatedEmpleadoDTO = new EmpleadoDTO(
            1L,
            "Juan Carlos",
            "Pérez",
            "juan.perez@example.com",
            LocalDate.of(2020, 1, 15),
            new BigDecimal("55000.00"),
            "Tecnología"
        );
        
        when(empleadoService.updateEmpleado(eq(1L), any(EmpleadoDTO.class))).thenReturn(updatedEmpleadoDTO);
        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.hasErrors()).thenReturn(false);
        RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);

        // Act
        String result = webController.actualizarEmpleado(1L, updatedEmpleadoDTO, bindingResult, redirectAttributes);
        
        // Assert
        assertEquals("redirect:/empleados", result);
        verify(empleadoService, times(1)).updateEmpleado(eq(1L), any(EmpleadoDTO.class));
        verify(redirectAttributes).addFlashAttribute(eq("mensajeExito"), anyString());
    }

    @Test
    @DisplayName("Debería eliminar empleado existente")
    void eliminarEmpleado_ShouldDeleteAndRedirect() throws Exception {
        // Arrange
        doNothing().when(empleadoService).deleteEmpleado(1L);
        RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);

        // Act
        String result = webController.eliminarEmpleado(1L, redirectAttributes);
        
        // Assert
        assertEquals("redirect:/empleados", result);
        verify(empleadoService, times(1)).deleteEmpleado(1L);
        verify(redirectAttributes).addFlashAttribute(eq("mensajeExito"), anyString());
    }

    @Test
    @DisplayName("Debería retornar al formulario cuando hay errores de validación al guardar")
    void guardarEmpleado_WithValidationErrors_ShouldReturnToForm() {
        // Arrange
        EmpleadoDTO invalidEmpleadoDTO = TestDataBuilder.createInvalidEmpleadoDTO();
        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.hasErrors()).thenReturn(true);
        RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);

        // Act
        String viewName = webController.guardarEmpleado(invalidEmpleadoDTO, bindingResult, redirectAttributes);

        // Assert
        assertEquals("form", viewName);
        verify(empleadoService, times(0)).createEmpleado(any(EmpleadoDTO.class));
    }

    @Test
    @DisplayName("Debería retornar al formulario cuando hay errores de validación al actualizar")
    void actualizarEmpleado_WithValidationErrors_ShouldReturnToForm() {
        // Arrange
        EmpleadoDTO invalidEmpleadoDTO = TestDataBuilder.createInvalidEmpleadoDTO();
        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.hasErrors()).thenReturn(true);
        RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);

        // Act
        String viewName = webController.actualizarEmpleado(1L, invalidEmpleadoDTO, bindingResult, redirectAttributes);

        // Assert
        assertEquals("form", viewName);
        verify(empleadoService, times(0)).updateEmpleado(anyLong(), any(EmpleadoDTO.class));
    }

    @Test
    @DisplayName("Debería calcular correctamente las estadísticas del dashboard")
    void dashboard_ShouldCalculateStatisticsCorrectly() {
        // Arrange
        when(empleadoService.getAllEmpleados()).thenReturn(empleadosList);
        Model model = mock(Model.class);

        // Act
        String viewName = webController.dashboard(model);

        // Assert
        assertEquals("index", viewName);
        verify(model).addAttribute(eq("totalEmpleados"), eq(2));
        verify(model).addAttribute(eq("salarioPromedio"), anyString());
        verify(model).addAttribute(eq("departamentos"), any());
        verify(empleadoService, times(1)).getAllEmpleados();
    }
}