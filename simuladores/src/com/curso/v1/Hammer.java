package com.curso.v1;

class Tool{
	private void repair() {}
	Number use() {return 0;}
	//public, protected, default*, private
}

public class Hammer extends Tool {
	private int repair() {return 0;}
	@Override
	Integer use() { return 0; } //COVARIANZA
}
