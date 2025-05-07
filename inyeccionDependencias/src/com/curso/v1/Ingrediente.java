package com.curso.v1;

public class Ingrediente {
	
	String nombre;

	public Ingrediente(String nombre) {
		this.nombre = nombre;
		//System.out.println("Obtener ingrediente: "+nombre);
	}
	
	void preparar() {
		System.out.println("Cocinando ingrediente: "+nombre);
	}

}
