package com.curso.v1;

class Ave {
	private final static String s="Hello";
	final static void volar() {};
}

class Aguila extends Ave {
	//NO HIDDEN 
	//static void volar() {};
	String s="Hello";
}

public class Principal {

	public static void main(String[] args) {
		

		
	}

}
