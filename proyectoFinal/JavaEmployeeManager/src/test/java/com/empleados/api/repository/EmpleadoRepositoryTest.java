package com.empleados.api.repository;

import com.empleados.api.model.Empleado;
import com.empleados.api.util.TestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para EmpleadoRepository
 */
@DataJpaTest
@ActiveProfiles("test")
class EmpleadoRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Test
    @DisplayName("Debe encontrar un empleado por email cuando existe")
    void findByEmail_WhenEmailExists_ShouldReturnEmpleado() {
        // Arrange
        Empleado empleado = TestDataBuilder.createEmpleado();
        empleado.setId(null); // El ID se asignará automáticamente
        entityManager.persist(empleado);
        entityManager.flush();

        // Act
        Optional<Empleado> found = empleadoRepository.findByEmail("juan.perez@example.com");

        // Assert
        assertTrue(found.isPresent());
        assertEquals("Juan", found.get().getNombre());
        assertEquals("Pérez", found.get().getApellido());
    }

    @Test
    @DisplayName("Debe retornar Optional vacío cuando el email no existe")
    void findByEmail_WhenEmailDoesNotExist_ShouldReturnEmpty() {
        // Act
        Optional<Empleado> found = empleadoRepository.findByEmail("noexiste@example.com");

        // Assert
        assertFalse(found.isPresent());
    }

    @Test
    @DisplayName("Debe encontrar empleados por departamento")
    void findByDepartamento_ShouldReturnEmpleadosInDepartamento() {
        // Arrange
        Empleado empleado1 = TestDataBuilder.createEmpleado();
        empleado1.setId(null);
        
        Empleado empleado2 = TestDataBuilder.createEmpleado2();
        empleado2.setId(null);
        
        Empleado empleado3 = new Empleado(null, "Pedro", "Sánchez", 
                "pedro.sanchez@example.com", LocalDate.of(2021, 3, 5), 
                new BigDecimal("52000.00"), "Tecnología");
        
        entityManager.persist(empleado1);
        entityManager.persist(empleado2);
        entityManager.persist(empleado3);
        entityManager.flush();

        // Act
        List<Empleado> tecnologiaEmpleados = empleadoRepository.findByDepartamento("Tecnología");
        List<Empleado> rrhhEmpleados = empleadoRepository.findByDepartamento("Recursos Humanos");
        List<Empleado> marketingEmpleados = empleadoRepository.findByDepartamento("Marketing");

        // Assert
        assertEquals(2, tecnologiaEmpleados.size());
        assertEquals(1, rrhhEmpleados.size());
        assertEquals(0, marketingEmpleados.size());
        
        assertTrue(tecnologiaEmpleados.stream().allMatch(e -> "Tecnología".equals(e.getDepartamento())));
        assertTrue(rrhhEmpleados.stream().allMatch(e -> "Recursos Humanos".equals(e.getDepartamento())));
    }

    @Test
    @DisplayName("Debe persistir correctamente un empleado")
    void save_ShouldPersistEmpleado() {
        // Arrange
        Empleado empleado = TestDataBuilder.createEmpleado();
        empleado.setId(null);

        // Act
        Empleado saved = empleadoRepository.save(empleado);
        
        // Assert
        assertNotNull(saved.getId());
        
        Empleado found = entityManager.find(Empleado.class, saved.getId());
        assertNotNull(found);
        assertEquals("Juan", found.getNombre());
        assertEquals("Pérez", found.getApellido());
        assertEquals("juan.perez@example.com", found.getEmail());
    }
    
    @Test
    @DisplayName("Debe actualizar correctamente un empleado existente")
    void save_ShouldUpdateExistingEmpleado() {
        // Arrange
        Empleado empleado = TestDataBuilder.createEmpleado();
        empleado.setId(null);
        empleado = entityManager.persist(empleado);
        entityManager.flush();
        
        // Act
        empleado.setNombre("Juan Carlos");
        empleado.setSalario(new BigDecimal("55000.00"));
        Empleado updated = empleadoRepository.save(empleado);
        entityManager.flush();
        
        // Assert
        Empleado found = entityManager.find(Empleado.class, updated.getId());
        assertEquals("Juan Carlos", found.getNombre());
        assertEquals(new BigDecimal("55000.00"), found.getSalario());
    }
    
    @Test
    @DisplayName("Debe eliminar correctamente un empleado")
    void delete_ShouldRemoveEmpleado() {
        // Arrange
        Empleado empleado = TestDataBuilder.createEmpleado();
        empleado.setId(null);
        empleado = entityManager.persist(empleado);
        entityManager.flush();
        Long id = empleado.getId();
        
        // Act
        empleadoRepository.deleteById(id);
        entityManager.flush();
        
        // Assert
        Empleado found = entityManager.find(Empleado.class, id);
        assertNull(found);
    }
    
    @Test
    @DisplayName("Debe encontrar todos los empleados")
    void findAll_ShouldReturnAllEmpleados() {
        // Arrange
        Empleado empleado1 = TestDataBuilder.createEmpleado();
        empleado1.setId(null);
        
        Empleado empleado2 = TestDataBuilder.createEmpleado2();
        empleado2.setId(null);
        
        entityManager.persist(empleado1);
        entityManager.persist(empleado2);
        entityManager.flush();
        
        // Act
        List<Empleado> empleados = empleadoRepository.findAll();
        
        // Assert
        assertEquals(2, empleados.size());
    }
    
    @Test
    @DisplayName("Debe verificar la existencia de un empleado por ID")
    void existsById_ShouldReturnTrueForExistingId() {
        // Arrange
        Empleado empleado = TestDataBuilder.createEmpleado();
        empleado.setId(null);
        empleado = entityManager.persist(empleado);
        entityManager.flush();
        
        // Act & Assert
        assertTrue(empleadoRepository.existsById(empleado.getId()));
        assertFalse(empleadoRepository.existsById(999L));
    }
}