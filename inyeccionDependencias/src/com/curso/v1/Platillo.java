package com.curso.v1;

public class Platillo {
	
	private Ingrediente ingrediente;

	//INYECCION POR CONSTRUCTOR
	public Platillo(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}
	
	public void cocinar() {
		ingrediente.preparar();
		System.out.println("Cocinando el platillo");
	}

}
