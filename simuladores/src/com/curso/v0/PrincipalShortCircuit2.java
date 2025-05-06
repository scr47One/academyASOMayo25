package com.curso.v0;

public class PrincipalShortCircuit2 {

	public static void main(String[] args) {
		
		int x=4;
		int y=8;
		
		// true    
		if (x<5 || ++y<1) //OR
			System.out.println(y); //8
		
		// false  
		if (x>5 && ++y<1) { //AND
		}
		
		System.out.println(y); //8

	}

}
