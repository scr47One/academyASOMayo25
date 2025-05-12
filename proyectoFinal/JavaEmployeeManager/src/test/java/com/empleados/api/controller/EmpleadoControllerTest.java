package com.empleados.api.controller;

import com.empleados.api.dto.EmpleadoDTO;
import com.empleados.api.exception.ResourceNotFoundException;
import com.empleados.api.service.EmpleadoService;
import com.empleados.api.util.TestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmpleadoController.class)
class EmpleadoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmpleadoService empleadoService;

    private ObjectMapper objectMapper;
    private EmpleadoDTO empleadoDTO;
    private EmpleadoDTO empleadoDTO2;
    private List<EmpleadoDTO> empleadoDTOList;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        empleadoDTO = TestDataBuilder.createEmpleadoDTO();
        empleadoDTO2 = TestDataBuilder.createEmpleadoDTO2();
        empleadoDTOList = TestDataBuilder.createEmpleadoDTOList();
    }

    @Test
    @DisplayName("Debe retornar todos los empleados")
    void getAllEmpleados_ShouldReturnListOfEmpleados() throws Exception {
        // Arrange
        when(empleadoService.getAllEmpleados()).thenReturn(empleadoDTOList);

        // Act & Assert
        mockMvc.perform(get("/api/empleados")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].nombre", is("Juan")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].nombre", is("Ana")));

        verify(empleadoService, times(1)).getAllEmpleados();
    }
    
    @Test
    @DisplayName("Debe retornar lista vacía cuando no hay empleados")
    void getAllEmpleados_WhenNoEmpleados_ShouldReturnEmptyList() throws Exception {
        // Arrange
        when(empleadoService.getAllEmpleados()).thenReturn(Collections.emptyList());

        // Act & Assert
        mockMvc.perform(get("/api/empleados")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));

        verify(empleadoService, times(1)).getAllEmpleados();
    }

    @Test
    @DisplayName("Debe retornar un empleado por ID")
    void getEmpleadoById_WhenEmpleadoExists_ShouldReturnEmpleado() throws Exception {
        // Arrange
        when(empleadoService.getEmpleadoById(1L)).thenReturn(empleadoDTO);

        // Act & Assert
        mockMvc.perform(get("/api/empleados/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nombre", is("Juan")))
                .andExpect(jsonPath("$.apellido", is("Pérez")))
                .andExpect(jsonPath("$.email", is("juan.perez@example.com")));

        verify(empleadoService, times(1)).getEmpleadoById(1L);
    }

    @Test
    @DisplayName("Debe retornar 404 cuando el empleado no existe")
    void getEmpleadoById_WhenEmpleadoDoesNotExist_ShouldReturn404() throws Exception {
        // Arrange
        when(empleadoService.getEmpleadoById(99L)).thenThrow(new ResourceNotFoundException("Empleado no encontrado con id: 99"));

        // Act & Assert
        mockMvc.perform(get("/api/empleados/99")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message", containsString("99")));

        verify(empleadoService, times(1)).getEmpleadoById(99L);
    }

    @Test
    @DisplayName("Debe crear un nuevo empleado")
    void createEmpleado_WithValidData_ShouldReturnCreatedEmpleado() throws Exception {
        // Arrange
        EmpleadoDTO newEmpleadoDTO = TestDataBuilder.createNewEmpleadoDTO();
        EmpleadoDTO createdEmpleadoDTO = new EmpleadoDTO(
                3L,
                newEmpleadoDTO.getNombre(),
                newEmpleadoDTO.getApellido(),
                newEmpleadoDTO.getEmail(),
                newEmpleadoDTO.getFechaContratacion(),
                newEmpleadoDTO.getSalario(),
                newEmpleadoDTO.getDepartamento()
        );
        
        when(empleadoService.createEmpleado(any(EmpleadoDTO.class))).thenReturn(createdEmpleadoDTO);

        // Act & Assert
        mockMvc.perform(post("/api/empleados")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newEmpleadoDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(3)))
                .andExpect(jsonPath("$.nombre", is("Carlos")))
                .andExpect(jsonPath("$.apellido", is("Rodríguez")));

        verify(empleadoService, times(1)).createEmpleado(any(EmpleadoDTO.class));
    }

    @Test
    @DisplayName("Debe retornar 400 al crear con datos inválidos")
    void createEmpleado_WithInvalidData_ShouldReturn400() throws Exception {
        // Arrange
        EmpleadoDTO invalidEmpleadoDTO = TestDataBuilder.createInvalidEmpleadoDTO();

        // Act & Assert
        mockMvc.perform(post("/api/empleados")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(invalidEmpleadoDTO)))
                .andExpect(status().isBadRequest())
                .andDo(MockMvcResultHandlers.print());

        verify(empleadoService, never()).createEmpleado(any(EmpleadoDTO.class));
    }
    
    @Test
    @DisplayName("Debe retornar 409 al crear con email duplicado")
    void createEmpleado_WithDuplicateEmail_ShouldReturn409() throws Exception {
        // Arrange
        when(empleadoService.createEmpleado(any(EmpleadoDTO.class)))
                .thenThrow(new DataIntegrityViolationException("Ya existe un empleado con el email: juan.perez@example.com"));

        // Act & Assert
        mockMvc.perform(post("/api/empleados")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(empleadoDTO)))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.message", containsString("Ya existe un empleado")));

        verify(empleadoService, times(1)).createEmpleado(any(EmpleadoDTO.class));
    }

    @Test
    @DisplayName("Debe actualizar un empleado existente")
    void updateEmpleado_WithValidData_ShouldReturnUpdatedEmpleado() throws Exception {
        // Arrange
        EmpleadoDTO updatedDTO = new EmpleadoDTO(
                1L,
                "Juan Carlos",
                "Pérez",
                "juan.perez@example.com",
                LocalDate.of(2020, 1, 15),
                new BigDecimal("55000.00"),
                "Tecnología"
        );

        when(empleadoService.updateEmpleado(eq(1L), any(EmpleadoDTO.class))).thenReturn(updatedDTO);

        // Act & Assert
        mockMvc.perform(put("/api/empleados/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nombre", is("Juan Carlos")))
                .andExpect(jsonPath("$.salario", is(55000.00)));

        verify(empleadoService, times(1)).updateEmpleado(eq(1L), any(EmpleadoDTO.class));
    }
    
    @Test
    @DisplayName("Debe retornar 404 al actualizar un empleado inexistente")
    void updateEmpleado_WhenEmpleadoDoesNotExist_ShouldReturn404() throws Exception {
        // Arrange
        when(empleadoService.updateEmpleado(eq(99L), any(EmpleadoDTO.class)))
                .thenThrow(new ResourceNotFoundException("Empleado no encontrado con id: 99"));

        // Act & Assert
        mockMvc.perform(put("/api/empleados/99")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(empleadoDTO)))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message", containsString("99")));

        verify(empleadoService, times(1)).updateEmpleado(eq(99L), any(EmpleadoDTO.class));
    }
    
    @Test
    @DisplayName("Debe retornar 409 al actualizar con email duplicado")
    void updateEmpleado_WithDuplicateEmail_ShouldReturn409() throws Exception {
        // Arrange
        EmpleadoDTO updatedDTO = new EmpleadoDTO(
                1L,
                "Juan Carlos",
                "Pérez",
                "ana.garcia@example.com",
                LocalDate.of(2020, 1, 15),
                new BigDecimal("55000.00"),
                "Tecnología"
        );

        when(empleadoService.updateEmpleado(eq(1L), any(EmpleadoDTO.class)))
                .thenThrow(new DataIntegrityViolationException("Ya existe un empleado con el email: ana.garcia@example.com"));

        // Act & Assert
        mockMvc.perform(put("/api/empleados/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedDTO)))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.message", containsString("Ya existe un empleado")));

        verify(empleadoService, times(1)).updateEmpleado(eq(1L), any(EmpleadoDTO.class));
    }

    @Test
    @DisplayName("Debe eliminar un empleado")
    void deleteEmpleado_WhenEmpleadoExists_ShouldReturnNoContent() throws Exception {
        // Arrange
        doNothing().when(empleadoService).deleteEmpleado(1L);

        // Act & Assert
        mockMvc.perform(delete("/api/empleados/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(empleadoService, times(1)).deleteEmpleado(1L);
    }
    
    @Test
    @DisplayName("Debe retornar 404 al eliminar un empleado inexistente")
    void deleteEmpleado_WhenEmpleadoDoesNotExist_ShouldReturn404() throws Exception {
        // Arrange
        doThrow(new ResourceNotFoundException("Empleado no encontrado con id: 99"))
                .when(empleadoService).deleteEmpleado(99L);

        // Act & Assert
        mockMvc.perform(delete("/api/empleados/99")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message", containsString("99")));

        verify(empleadoService, times(1)).deleteEmpleado(99L);
    }

    @Test
    @DisplayName("Debe retornar empleados por departamento")
    void getEmpleadosByDepartamento_ShouldReturnListOfEmpleados() throws Exception {
        // Arrange
        List<EmpleadoDTO> tecnologiaEmpleados = TestDataBuilder.createEmpleadosDTOByDepartamento("Tecnología");
        
        when(empleadoService.getEmpleadosByDepartamento("Tecnología")).thenReturn(tecnologiaEmpleados);

        // Act & Assert
        mockMvc.perform(get("/api/empleados/departamento/Tecnología")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].departamento", is("Tecnología")));

        verify(empleadoService, times(1)).getEmpleadosByDepartamento("Tecnología");
    }
    
    @Test
    @DisplayName("Debe retornar lista vacía cuando no hay empleados en el departamento")
    void getEmpleadosByDepartamento_WhenNoEmpleados_ShouldReturnEmptyList() throws Exception {
        // Arrange
        when(empleadoService.getEmpleadosByDepartamento("Marketing")).thenReturn(Collections.emptyList());

        // Act & Assert
        mockMvc.perform(get("/api/empleados/departamento/Marketing")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));

        verify(empleadoService, times(1)).getEmpleadosByDepartamento("Marketing");
    }
}