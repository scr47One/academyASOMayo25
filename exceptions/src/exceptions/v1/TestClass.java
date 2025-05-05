
package exceptions.v1;

public class TestClass {
	public static void main(String[] args) {
		try {
			hello();
		} catch (MyException me) {
			System.out.println(me); 
		}
		System.out.println("Fin Programa");
	}

	static void hello() throws MyException {
		int[] dear = new int[7];
		dear[7] = 747; //<< java.lang.ArrayIndexOutOfBoundsException
		foo();
	}

	static void foo() throws MyException {
		throw new MyException("Exception from foo");
	}
}

class MyException extends Exception {
	public MyException(String msg) {
		super(msg);
	}
}