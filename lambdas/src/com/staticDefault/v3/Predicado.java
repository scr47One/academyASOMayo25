package com.staticDefault.v3;

public interface Predicado<T> {
	
	boolean probar(T t);
	
	static <T> Predicado<T> and(Predicado<T> pre1,Predicado<T> pre2) {
		return x -> pre1.probar(x) && pre2.probar(x);  //Funciones de Orden Superior
	}
	
	static <T> Predicado<T> or(Predicado<T> pre1,Predicado<T> pre2) {
		return x -> pre1.probar(x) || pre2.probar(x);  //Funciones de Orden Superior
	}

	static <T> Predicado<T> nor(Predicado<T> pre) {
		return x -> !pre.probar(x) ;  //Funciones de Orden Superior
	}
}
