package com.curso.v0;

public class Principal {

	public static void main(String[] args) {

		Book book1 = new Book(123,"Patrobas","Javascript");
		Book book2 = new Book(123,"Patrobas","Javascript");
		
		System.out.println(book1.equals(book2)); //false
	}

}
