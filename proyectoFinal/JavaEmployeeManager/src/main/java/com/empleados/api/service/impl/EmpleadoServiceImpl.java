package com.empleados.api.service.impl;

import com.empleados.api.dto.EmpleadoDTO;
import com.empleados.api.exception.ResourceNotFoundException;
import com.empleados.api.model.Empleado;
import com.empleados.api.repository.EmpleadoRepository;
import com.empleados.api.service.EmpleadoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the EmpleadoService interface
 */
@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public List<EmpleadoDTO> getAllEmpleados() {
        return empleadoRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmpleadoDTO getEmpleadoById(Long id) {
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado no encontrado con id: " + id));
        return convertToDTO(empleado);
    }

    @Override
    public EmpleadoDTO createEmpleado(EmpleadoDTO empleadoDTO) {
        try {
            // Check if email already exists
            if (empleadoDTO.getEmail() != null && 
                empleadoRepository.findByEmail(empleadoDTO.getEmail()).isPresent()) {
                throw new DataIntegrityViolationException("Ya existe un empleado con el email: " + empleadoDTO.getEmail());
            }
            
            Empleado empleado = convertToEntity(empleadoDTO);
            Empleado savedEmpleado = empleadoRepository.save(empleado);
            return convertToDTO(savedEmpleado);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Error al crear el empleado: " + e.getMessage());
        }
    }

    @Override
    public EmpleadoDTO updateEmpleado(Long id, EmpleadoDTO empleadoDTO) {
        Empleado existingEmpleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado no encontrado con id: " + id));

        // Check if the new email already exists and belongs to a different employee
        if (empleadoDTO.getEmail() != null && !empleadoDTO.getEmail().equals(existingEmpleado.getEmail())) {
            empleadoRepository.findByEmail(empleadoDTO.getEmail()).ifPresent(e -> {
                if (!e.getId().equals(id)) {
                    throw new DataIntegrityViolationException("Ya existe un empleado con el email: " + empleadoDTO.getEmail());
                }
            });
        }

        // Update properties
        if (empleadoDTO.getNombre() != null) {
            existingEmpleado.setNombre(empleadoDTO.getNombre());
        }
        if (empleadoDTO.getApellido() != null) {
            existingEmpleado.setApellido(empleadoDTO.getApellido());
        }
        if (empleadoDTO.getEmail() != null) {
            existingEmpleado.setEmail(empleadoDTO.getEmail());
        }
        if (empleadoDTO.getFechaContratacion() != null) {
            existingEmpleado.setFechaContratacion(empleadoDTO.getFechaContratacion());
        }
        if (empleadoDTO.getSalario() != null) {
            existingEmpleado.setSalario(empleadoDTO.getSalario());
        }
        if (empleadoDTO.getDepartamento() != null) {
            existingEmpleado.setDepartamento(empleadoDTO.getDepartamento());
        }

        Empleado updatedEmpleado = empleadoRepository.save(existingEmpleado);
        return convertToDTO(updatedEmpleado);
    }

    @Override
    public void deleteEmpleado(Long id) {
        if (!empleadoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Empleado no encontrado con id: " + id);
        }
        empleadoRepository.deleteById(id);
    }

    @Override
    public List<EmpleadoDTO> getEmpleadosByDepartamento(String departamento) {
        return empleadoRepository.findByDepartamento(departamento).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Convert Entity to DTO
     */
    private EmpleadoDTO convertToDTO(Empleado empleado) {
        EmpleadoDTO empleadoDTO = new EmpleadoDTO();
        BeanUtils.copyProperties(empleado, empleadoDTO);
        return empleadoDTO;
    }

    /**
     * Convert DTO to Entity
     */
    private Empleado convertToEntity(EmpleadoDTO empleadoDTO) {
        Empleado empleado = new Empleado();
        BeanUtils.copyProperties(empleadoDTO, empleado);
        return empleado;
    }
}
