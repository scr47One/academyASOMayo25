package com.staticDefault.v0;

public class Principal {
	
	public static void main(String[] args) {
		//Predicado<String> pre1 = s -> s.isEmpty();
		Predicado<String> pre1 = String::isEmpty;
		
		boolean r = pre1.probar("Hi");
		System.out.println(r);
		
	}

}
