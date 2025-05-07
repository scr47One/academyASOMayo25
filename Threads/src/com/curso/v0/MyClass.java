package com.curso.v0;

class MyClass implements Runnable {
	int n = 0; //2

	//Clase Anidada (Clase de Instancia)
	public MyClass(int n) {
		this.n = n;
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Inicio");
		new Thread(new MyClass(2)).start();
		//new MyClass(1).run();
		Thread.sleep(2000);
		System.out.println("Fin");
	}

	@Override
	public void run() {
		for (int i = 0; i < n; i++) {
			System.out.println("Hello World");
		}
	}
}