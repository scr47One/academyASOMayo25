package com.curso.v5;

public class Bici implements Transporte {
	private String nombre;
    
    public Bici(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
	
    @Override
	public String toString() {
		return "Bici [nombre=" + nombre + "]";
	}

}