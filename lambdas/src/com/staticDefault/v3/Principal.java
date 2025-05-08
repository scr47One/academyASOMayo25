package com.staticDefault.v3;

public class Principal {
	
	public static void main(String[] args) {
		boolean r = false;
		Predicado<String> pre1 = s -> s.endsWith("a");
		Predicado<String> pre2 = w -> w.contains("v");
		
		Predicado<String> pre3 = Predicado.nor(pre2);
		
		r = pre3.probar("Python");
		System.out.println("Python: "+r);
		
	}

}
