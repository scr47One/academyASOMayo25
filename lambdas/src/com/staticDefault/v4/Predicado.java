package com.staticDefault.v4;

public interface Predicado<T> {
	
	boolean probar(T t);
	
	default Predicado<T> and(Predicado<T> pre) {
		return x -> this.probar(x) && pre.probar(x);  //Funciones de Orden Superior
	}
	
	default Predicado<T> or(Predicado<T> pre) {
		return x -> this.probar(x) || pre.probar(x);  //Funciones de Orden Superior
	}

	default Predicado<T> nor() {
		return x -> !this.probar(x) ;  //Funciones de Orden Superior
	}
}
