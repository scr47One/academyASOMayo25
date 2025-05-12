package com.curso.v0;

public class Principal {

	public static void main(String[] args) {
		
		//PRIMITIVOS ES UN CONSTANTE
		final int i = 5;
		//i = 10;
		System.out.println(i);
		
		//OBJETO: NO SE PUEDE CAMBIAR LA REFERENCIA
		final StringBuilder sb = new StringBuilder("Hello");
		sb.append(" World");
		System.out.println(sb); //Hello World
		//sb = null;
		
		final String s = "Hola";
		s.concat(" Mundo");
		System.out.println(s);
		//s = null;
		
	}

}
