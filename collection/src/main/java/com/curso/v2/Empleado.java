package com.curso.v2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {
	
	private String nombre;
	private int edad;
	private double sueldo;
	
}
