package com.curso.rule2.a;

public class Principal {

	public static void main(String[] args) {
		
		//UPCAST
		
		Integer integer = Integer.valueOf(5);
		
		Number number = integer;
		
		Object object = number;
		
		//-----------------
		
		//DOWNCAST
		
		Object object1 = Integer.valueOf(10);
		
		Number number1 = (Number)object1;
		
		Integer integer1 = (Integer)number1;
		
	}

}
