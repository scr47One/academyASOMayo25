package com.curso.v0;

public class PrincipalShortCircuit {

	public static void main(String[] args) {
		
		int x=4;
		int y=8;
		
		// true   false
		if (x<5 | ++y<1) //OR
			System.out.println(y); //9
		
		// false  false
		if (x>5 & ++y<1) { //AND
		}
		
		System.out.println(y); //10

	}

}
