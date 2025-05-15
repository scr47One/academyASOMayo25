package com.curso.rule2.a;

//Primero definimos los tipos de helados
class Helado extends Object {}

class HeladoCrema extends Helado {}

class HeladoChocolate extends HeladoCrema {}

//Definimos un recipiente genérico para helados
class RecipienteHelado<T> {
	private T contenidoHelado;

	public void poner(T helado) {
		contenidoHelado = helado;
	}
	public T obtener() {
		return contenidoHelado;
	}
}

public class EjemploHeladeria {
	public static void main(String[] args) {
		
		RecipienteHelado<? super Helado> recipienteHelado = new RecipienteHelado<Helado>();
		RecipienteHelado<? super HeladoCrema> recipienteCrema;
		RecipienteHelado<? super HeladoChocolate> recipienteChocolate;
		RecipienteHelado<HeladoChocolate> recipienteChocolateSolo = null;
		
		//Sutipo por los generics
		//UPCAST
		
		recipienteCrema = recipienteHelado;
		recipienteChocolate = recipienteCrema;
		recipienteChocolate = recipienteChocolateSolo;
	}

}

