package com.curso.v0;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class TestClass {
	
	public static boolean checkList(List list, Predicate<List> p) {
		       //EJECUTA PREDICATE
		return p.test(list);
	}

	
	public static void main(String[] args) {
		//                                    
		boolean b = checkList(
				//               al -> al.isEmpty() //CORRECTA
				//               ArrayList al -> al.isEmpty() //INCORRECTA. (List al)
				//               al -> return al.size() == 0 //INCORRECTA. {return al.size() == 0;}) 
				new ArrayList(),al -> al.add("hello")); 
		System.out.println(b);
	}
}






