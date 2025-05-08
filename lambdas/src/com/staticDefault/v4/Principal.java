package com.staticDefault.v4;

public class Principal {
	
	public static void main(String[] args) {
		boolean r = false;
		Predicado<String> pre1 = s -> s.endsWith("a");
		Predicado<String> pre2 = w -> w.contains("v");
		
		System.out.println("***and***");
		Predicado<String> pre3 = pre1.and(pre2);
		
		r = pre3.probar("Python");
		System.out.println("Python: "+r);
		
		r = pre3.probar("Java");
		System.out.println("Java: "+r);
		
		System.out.println("***or***");
		Predicado<String> pre4 = pre1.or(pre2);
		
		r = pre4.probar("Pvython");
		System.out.println("Pvython: "+r);
		
		r = pre4.probar("Java");
		System.out.println("Java: "+r);
		
		System.out.println("***nor***");
		Predicado<String> pre5 = pre1.nor();
		
		r = pre5.probar("Pvython");
		System.out.println("Pvython: "+r);
		
		
	}

}
