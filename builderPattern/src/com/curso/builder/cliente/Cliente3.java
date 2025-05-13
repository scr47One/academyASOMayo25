package com.curso.builder.cliente;

import com.curso.builder.TareaBuilder;

import java.util.Date;

import com.curso.builder.Tarea;

public class Cliente3 {
	
	public static void main(String[] args) {
		
		Tarea tarea1 = new TareaBuilder(35)
				.setDefinidaPor("Patrobas")
				.setFechaLimite(new Date())
				.setAsignadaA("Filogono")
				.setDescripcion("De maiz azul")
				.setHecho(false)
				.setTarea("Comprar tortillas")
				.build();
		
		System.out.println(tarea1);
		
		Tarea tarea2 = new TareaBuilder(55)
				.setFechaLimite(new Date())
				.build();
		
		System.out.println(tarea2);
		
		Tarea tarea3 = new TareaBuilder(95)
				.build();
		
		System.out.println(tarea3);

	}

}
