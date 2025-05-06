package com.functional.v0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Example0 {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
//		List<Integer> numbers = new ArrayList<>();
//		numbers.add(1);
//		numbers.add(2);
		
		
//		List<Integer> numbers = new ArrayList<>(
//									Arrays.asList(1,2,3,4,5));
		
//		numbers.add(6);
//		numbers.remove(0);
		
		numbers.set(2, 8);
		
		System.out.println(numbers);
	}

}
