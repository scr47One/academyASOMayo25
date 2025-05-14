package com.curso.v5;

public class Principal {

	public static void main(String[] args) {

		Bici bici = new Bici("biciX");
		Moto moto = new Moto("motoZ");
		Motoneta motoneta = new Motoneta("motonetaW");
		
		Contenedor<Bici> contenedor1 = new Contenedor<>(bici);
		System.out.println(contenedor1.getT());
		System.out.println(contenedor1);
		contenedor1.<Integer>mostrarCertificado(Integer.valueOf(111));
		
		System.out.println("********");
		Contenedor<Moto> contenedor2 = new Contenedor<>(moto);
		System.out.println(contenedor2.getT());
		System.out.println(contenedor2);
		contenedor2.<String>mostrarCertificado("222");

		System.out.println("********");
		Contenedor<Motoneta> contenedor3 = new Contenedor<>(motoneta);
		System.out.println(contenedor3.getT());
		System.out.println(contenedor3);
		contenedor3.<StringBuilder>mostrarCertificado(new StringBuilder("333"));


//		Contenedor<StringBuilder> contenedor4 = new Contenedor<>(new StringBuilder("SB"));
//		System.out.println(contenedor4.getT());
//		System.out.println(contenedor4);
		
	}

}
