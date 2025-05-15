package com.set.v0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Principal1 {

	public static void main(String[] args) {

		List<String> lista = new ArrayList<>(List.of("Aa","aA","1","09","Z"));
		
		//lista.set(2, "11");
		
		Collections.sort(lista);
		
		lista.forEach(System.out::println);
		
		//09,1,Aa,Z,aA
	}

}
