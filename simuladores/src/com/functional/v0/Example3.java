package com.functional.v0;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Example3 {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		
		Stream<Integer> stream = numbers.stream();
		
		IntStream stream2 = stream.mapToInt(z -> z);
		
		OptionalDouble od = stream2.average();
		
		double promedio = od.orElse(0);
		
		System.out.println(promedio);
		
	}

}
