package com.set.v0;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Principal2 {

	public static void main(String[] args) {

		Set<String> set = new HashSet<>(List.of("1","Aa","aA","1","09","Z","1"));
				
		set.forEach(System.out::println);
		
	}

}
