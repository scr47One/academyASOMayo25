package com.functional.v0;

import java.util.Arrays;
import java.util.List;

public class Example {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		
		double result = numbers.stream()
						.mapToInt(z -> z)
						.average()
						.orElse(0);
		
		System.out.println(result);
		
	}

}
