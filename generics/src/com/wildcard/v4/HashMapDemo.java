package com.wildcard.v4;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

	public static void main(String[] args) {
		// Crear un nuevo HashMap
		Map<Number, Figura> hashMapDestino = new HashMap<>();
		
		//putAll(Map<? extends K,? extends V> m)
		//Copies all of the mappings from the specified map to this map.
	
		Map<Integer, Circulo> hashMapOrigen = new HashMap<>();
		hashMapOrigen.put(10, new Circulo(1));
		hashMapOrigen.put(20, new Circulo(2));
		hashMapOrigen.put(30, new Circulo(3));
		hashMapOrigen.put(40, new Circulo(4));

		System.out.println("***Origen***");
		hashMapOrigen.forEach((x,y)->System.out.println("Clave: "+x+", Valor: "+y));
		
		hashMapDestino.putAll(hashMapOrigen);
		
		System.out.println("***Destino***");
		hashMapDestino.forEach((x,y)->System.out.println("Clave: "+x+", Valor: "+y));
		
		
		
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

