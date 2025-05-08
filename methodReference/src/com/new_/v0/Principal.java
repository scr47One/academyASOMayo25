package com.new_.v0;

import java.util.function.Supplier;

public class Principal {

	public static void main(String[] args) {

		Empleado e1 = new Empleado();
		
		//Supplier<Empleado> sup = () -> new Empleado();
		Supplier<Empleado> sup = Empleado::new;
		Empleado e2 = sup.get();
		
		System.out.println(e2);
		
	}

}
