package com.empleados.api.service;

import com.empleados.api.dto.EmpleadoDTO;

import java.util.List;

/**
 * Service interface for employee management operations
 */
public interface EmpleadoService {

    /**
     * Get all employees
     * 
     * @return a list of all employees
     */
    List<EmpleadoDTO> getAllEmpleados();

    /**
     * Get an employee by ID
     * 
     * @param id the employee ID
     * @return the employee with the specified ID
     */
    EmpleadoDTO getEmpleadoById(Long id);

    /**
     * Create a new employee
     * 
     * @param empleadoDTO the employee data
     * @return the created employee
     */
    EmpleadoDTO createEmpleado(EmpleadoDTO empleadoDTO);

    /**
     * Update an existing employee
     * 
     * @param id the employee ID
     * @param empleadoDTO the updated employee data
     * @return the updated employee
     */
    EmpleadoDTO updateEmpleado(Long id, EmpleadoDTO empleadoDTO);

    /**
     * Delete an employee
     * 
     * @param id the employee ID
     */
    void deleteEmpleado(Long id);

    /**
     * Get employees by department
     * 
     * @param departamento the department
     * @return a list of employees in the specified department
     */
    List<EmpleadoDTO> getEmpleadosByDepartamento(String departamento);
}
