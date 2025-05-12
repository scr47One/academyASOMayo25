package com.empleados.api.util;

import com.empleados.api.dto.EmpleadoDTO;
import com.empleados.api.model.Empleado;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase utilitaria para generar datos de prueba
 */
public class TestDataBuilder {

    /**
     * Crea un objeto Empleado para pruebas
     */
    public static Empleado createEmpleado() {
        return new Empleado(
                1L,
                "Juan",
                "Pérez",
                "juan.perez@example.com",
                LocalDate.of(2020, 1, 15),
                new BigDecimal("50000.00"),
                "Tecnología"
        );
    }

    /**
     * Crea un objeto EmpleadoDTO para pruebas
     */
    public static EmpleadoDTO createEmpleadoDTO() {
        return new EmpleadoDTO(
                1L,
                "Juan",
                "Pérez",
                "juan.perez@example.com",
                LocalDate.of(2020, 1, 15),
                new BigDecimal("50000.00"),
                "Tecnología"
        );
    }

    /**
     * Crea un segundo Empleado con datos diferentes para pruebas
     */
    public static Empleado createEmpleado2() {
        return new Empleado(
                2L,
                "Ana",
                "García",
                "ana.garcia@example.com",
                LocalDate.of(2019, 5, 10),
                new BigDecimal("48000.00"),
                "Recursos Humanos"
        );
    }

    /**
     * Crea un segundo EmpleadoDTO con datos diferentes para pruebas
     */
    public static EmpleadoDTO createEmpleadoDTO2() {
        return new EmpleadoDTO(
                2L,
                "Ana",
                "García",
                "ana.garcia@example.com",
                LocalDate.of(2019, 5, 10),
                new BigDecimal("48000.00"),
                "Recursos Humanos"
        );
    }

    /**
     * Crea un nuevo EmpleadoDTO sin ID (para creación)
     */
    public static EmpleadoDTO createNewEmpleadoDTO() {
        return new EmpleadoDTO(
                null,
                "Carlos",
                "Rodríguez",
                "carlos.rodriguez@example.com",
                LocalDate.of(2021, 3, 22),
                new BigDecimal("52000.00"),
                "Tecnología"
        );
    }

    /**
     * Crea un EmpleadoDTO con datos inválidos para pruebas
     */
    public static EmpleadoDTO createInvalidEmpleadoDTO() {
        return new EmpleadoDTO(
                null,
                "", // Nombre vacío (inválido)
                "", // Apellido vacío (inválido)
                "email-invalido", // Email inválido
                LocalDate.now().plusDays(1), // Fecha futura (inválida)
                new BigDecimal("-1000.00"), // Salario negativo
                ""
        );
    }

    /**
     * Crea una lista de EmpleadoDTO para pruebas
     */
    public static List<EmpleadoDTO> createEmpleadoDTOList() {
        List<EmpleadoDTO> empleados = new ArrayList<>();
        empleados.add(createEmpleadoDTO());
        empleados.add(createEmpleadoDTO2());
        return empleados;
    }

    /**
     * Crea una lista de Empleado para pruebas
     */
    public static List<Empleado> createEmpleadoList() {
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(createEmpleado());
        empleados.add(createEmpleado2());
        return empleados;
    }

    /**
     * Crea una lista de Empleados por departamento
     */
    public static List<Empleado> createEmpleadosByDepartamento(String departamento) {
        List<Empleado> empleados = new ArrayList<>();
        
        if ("Tecnología".equals(departamento)) {
            empleados.add(createEmpleado());
        } else if ("Recursos Humanos".equals(departamento)) {
            empleados.add(createEmpleado2());
        }
        
        return empleados;
    }

    /**
     * Crea una lista de EmpleadosDTO por departamento
     */
    public static List<EmpleadoDTO> createEmpleadosDTOByDepartamento(String departamento) {
        List<EmpleadoDTO> empleados = new ArrayList<>();
        
        if ("Tecnología".equals(departamento)) {
            empleados.add(createEmpleadoDTO());
        } else if ("Recursos Humanos".equals(departamento)) {
            empleados.add(createEmpleadoDTO2());
        }
        
        return empleados;
    }
}