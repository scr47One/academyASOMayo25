package com.wildcard.v5;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

	public static void main(String[] args) {
		// Crear un nuevo HashMap
		Map<Number, CharSequence> hashMapDestino = new HashMap<>();
		
		//putAll(Map<? extends K,? extends V> m)
		//Copies all of the mappings from the specified map to this map.
	
		Map<Integer, String> hashMapOrigen = new HashMap<>();
		hashMapOrigen.put(10, "Diez");
		hashMapOrigen.put(20, "Veinte");
		hashMapOrigen.put(30, "Treinta");
		hashMapOrigen.put(40, "Cuarenta");

		System.out.println("***Origen***");
		hashMapOrigen.forEach((x,y)->System.out.println("Clave: "+x+", Valor: "+y));
		
		hashMapDestino.putAll(hashMapOrigen);
		
		System.out.println("***Destino***");
		hashMapDestino.forEach((x,y)->System.out.println("Clave: "+x+", Valor: "+y));
		
	}

}

