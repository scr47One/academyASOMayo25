package com.new_.v1;

public class Empleado {
	
	String nombre = "Sin Nombre";
	
	public Empleado(){}
	
	public Empleado(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + "]";
	}

	
}
