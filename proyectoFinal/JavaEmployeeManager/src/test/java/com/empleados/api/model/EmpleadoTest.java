package com.empleados.api.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoTest {

    private Empleado empleado1;
    private Empleado empleado2;
    private Empleado empleado3; // copia idéntica a empleado1
    private Empleado empleadoNull;

    @BeforeEach
    void setUp() {
        // Primer objeto
        empleado1 = new Empleado(
                1L,
                "Juan",
                "Pérez",
                "juan.perez@example.com",
                LocalDate.of(2020, 1, 15),
                new BigDecimal("50000.00"),
                "Tecnología"
        );

        // Segundo objeto con valores diferentes
        empleado2 = new Empleado(
                2L,
                "Ana",
                "García",
                "ana.garcia@example.com",
                LocalDate.of(2019, 5, 10),
                new BigDecimal("48000.00"),
                "Recursos Humanos"
        );

        // Tercer objeto idéntico al primero para pruebas de equals y hashCode
        empleado3 = new Empleado(
                1L,
                "Juan",
                "Pérez",
                "juan.perez@example.com",
                LocalDate.of(2020, 1, 15),
                new BigDecimal("50000.00"),
                "Tecnología"
        );

        // Objeto nulo para pruebas de equals
        empleadoNull = null;
    }

    @Test
    @DisplayName("Test de equals con mismo objeto")
    void testEqualsSameObject() {
        // El objeto debe ser igual a sí mismo
        assertTrue(empleado1.equals(empleado1));
    }

    @Test
    @DisplayName("Test de equals con objetos iguales")
    void testEqualsEqualObjects() {
        // Dos objetos con los mismos valores deben ser considerados iguales
        assertTrue(empleado1.equals(empleado3));
        assertTrue(empleado3.equals(empleado1));
    }

    @Test
    @DisplayName("Test de equals con objetos diferentes")
    void testEqualsDifferentObjects() {
        // Dos objetos con valores diferentes no deben ser iguales
        assertFalse(empleado1.equals(empleado2));
        assertFalse(empleado2.equals(empleado1));
    }

    @Test
    @DisplayName("Test de equals con null")
    void testEqualsWithNull() {
        // La comparación con null debe retornar false
        assertFalse(empleado1.equals(empleadoNull));
    }

    @Test
    @DisplayName("Test de equals con otra clase")
    void testEqualsWithDifferentClass() {
        // La comparación con un objeto de otra clase debe retornar false
        assertFalse(empleado1.equals(new Object()));
    }

    @Test
    @DisplayName("Test de hashCode para objetos iguales")
    void testHashCodeEqualObjects() {
        // Dos objetos iguales deben tener el mismo hashCode
        assertEquals(empleado1.hashCode(), empleado3.hashCode());
    }

    @Test
    @DisplayName("Test de hashCode para objetos diferentes")
    void testHashCodeDifferentObjects() {
        // Dos objetos diferentes probablemente tendrán hashCodes diferentes
        // (aunque no es garantizado por el contrato de hashCode, es una buena práctica)
        assertNotEquals(empleado1.hashCode(), empleado2.hashCode());
    }

    @Test
    @DisplayName("Test del método toString")
    void testToString() {
        // Verificar que toString contiene la información relevante
        String toStringResult = empleado1.toString();
        assertTrue(toStringResult.contains("id=1"));
        assertTrue(toStringResult.contains("nombre=Juan"));
        assertTrue(toStringResult.contains("apellido=Pérez"));
        assertTrue(toStringResult.contains("email=juan.perez@example.com"));
        assertTrue(toStringResult.contains("2020-01-15")); // Fecha de contratación
        assertTrue(toStringResult.contains("50000")); // Parte del salario
        assertTrue(toStringResult.contains("departamento=Tecnología"));
    }

    @Test
    @DisplayName("Test del método canEqual")
    void testCanEqual() {
        // El método canEqual debe retornar true para objetos de la misma clase
        assertTrue(empleado1.canEqual(empleado2));
        
        // y false para objetos de diferente clase
        assertFalse(empleado1.canEqual(new Object()));
    }

    @Test
    @DisplayName("Test de equals con campos específicos modificados")
    void testEqualsWithModifiedFields() {
        // Crear una copia y modificar campos para ver qué afecta a equals
        Empleado modified = new Empleado(
                1L, // mismo ID
                "Juan Modificado", // nombre distinto
                "Pérez",
                "juan.perez@example.com",
                LocalDate.of(2020, 1, 15),
                new BigDecimal("50000.00"),
                "Tecnología"
        );
        
        // Debería ser distinto porque el nombre cambió
        assertFalse(empleado1.equals(modified));
        
        // Ahora modificamos solo el email
        modified = new Empleado(
                1L,
                "Juan",
                "Pérez",
                "juan.modificado@example.com", // email distinto
                LocalDate.of(2020, 1, 15),
                new BigDecimal("50000.00"),
                "Tecnología"
        );
        
        // Debería ser distinto porque el email cambió
        assertFalse(empleado1.equals(modified));
    }
    
    @Test
    @DisplayName("Test de equals con ID nulo")
    void testEqualsWithNullId() {
        // Crear objetos con ID nulo pero mismo contenido
        Empleado emp1WithNullId = new Empleado(
                null,
                "Juan",
                "Pérez",
                "juan.perez@example.com",
                LocalDate.of(2020, 1, 15),
                new BigDecimal("50000.00"),
                "Tecnología"
        );
        
        Empleado emp2WithNullId = new Empleado(
                null,
                "Juan",
                "Pérez",
                "juan.perez@example.com",
                LocalDate.of(2020, 1, 15),
                new BigDecimal("50000.00"),
                "Tecnología"
        );
        
        // Deberían ser iguales basado en los otros campos
        assertTrue(emp1WithNullId.equals(emp2WithNullId));
    }
    
    @Test
    @DisplayName("Test de equals con todos los campos nulos")
    void testEqualsWithAllFieldsNull() {
        Empleado emptyEmp1 = new Empleado();
        Empleado emptyEmp2 = new Empleado();
        
        // Dos objetos vacíos deberían ser iguales
        assertTrue(emptyEmp1.equals(emptyEmp2));
        assertTrue(emptyEmp2.equals(emptyEmp1));
        
        // El hashCode debería ser el mismo
        assertEquals(emptyEmp1.hashCode(), emptyEmp2.hashCode());
    }
}