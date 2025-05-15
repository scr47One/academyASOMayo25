package com.set.v0;

import java.util.Arrays;

public class Principal0 {
	
	public static void main(String[] args) {

		String[] arreglo = {"Aa","aA","1","09","Z"};
		
		arreglo[2] = "11";
		
		Arrays.sort(arreglo);
		
		System.out.println(Arrays.toString(arreglo));
		
		//09,1,Aa,Z,aA
	}

}
