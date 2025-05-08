package com.staticDefault.v2;

public class Principal {
	
	public static void main(String[] args) {
		boolean r = false;
		Predicado<String> pre1 = s -> s.endsWith("a");
		Predicado<String> pre2 = w -> w.contains("v");
		
		Predicado<String> pre3 = Predicado.and(pre1, pre2);
		
		r = pre3.probar("Pythona");
		System.out.println("Pythona: "+r);
		
		r = pre3.probar("Java");
		System.out.println("Java: "+r);
		
	}

}
