package com.wildcard.v2;

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
		//imprimir(listaObject);
		
		List<String> listaString = new ArrayList<>();
		listaString.add(new String("Hola1"));
		listaString.add(new String("Hola2"));
		listaString.add("Hola3");
		System.out.println("***List<String>***");
		//imprimir(listaString);
		
		List<Circulo> listaCirculo = new ArrayList<>();
		listaCirculo.add(new Circulo(1.0));
		listaCirculo.add(new Circulo(1.0));
		System.out.println("***List<Circulo>***");
		imprimir(listaCirculo);
		
		List<Cuadrado> listaCuadrado = new ArrayList<>();
		listaCuadrado.add(new Cuadrado(1.0));
		listaCuadrado.add(new Cuadrado(1.0));
		System.out.println("***List<Cuadrado>***");
		imprimir(listaCuadrado);

		List<Triangulo> listaTriangulo = new ArrayList<>();
		listaTriangulo.add(new Triangulo(4.0));
		listaTriangulo.add(new Triangulo(2.0));
		System.out.println("***List<Triangulo>***");
		imprimir(listaTriangulo);

		List<Figura> listaFigura = new ArrayList<>();
		listaFigura.add(new Circulo(1.0));
		listaFigura.add(new Cuadrado(1.0));
		listaFigura.add(new Triangulo(1.0));
		listaFigura.add(new Figura(1.0));
		System.out.println("***List<Figura>***");
		imprimir(listaFigura);
		
		List<? extends Figura> lista;
		
		//lista = listaObject;
		//lista = listaString;
		lista = listaCirculo;
		lista = listaCuadrado;
		lista = listaTriangulo;
		lista = listaFigura;

	}
	
	static void imprimir(List<? extends Figura> lista) {
		//lista.add(new Figura(0.0)); //NO SE PUEDE
		//lista.remove(0); //SI SE PUEDE
		for (Figura o:lista) {
			System.out.println(o);
			System.out.println(o.getArea());
		}
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

