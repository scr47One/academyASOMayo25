package com.wildcard.v1;

import java.util.ArrayList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		List<Object> listaObject = new ArrayList<>();
		listaObject.add(new Object());
		listaObject.add(new String("Hola"));
		listaObject.add(new StringBuilder("Hello"));
		listaObject.add(Integer.valueOf(5));
		System.out.println("***List<Object>***");
		imprimirObject(listaObject);
		imprimir(listaObject);
		
		List<String> listaString = new ArrayList<>();
		listaString.add(new String("Hola1"));
		listaString.add(new String("Hola2"));
		listaString.add("Hola3");
		System.out.println("***List<String>***");
		//imprimirObject(listaString);
		imprimir(listaString);
		
		List<Circulo> listaCirculo = new ArrayList<>();
		listaCirculo.add(new Circulo(1.0));
		listaCirculo.add(new Circulo(1.0));
		System.out.println("***List<Circulo>***");
		//imprimirObject(listaCirculo);
		imprimir(listaCirculo);
		
		List<Cuadrado> listaCuadrado = new ArrayList<>();
		listaCuadrado.add(new Cuadrado(1.0));
		listaCuadrado.add(new Cuadrado(1.0));
		System.out.println("***List<Cuadrado>***");
		//imprimirObject(listaCuadrado);
		imprimir(listaCuadrado);

		List<Triangulo> listaTriangulo = new ArrayList<>();
		listaTriangulo.add(new Triangulo(4.0));
		listaTriangulo.add(new Triangulo(2.0));
		System.out.println("***List<Triangulo>***");
		//imprimirObject(listaTriangulo);
		imprimir(listaTriangulo);

		List<Figura> listaFigura = new ArrayList<>();
		listaFigura.add(new Circulo(1.0));
		listaFigura.add(new Cuadrado(1.0));
		listaFigura.add(new Triangulo(1.0));
		listaFigura.add(new Figura(1.0));
		System.out.println("***List<Figura>***");
		//imprimirObject(listaFigura);
		imprimir(listaFigura);
		
		List<?> lista;
		
		lista = listaObject;
		lista = listaString;
		lista = listaCirculo;
		lista = listaCuadrado;
		lista = listaTriangulo;
		lista = listaFigura;

	}
	
	static void imprimirObject(List<Object> lista) {
		lista.add(Integer.MAX_VALUE);
		lista.remove(0);
		for (Object o:lista)
			System.out.println(o);
	}
	
	static void imprimir(List<?> lista) {
		//lista.add(new Object()); //NO SE PUEDE
		//lista.remove(0); //SI SE PUEDE
		for (Object o:lista)
			System.out.println(o);
	}
}

class Figura{
	private double area;
	public Figura(double area) {
		this.area = area;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	@Override
	public String toString() {
		return this.getClass().getSimpleName()+
				" [area=" + area + "]";
	}
}

class Circulo extends Figura{
	public Circulo(double area) {
		super(area);
	}
}

class Cuadrado extends Figura{
	public Cuadrado(double area) {
		super(area);
	}
}

class Triangulo extends Figura{
	public Triangulo(double area) {
		super(area);
	}
}

