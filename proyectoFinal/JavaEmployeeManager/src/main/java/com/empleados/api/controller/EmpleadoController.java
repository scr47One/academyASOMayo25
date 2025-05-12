package com.empleados.api.controller;

import com.empleados.api.dto.EmpleadoDTO;
import com.empleados.api.service.EmpleadoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for Employee management operations
 */
@RestController
@RequestMapping("/api/empleados")
@Tag(name = "Empleado", description = "API para la gestión de empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @Autowired
    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping
    @Operation(summary = "Obtener todos los empleados", description = "Devuelve la lista de todos los empleados registrados")
    @ApiResponse(responseCode = "200", description = "Empleados encontrados", 
                content = @Content(schema = @Schema(implementation = EmpleadoDTO.class)))
    public ResponseEntity<List<EmpleadoDTO>> getAllEmpleados() {
        List<EmpleadoDTO> empleados = empleadoService.getAllEmpleados();
        return ResponseEntity.ok(empleados);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un empleado por ID", description = "Devuelve un empleado según su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Empleado encontrado", 
                    content = @Content(schema = @Schema(implementation = EmpleadoDTO.class))),
        @ApiResponse(responseCode = "404", description = "Empleado no encontrado", 
                    content = @Content)
    })
    public ResponseEntity<EmpleadoDTO> getEmpleadoById(@PathVariable Long id) {
        EmpleadoDTO empleado = empleadoService.getEmpleadoById(id);
        return ResponseEntity.ok(empleado);
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo empleado", description = "Crea un nuevo empleado con los datos proporcionados")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Empleado creado correctamente",
                    content = @Content(schema = @Schema(implementation = EmpleadoDTO.class))),
        @ApiResponse(responseCode = "400", description = "Datos inválidos", 
                    content = @Content)
    })
    public ResponseEntity<EmpleadoDTO> createEmpleado(@Valid @RequestBody EmpleadoDTO empleadoDTO) {
        EmpleadoDTO createdEmpleado = empleadoService.createEmpleado(empleadoDTO);
        return new ResponseEntity<>(createdEmpleado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un empleado", description = "Actualiza los datos de un empleado existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Empleado actualizado correctamente",
                    content = @Content(schema = @Schema(implementation = EmpleadoDTO.class))),
        @ApiResponse(responseCode = "404", description = "Empleado no encontrado", 
                    content = @Content),
        @ApiResponse(responseCode = "400", description = "Datos inválidos", 
                    content = @Content)
    })
    public ResponseEntity<EmpleadoDTO> updateEmpleado(@PathVariable Long id, @Valid @RequestBody EmpleadoDTO empleadoDTO) {
        EmpleadoDTO updatedEmpleado = empleadoService.updateEmpleado(id, empleadoDTO);
        return ResponseEntity.ok(updatedEmpleado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un empleado", description = "Elimina un empleado según su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Empleado eliminado correctamente"),
        @ApiResponse(responseCode = "404", description = "Empleado no encontrado", 
                    content = @Content)
    })
    public ResponseEntity<Void> deleteEmpleado(@PathVariable Long id) {
        empleadoService.deleteEmpleado(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/departamento/{departamento}")
    @Operation(summary = "Obtener empleados por departamento", description = "Devuelve la lista de empleados de un departamento específico")
    @ApiResponse(responseCode = "200", description = "Empleados encontrados", 
                content = @Content(schema = @Schema(implementation = EmpleadoDTO.class)))
    public ResponseEntity<List<EmpleadoDTO>> getEmpleadosByDepartamento(@PathVariable String departamento) {
        List<EmpleadoDTO> empleados = empleadoService.getEmpleadosByDepartamento(departamento);
        return ResponseEntity.ok(empleados);
    }
}
