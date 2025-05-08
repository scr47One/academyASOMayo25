package com.staticDefault.v1;

public interface Predicado<T> {
	
	boolean probar(T t);
	
	static void testStatic() {
		System.out.println("Probar static ");
	}
	
	default void testDefault() {
		System.out.println("Probar default ");
	}

}
