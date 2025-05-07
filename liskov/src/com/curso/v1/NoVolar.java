package com.curso.v1;

public class NoVolar implements ComportamientoVolar {

	@Override
	public void canFly() {
		System.out.println("No puedo Volar");
	}

}
