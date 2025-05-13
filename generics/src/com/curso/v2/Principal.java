package com.curso.v2;

public class Principal {

	public static void main(String[] args) {

		Bici bici = new Bici("biciX");
		Moto moto = new Moto("motoZ");
		Motoneta motoneta = new Motoneta("motonetaW");
		
		Contenedor<Bici> contenedor1 = new Contenedor<>(bici);
		System.out.println(contenedor1.getT());
		System.out.println(contenedor1);
		
		Contenedor<Moto> contenedor2 = new Contenedor<>(moto);
		System.out.println(contenedor2.getT());
		System.out.println(contenedor2);

		
		Contenedor<Motoneta> contenedor3 = new Contenedor<>(motoneta);
		System.out.println(contenedor3.getT());
		System.out.println(contenedor3);

		
		
	}

}
