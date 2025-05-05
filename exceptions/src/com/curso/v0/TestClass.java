package com.curso.v0;

class TestClass {

	public static void main(String args[]) {
		int i = 0;

		PATITO: 
		{
			System.out.println("Loop Lable line"); //<<< I
			try {
				for (; true; i++) {
					System.out.println("i: "+i); //<<< 1,2,3,4,5,6 <<<II
					if (i > 5)
						break PATITO; 
				}
			} catch (Exception e) {
				System.out.println("Exception in loop.");
			} finally {
				System.out.println("In Finally"); //<<< III
			}
		}
		System.out.println("Fin de Programa"); //<<< IV
	}

}