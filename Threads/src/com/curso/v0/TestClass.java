package com.curso.v0;

class Threader extends Thread {
	@Override
	public void run() {
		System.out.println("In Threader");
	}
}

class Pooler extends Thread {
	public Pooler() {
	}

	public Pooler(Runnable r) {
		super(r); // 1 <==CUIDADO
	}

	@Override
	public void run() {
		System.out.println("In Pooler");
	}
}

public class TestClass {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("INICIO");
		Threader t = new Threader();
		Thread h = new Pooler(t); // 2
		h.start(); // 3
		//Thread.sleep(1);
		System.out.println("FIN");

	}
}