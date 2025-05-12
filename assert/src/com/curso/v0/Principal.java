package com.curso.v0;

public class Principal {
	
	public static void main(String[] args) {
		
		procesarEdad(17);
		
	}
	
	
	static public void procesarEdad(int edad) {
	    // Suponemos que la edad ya ha sido validada y debe ser positiva
	    assert edad >= 18: "No puede ser menor de Edad"; // Si la edad es menor a 18, lanzará AssertionError

	    System.out.println("Procesando edad: " + edad);
	}

}
