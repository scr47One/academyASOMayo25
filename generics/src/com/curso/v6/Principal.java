package com.curso.v6;

public class Principal {

	public static void main(String[] args) {
		Integer[] intArray = { 1, 2, 3, 4, 5 };
		Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
		Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };
		
		show(intArray);
		show(doubleArray);
		show(charArray);

	}

	private static <T> void show(T[] inputArray) {
		for (T t : inputArray) {
			System.out.println("Elemento: " + t);
		}
		System.out.println("*******");
	}

}
