package com.curso.v2;

import java.util.HashSet;
import java.util.Set;

public class Principal {

	public static void main(String[] args) {

		Book book1 = new Book(123,"Patrobas","Javascript");
		Book book2 = new Book(123,"Patrobas","Javascript");
		Book book3 = new Book(345,"Andronico","PHP");
		
		System.out.println(book1.equals(book2)); //true
		
		Set<Book> set = new HashSet<>();
		set.add(book1);
		set.add(book2);
		set.add(book3);
		
		for(Book b: set)
			System.out.println(b);

		
	}

}
