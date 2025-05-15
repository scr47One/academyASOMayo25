package com.curso.v0;

class Ave{
	long getEdad(){
		return 0L;
	}
	CharSequence getNombre() {
		return null;
	}
}
class Pinguino extends Ave{
	@Override
	long getEdad(){
		return 0;
	}
	@Override
	StringBuilder getNombre() { //COVARIANZA
		return new StringBuilder("pinguin");
	}
}

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
