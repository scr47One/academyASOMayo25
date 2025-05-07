package com.curso.v0;

public abstract class Ave {
	abstract void volar();
}

//VIOLANDO EL PRINCIPIO DE LISKOV
class Pinguino extends Ave{
	@Override
	void volar() {
		System.out.println("No Volar");
	}
}

class Pajaro extends Ave{
	@Override
	void volar() {
		System.out.println("Volar");
	}
}

class Aguila extends Ave{
	@Override
	void volar() {
		System.out.println("Volar Veloz");
	}
}
