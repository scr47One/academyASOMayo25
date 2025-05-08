package com.curso.v0;

import java.util.function.Predicate;

public class PrincipalPredicate {

	public static void main(String[] args) {
		System.out.println("***STRING***");

		//DEFINICION
		Predicate<String> pre1 = x -> x.isEmpty();
		
		//EJECUCION
		boolean r = pre1.test("");
		System.out.println(r);
		
		r = pre1.test("Hello");
		System.out.println(r);

		System.out.println("***INTEGER***");
		//DEFINICION
		Predicate<Integer> pre2 = w -> w > 1000;
		
		//EJECUCION
		r = pre2.test(500);
		System.out.println(r);
		
		r = pre2.test(1001);
		System.out.println(r);
		
		
	}

}
