package com.curso.v1;

public class Principal {

	public static void main(String[] args) {

		System.out.println("Aguila");
		Aguila ave1 = new Aguila();
		ave1.puedeVolar();
		System.out.println("******");
		System.out.println("Pinguino");
		Pinguino ave2 = new Pinguino();
		ave2.puedeVolar();
	}

}
