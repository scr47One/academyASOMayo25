package com.curso.rule1;

import java.util.List;

class Ave{
	List<? extends Number> getEdad(){
		return null;
	}
}
class Aguila extends Ave{
	List<? extends Integer> getEdad(){
		return null;
	}
}
class AguilaCalva extends Aguila{
	List<Integer> getEdad(){
		return null;
	}
}

public class Principal {

	public static void main(String[] args) {
	}

}
