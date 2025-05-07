package com.curso.v0;

public class Principal1 {

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
		
		Runnable run = () -> {
			Thread.currentThread().setName("MyThread2");
			System.out.println(Thread.currentThread().getName()+": Ejecutando");
		};

		new MyThread1().start();
		
		new Thread(run).start();
		
		System.out.println(Thread.currentThread().getName()
				+": Ejecutando");
		
	}

}
