package com.empleados.api.service;

import com.empleados.api.dto.EmpleadoDTO;
import com.empleados.api.exception.ResourceNotFoundException;
import com.empleados.api.model.Empleado;
import com.empleados.api.repository.EmpleadoRepository;
import com.empleados.api.service.impl.EmpleadoServiceImpl;
import com.empleados.api.util.TestDataBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmpleadoServiceTest {

    @Mock
    private EmpleadoRepository empleadoRepository;

    @InjectMocks
    private EmpleadoServiceImpl empleadoService;

    private Empleado empleado;
    private EmpleadoDTO empleadoDTO;
    private Empleado empleado2;
    private EmpleadoDTO empleadoDTO2;

    @BeforeEach
    void setUp() {
        // Setup test employee entities and DTOs
        empleado = TestDataBuilder.createEmpleado();
        empleadoDTO = TestDataBuilder.createEmpleadoDTO();
        empleado2 = TestDataBuilder.createEmpleado2();
        empleadoDTO2 = TestDataBuilder.createEmpleadoDTO2();
    }
/*
    @Test
    @DisplayName("Debe retornar todos los empleados")
    void getAllEmpleados_ShouldReturnAllEmpleados() {
        // Arrange
        List<Empleado> empleados = Arrays.asList(empleado, empleado2);
        when(empleadoRepository.findAll()).thenReturn(empleados);

        // Act
        List<EmpleadoDTO> result = empleadoService.getAllEmpleados();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Juan", result.get(0).getNombre());
        assertEquals("Ana", result.get(1).getNombre());
        
        verify(empleadoRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Debe retornar un empleado por ID")
    void getEmpleadoById_WhenEmpleadoExists_ShouldReturnEmpleado() {
        // Arrange
        when(empleadoRepository.findById(1L)).thenReturn(Optional.of(empleado));

        // Act
        EmpleadoDTO result = empleadoService.getEmpleadoById(1L);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Juan", result.getNombre());
        assertEquals("juan.perez@example.com", result.getEmail());
        
        verify(empleadoRepository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Debe lanzar excepción cuando el empleado no existe")
    void getEmpleadoById_WhenEmpleadoDoesNotExist_ShouldThrowException() {
        // Arrange
        when(empleadoRepository.findById(99L)).thenReturn(Optional.empty());

        // Act & Assert
        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, 
                () -> empleadoService.getEmpleadoById(99L));
        
        assertTrue(exception.getMessage().contains("99"));
        verify(empleadoRepository, times(1)).findById(99L);
    }

    @Test
    @DisplayName("Debe crear un nuevo empleado")
    void createEmpleado_WithValidData_ShouldReturnCreatedEmpleado() {
        // Arrange
        EmpleadoDTO newEmpleadoDTO = TestDataBuilder.createNewEmpleadoDTO();
        Empleado newEmpleado = new Empleado(
                null,
                newEmpleadoDTO.getNombre(),
                newEmpleadoDTO.getApellido(),
                newEmpleadoDTO.getEmail(),
                newEmpleadoDTO.getFechaContratacion(),
                newEmpleadoDTO.getSalario(),
                newEmpleadoDTO.getDepartamento()
        );
        
        Empleado savedEmpleado = new Empleado(
                3L,
                newEmpleadoDTO.getNombre(),
                newEmpleadoDTO.getApellido(),
                newEmpleadoDTO.getEmail(),
                newEmpleadoDTO.getFechaContratacion(),
                newEmpleadoDTO.getSalario(),
                newEmpleadoDTO.getDepartamento()
        );
        
        when(empleadoRepository.findByEmail(anyString())).thenReturn(Optional.empty());
        when(empleadoRepository.save(any(Empleado.class))).thenReturn(savedEmpleado);

        // Act
        EmpleadoDTO result = empleadoService.createEmpleado(newEmpleadoDTO);

        // Assert
        assertNotNull(result);
        assertEquals(3L, result.getId());
        assertEquals("Carlos", result.getNombre());
        assertEquals("Rodríguez", result.getApellido());
        assertEquals("carlos.rodriguez@example.com", result.getEmail());
        
        verify(empleadoRepository, times(1)).findByEmail(anyString());
        verify(empleadoRepository, times(1)).save(any(Empleado.class));
    }

    @Test
    @DisplayName("Debe lanzar excepción al crear un empleado con email duplicado")
    void createEmpleado_WithDuplicateEmail_ShouldThrowException() {
        // Arrange
        when(empleadoRepository.findByEmail("juan.perez@example.com")).thenReturn(Optional.of(empleado));

        // Act & Assert
        assertThrows(DataIntegrityViolationException.class, 
                () -> empleadoService.createEmpleado(empleadoDTO));
        
        verify(empleadoRepository, times(1)).findByEmail("juan.perez@example.com");
        verify(empleadoRepository, never()).save(any(Empleado.class));
    }

    @Test
    @DisplayName("Debe actualizar un empleado existente")
    void updateEmpleado_WhenEmpleadoExists_ShouldReturnUpdatedEmpleado() {
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

        Empleado updatedEmpleado = new Empleado(
                1L,
                "Juan Carlos",
                "Pérez",
                "juan.perez@example.com",
                LocalDate.of(2020, 1, 15),
                new BigDecimal("55000.00"),
                "Tecnología"
        );

        when(empleadoRepository.findById(1L)).thenReturn(Optional.of(empleado));
        when(empleadoRepository.save(any(Empleado.class))).thenReturn(updatedEmpleado);

        // Act
        EmpleadoDTO result = empleadoService.updateEmpleado(1L, updatedDTO);

        // Assert
        assertNotNull(result);
        assertEquals("Juan Carlos", result.getNombre());
        assertEquals(new BigDecimal("55000.00"), result.getSalario());
        
        verify(empleadoRepository, times(1)).findById(1L);
        verify(empleadoRepository, times(1)).save(any(Empleado.class));
    }

    @Test
    @DisplayName("Debe lanzar excepción al actualizar un empleado inexistente")
    void updateEmpleado_WhenEmpleadoDoesNotExist_ShouldThrowException() {
        // Arrange
        when(empleadoRepository.findById(99L)).thenReturn(Optional.empty());

        // Act & Assert
        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, 
                () -> empleadoService.updateEmpleado(99L, empleadoDTO));
        
        assertTrue(exception.getMessage().contains("99"));
        verify(empleadoRepository, times(1)).findById(99L);
        verify(empleadoRepository, never()).save(any(Empleado.class));
    }

    @Test
    @DisplayName("Debe lanzar excepción al actualizar con email que ya pertenece a otro empleado")
    void updateEmpleado_WithDuplicateEmail_ShouldThrowException() {
        // Arrange
        EmpleadoDTO updatedDTO = new EmpleadoDTO(
                1L,
                "Juan Carlos",
                "Pérez",
                "ana.garcia@example.com", // Email de otro empleado existente
                LocalDate.of(2020, 1, 15),
                new BigDecimal("55000.00"),
                "Tecnología"
        );

        when(empleadoRepository.findById(1L)).thenReturn(Optional.of(empleado));
        when(empleadoRepository.findByEmail("ana.garcia@example.com")).thenReturn(Optional.of(empleado2));

        // Act & Assert
        assertThrows(DataIntegrityViolationException.class, 
                () -> empleadoService.updateEmpleado(1L, updatedDTO));
        
        verify(empleadoRepository, times(1)).findById(1L);
        verify(empleadoRepository, times(1)).findByEmail("ana.garcia@example.com");
        verify(empleadoRepository, never()).save(any(Empleado.class));
    }

    @Test
    @DisplayName("Debe eliminar un empleado existente")
    void deleteEmpleado_WhenEmpleadoExists_ShouldDeleteEmpleado() {
        // Arrange
        when(empleadoRepository.existsById(1L)).thenReturn(true);
        doNothing().when(empleadoRepository).deleteById(1L);

        // Act
        empleadoService.deleteEmpleado(1L);

        // Assert
        verify(empleadoRepository, times(1)).existsById(1L);
        verify(empleadoRepository, times(1)).deleteById(1L);
    }

    @Test
    @DisplayName("Debe lanzar excepción al eliminar un empleado inexistente")
    void deleteEmpleado_WhenEmpleadoDoesNotExist_ShouldThrowException() {
        // Arrange
        when(empleadoRepository.existsById(99L)).thenReturn(false);

        // Act & Assert
        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, 
                () -> empleadoService.deleteEmpleado(99L));
        
        assertTrue(exception.getMessage().contains("99"));
        verify(empleadoRepository, times(1)).existsById(99L);
        verify(empleadoRepository, never()).deleteById(anyLong());
    }

    @Test
    @DisplayName("Debe retornar empleados por departamento")
    void getEmpleadosByDepartamento_ShouldReturnEmpleadosInDepartamento() {
        // Arrange
        List<Empleado> tecnologiaEmpleados = Arrays.asList(empleado);
        
        when(empleadoRepository.findByDepartamento("Tecnología")).thenReturn(tecnologiaEmpleados);

        // Act
        List<EmpleadoDTO> result = empleadoService.getEmpleadosByDepartamento("Tecnología");

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Tecnología", result.get(0).getDepartamento());
        assertEquals("Juan", result.get(0).getNombre());
        
        verify(empleadoRepository, times(1)).findByDepartamento("Tecnología");
    }
    
    @Test
    @DisplayName("Debe retornar lista vacía cuando no hay empleados en el departamento")
    void getEmpleadosByDepartamento_WhenNoEmpleados_ShouldReturnEmptyList() {
        // Arrange
        when(empleadoRepository.findByDepartamento("Marketing")).thenReturn(Arrays.asList());

        // Act
        List<EmpleadoDTO> result = empleadoService.getEmpleadosByDepartamento("Marketing");

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
        
        verify(empleadoRepository, times(1)).findByDepartamento("Marketing");
    }
    
    @Test
    @DisplayName("Debe convertir correctamente entidad a DTO")
    void convertToDTO_ShouldMapAllProperties() {
        // Arrange
        Empleado testEmpleado = new Empleado(
                5L,
                "Test",
                "User",
                "test.user@example.com",
                LocalDate.of(2022, 5, 15),
                new BigDecimal("60000.00"),
                "IT"
        );
        
        // Act - Llamar al método privado convertToDTO a través de un método público
        EmpleadoDTO dto = empleadoService.getEmpleadoById(5L); // Mockear para llegar a convertToDTO
        when(empleadoRepository.findById(5L)).thenReturn(Optional.of(testEmpleado));
        dto = empleadoService.getEmpleadoById(5L);
        
        // Assert
        assertEquals(5L, dto.getId());
        assertEquals("Test", dto.getNombre());
        assertEquals("User", dto.getApellido());
        assertEquals("test.user@example.com", dto.getEmail());
        assertEquals(LocalDate.of(2022, 5, 15), dto.getFechaContratacion());
        assertEquals(new BigDecimal("60000.00"), dto.getSalario());
        assertEquals("IT", dto.getDepartamento());
    }*/
}