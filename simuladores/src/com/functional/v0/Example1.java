package com.functional.v0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Example1 {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		
		Stream<Integer> stream = numbers.stream();
		
		Stream<Integer> stream2 = stream.map(z -> z*10);
				
		stream2.forEach(x -> System.out.println(x));

	}

}
