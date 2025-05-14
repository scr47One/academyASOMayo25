package com.curso.v4;

public class Contenedor<T extends Transporte> {

    private T t;

	public Contenedor(T t) {
		this.t = t;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	@Override
	public String toString() {
		return "Contenedor [t=" + t + "]";
	}
   
}
