package com.empleados.api.repository;

import com.empleados.api.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Empleado entity to handle database operations
 */
@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    
    /**
     * Find an employee by email
     * 
     * @param email the email to search for
     * @return an Optional containing the employee if found
     */
    Optional<Empleado> findByEmail(String email);
    
    /**
     * Find employees by department
     * 
     * @param departamento the department to search for
     * @return a list of employees in the specified department
     */
    List<Empleado> findByDepartamento(String departamento);
}
