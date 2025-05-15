package com.curso.v0;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empleado implements Comparable<Empleado> {
	
	private String nombre;
	private int edad;
	private double sueldo;
	
	@Override
	public int compareTo(Empleado o) {
		if (this.getEdad() > o.getEdad())
			return 99;
		else if (this.getEdad() < o.getEdad())
			return -9;
		else 
			return 0;
			
	}
	
	

}
