package com.curso.v0;

public class Motoneta {
	private String nombre;
    
    public Motoneta(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
	
    @Override
	public String toString() {
		return "Motoneta [nombre=" + nombre + "]";
	}

}