package com.new_.v2;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Principal {

	public static void main(String[] args) {

		// Supplier<Empleado> sup = () -> new Empleado();
		Supplier<Empleado> sup = Empleado::new;
		Empleado e1 = sup.get();
		System.out.println(e1);

		// Function<String,Empleado> fun = s -> new Empleado(s);
		Function<String, Empleado> fun = Empleado::new;
		Empleado e2 = fun.apply("Patrobas");
		System.out.println(e2);

		//BiFunction<String, Integer, Empleado> bifun = 
		//		(s, i) -> new Empleado(s, i);
		BiFunction<String, Integer, Empleado> bifun = Empleado::new;
		Empleado e3 = bifun.apply("Andronico", 20);
		System.out.println(e3);

	}

}
