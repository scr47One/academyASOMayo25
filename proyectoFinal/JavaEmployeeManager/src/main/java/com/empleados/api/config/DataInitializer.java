package com.empleados.api.config;

import com.empleados.api.model.Empleado;
import com.empleados.api.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

/**
 * Clase para inicializar datos de prueba
 */
@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(EmpleadoRepository empleadoRepository) {
        return args -> {
            // Verificamos si ya hay datos cargados
            if (empleadoRepository.count() == 0) {
                // Creamos 20 empleados de prueba
                Empleado[] empleados = {
                    new Empleado(null, "Juan", "Pérez", "juan.perez@example.com", 
                        LocalDate.of(2020, 1, 15), new BigDecimal("50000.00"), "Tecnología"),
                    
                    new Empleado(null, "Ana", "García", "ana.garcia@example.com", 
                        LocalDate.of(2019, 5, 10), new BigDecimal("48000.00"), "Recursos Humanos"),
                    
                    new Empleado(null, "Carlos", "Rodríguez", "carlos.rodriguez@example.com", 
                        LocalDate.of(2021, 3, 22), new BigDecimal("52000.00"), "Tecnología"),
                    
                    new Empleado(null, "María", "López", "maria.lopez@example.com", 
                        LocalDate.of(2018, 11, 5), new BigDecimal("55000.00"), "Finanzas"),
                    
                    new Empleado(null, "Pedro", "Martínez", "pedro.martinez@example.com", 
                        LocalDate.of(2022, 2, 14), new BigDecimal("45000.00"), "Marketing"),
                    
                    new Empleado(null, "Laura", "Sánchez", "laura.sanchez@example.com", 
                        LocalDate.of(2017, 7, 20), new BigDecimal("60000.00"), "Ventas"),
                    
                    new Empleado(null, "Miguel", "González", "miguel.gonzalez@example.com", 
                        LocalDate.of(2021, 9, 30), new BigDecimal("47000.00"), "Tecnología"),
                    
                    new Empleado(null, "Sofía", "Fernández", "sofia.fernandez@example.com", 
                        LocalDate.of(2019, 4, 12), new BigDecimal("49000.00"), "Recursos Humanos"),
                    
                    new Empleado(null, "Javier", "Díaz", "javier.diaz@example.com", 
                        LocalDate.of(2020, 6, 8), new BigDecimal("51000.00"), "Finanzas"),
                    
                    new Empleado(null, "Carmen", "Ruiz", "carmen.ruiz@example.com", 
                        LocalDate.of(2022, 1, 17), new BigDecimal("46000.00"), "Marketing"),
                    
                    new Empleado(null, "David", "Moreno", "david.moreno@example.com", 
                        LocalDate.of(2018, 8, 25), new BigDecimal("58000.00"), "Ventas"),
                    
                    new Empleado(null, "Elena", "Jiménez", "elena.jimenez@example.com", 
                        LocalDate.of(2019, 12, 3), new BigDecimal("54000.00"), "Tecnología"),
                    
                    new Empleado(null, "Alberto", "Torres", "alberto.torres@example.com", 
                        LocalDate.of(2021, 5, 19), new BigDecimal("49500.00"), "Recursos Humanos"),
                    
                    new Empleado(null, "Lucía", "Vargas", "lucia.vargas@example.com", 
                        LocalDate.of(2020, 10, 7), new BigDecimal("53000.00"), "Finanzas"),
                    
                    new Empleado(null, "Roberto", "Reyes", "roberto.reyes@example.com", 
                        LocalDate.of(2017, 3, 14), new BigDecimal("62000.00"), "Ventas"),
                    
                    new Empleado(null, "Isabel", "Navarro", "isabel.navarro@example.com", 
                        LocalDate.of(2022, 4, 29), new BigDecimal("47500.00"), "Marketing"),
                    
                    new Empleado(null, "Fernando", "Castro", "fernando.castro@example.com", 
                        LocalDate.of(2019, 2, 11), new BigDecimal("56000.00"), "Tecnología"),
                    
                    new Empleado(null, "Marta", "Ortega", "marta.ortega@example.com", 
                        LocalDate.of(2018, 6, 22), new BigDecimal("59000.00"), "Finanzas"),
                    
                    new Empleado(null, "Pablo", "Gallego", "pablo.gallego@example.com", 
                        LocalDate.of(2021, 11, 9), new BigDecimal("48500.00"), "Recursos Humanos"),
                    
                    new Empleado(null, "Cristina", "Vega", "cristina.vega@example.com", 
                        LocalDate.of(2020, 8, 3), new BigDecimal("52500.00"), "Marketing")
                };
                
                empleadoRepository.saveAll(Arrays.asList(empleados));
                
                System.out.println("¡Se han cargado 20 empleados de prueba en la base de datos!");
            }
        };
    }
}