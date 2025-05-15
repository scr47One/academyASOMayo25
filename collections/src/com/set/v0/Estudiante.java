package com.set.v0;

public record Estudiante(
	String Nombre,int Edad, double Sueldo) {
	
	public static void main(String[] args) {
		Estudiante e1 = new Estudiante("Patrobas",20,50.5);
		Estudiante e2 = new Estudiante("Tercio",15,30.5);
		Estudiante e3 = new Estudiante("Epeneto",18,40.5);
		Estudiante e4 = new Estudiante("Epeneto",18,40.5);
		System.out.println(e1.Nombre());
		System.out.println(e2);
		System.out.println(e3.equals(e4));
	}
	
}
