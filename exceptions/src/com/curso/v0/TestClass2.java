package com.curso.v0;

class TestClass2 {

	public static void main(String args[]) {
		int i = 0;

		System.out.println("Loop Lable line"); //<<< I

		try {
			for (; true; i++) {
				System.out.println("i: " +i); //<<< i: 0,1,2,3,4 II
				if (i > 5) 
					break; 
				else if (i == 4)
					throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("Exception in loop."); //<<< III
		} finally {
			System.out.println("In Finally"); // <<< IV
		}

	}

}