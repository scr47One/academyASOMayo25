package com.curso.v0;

public class Principal2 {

	public static void main(String... args) {
				
		System.out.println("Hello varargs");
		
		System.out.println("Array");
		showArray(new String[]{});
		showArray(new String[]{"a"});
		showArray(new String[]{"a","b","c","d"});
		
		System.out.println("Varargs");
		showVarargs();
		showVarargs("a");
		showVarargs("a","b","c","d");
		showVarargs("a","b","c","d","e","f");

	
	}
	
	static void showArray(String[] array) {
		System.out.println(array.length);
	}
	
	static void showVarargs(String... array) {
		System.out.println(array.length);
	}
	

}
