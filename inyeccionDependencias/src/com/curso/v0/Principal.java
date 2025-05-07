package com.curso.v0;
//https://hxtruong6.substack.com/p/dependency-injection-for-testable

public class Principal {

	public static void main(String[] args) {
		
		Platillo platillo1 = new Platillo();
		
		platillo1.cocinar();
		
		System.out.println("*************");
		
		Platillo platillo2 = new Platillo();

		platillo2.cocinar();


	}

}
