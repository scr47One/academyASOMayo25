package com.set.v0;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Principal3 {

	public static void main(String[] args) {

		Set<String> set = new TreeSet<>(List.of("1","Aa","aA","1","09","Z","1"));
				
		set.forEach(System.out::println);
		
	}

}
