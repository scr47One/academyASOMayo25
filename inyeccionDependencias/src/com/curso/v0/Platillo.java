package com.curso.v0;

public class Platillo {
	
	private Ingrediente ingrediente;

	public Platillo() {
		//Problema: Altamente acoplado
		this.ingrediente = new Ingrediente("Res");
	}
	
	public void cocinar() {
		ingrediente.preparar();
		System.out.println("Cocinando el platillo");
	}

}
