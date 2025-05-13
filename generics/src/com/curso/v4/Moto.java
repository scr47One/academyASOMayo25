package com.curso.v4;

public class Moto implements Transporte{
	private String nombre;
    
    public Moto(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
	
    @Override
	public String toString() {
		return "Moto [nombre=" + nombre + "]";
	}

}