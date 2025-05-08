package com.new_.v2;

public class Empleado {
	
	String nombre = "Sin Nombre";
	int edad = 0;
	
	public Empleado(){}
	
	public Empleado(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public Empleado(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", edad=" + edad + "]";
	}

	
}
