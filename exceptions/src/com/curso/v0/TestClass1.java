package com.curso.v0;

class TestClass1 {

	public static void main(String args[]) {
		int i = 0;

		System.out.println("Loop Lable line"); //<<<

		try {
			for (; true; i++) {
				System.out.println("i: " +i); //<<< i: 0,1,2,3,4,5,6
				if (i > 5) 
					break; 
			}
		} catch (Exception e) {
			System.out.println("Exception in loop.");
		} finally {
			System.out.println("In Finally"); // <<<
		}

	}

}