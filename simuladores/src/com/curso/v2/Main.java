package com.curso.v2;

public class Main {
	
	public static void main(String[] args) {
		int[] numeros = {1,2,3,4,5};
		int suma = 0;
		for (int i=1;i<numeros.length;i++) {
			suma += numeros[i];
		}
		
		System.out.println("La suma es: "+suma);
		
		System.out.println("*****");
		
		String s = "hello";
		
		s.toUpperCase();
		
		System.out.println(s);
		
	}

}
