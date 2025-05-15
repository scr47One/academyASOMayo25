package com.curso.v1;

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
		return this.getNombre().compareTo(o.getNombre());
	}
	
//	@Override
//	public int compareTo(Empleado o) {
//		return (int)(this.getSueldo() - o.getSueldo());
//	}
	
//	@Override
//	public int compareTo(Empleado o) {
//		return this.getEdad() - o.getEdad();
//	}
	

}
