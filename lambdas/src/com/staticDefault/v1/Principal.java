package com.staticDefault.v1;

public class Principal {
	
	public static void main(String[] args) {
		//Predicado<String> pre1 = s -> s.isEmpty();
		Predicado<String> pre1 = String::isEmpty;
		
		boolean r = pre1.probar("Hi");
		System.out.println(r);
		
		Predicado.testStatic();
		
		pre1.testDefault();
		
	}

}
