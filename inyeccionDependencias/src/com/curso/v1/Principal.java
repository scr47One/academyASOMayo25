package com.curso.v1;
//https://hxtruong6.substack.com/p/dependency-injection-for-testable

public class Principal {
	
	static Ingrediente ingA = new Ingrediente("Res");
	static Ingrediente ingB = new Ingrediente("Puerco");
	static Ingrediente ingC = new Ingrediente("Zanahoria");


	public static void main(String[] args) {
		
		Platillo platillo1 = new Platillo(ingC);
		
		platillo1.cocinar();
		
		System.out.println("*************");
		
		Platillo platillo2 = new Platillo(ingB);

		platillo2.cocinar();


	}

}
