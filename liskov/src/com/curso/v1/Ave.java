package com.curso.v1;

public abstract class Ave {
	ComportamientoVolar cv; //HAS-A
	
	void puedeVolar(){
		cv.canFly();
	}
}

class Pinguino extends Ave{
	Pinguino(){
		cv = new NoVolar();
	}
}

class Aguila extends Ave{
	Aguila(){
		cv = new SiVolar();
	}
}
