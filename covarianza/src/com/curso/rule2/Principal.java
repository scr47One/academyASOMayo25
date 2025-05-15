package com.curso.rule2;

import java.util.List;

class Ave{
	List<? super Float> getEdades(){
		return null;
	}
}
class Aguila extends Ave{
	@Override
	List<? super Number> getEdades(){
		return null;
	}
}
class AguilaCalva extends Aguila{
	@Override
	List<Number> getEdades(){
		return null;
	}

}

public class Principal {

	public static void main(String[] args) {
	}

}
