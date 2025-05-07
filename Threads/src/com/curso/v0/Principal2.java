package com.curso.v0;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Principal2 {

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
		
		
		ExecutorService executor = Executors.newFixedThreadPool(5);

		new MyThread1().start(); //EJECUTA HILO1
		
		new Thread(run).start(); //EJECUTA HILO2
		
		executor.submit(() -> {
			Thread.currentThread().setName("MyThread3");
			System.out.println(Thread.currentThread().getName()+": Ejecutando");
		}); //EJECUTA HILO3
		
		System.out.println(Thread.currentThread().getName()
				+": Ejecutando"); //EJECUTA main
		
	}

}
