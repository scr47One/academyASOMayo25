package com.curso.v0;

public class Principal0 {

	public static void main(String[] args) {

		//Clase local
		class MyThread1 extends Thread{
			@Override
			public void run() {
				Thread.currentThread().setName("MyThread1");
				System.out.println(Thread.currentThread().getName()
						+": Ejecutando");
			}
		}
		
		new MyThread1().start();
		
		System.out.println(Thread.currentThread().getName()
				+": Ejecutando");
		
	}

}
