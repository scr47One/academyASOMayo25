package com.curso.v2;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Principal {

	public static void main(String[] args) {

        Empleado empleado1 = new Empleado("Juan Perez", 30, 50000.0);
        Empleado empleado2 = new Empleado("Maria Garcia", 25, 45000.0);
        Empleado empleado3 = new Empleado("Pedro Lopez", 40, 60000.0);
        Empleado empleado4 = new Empleado("Ana Martinez", 28, 52000.0);
        Empleado empleado5 = new Empleado("Carlos Rodriguez", 35, 55000.0);
        Empleado empleado6 = new Empleado("Laura Fernandez", 22, 48000.0);
        Empleado empleado7 = new Empleado("Miguel Sanchez", 50, 70000.0);
        Empleado empleado8 = new Empleado("Sofia Gomez", 32, 53000.0);
        Empleado empleado9 = new Empleado("Javier Diaz", 45, 62000.0);
        Empleado empleado10 = new Empleado("Elena Ramirez", 29, 51000.0);
        Empleado empleado11 = new Empleado("Juan Perez", 30, 50000.0);

        System.out.println("Ordenar por Edad");
        Comparator<Empleado> comparator = (emp1,emp2) -> emp1.getEdad() - emp2.getEdad();
        Set<Empleado> setEmpleados = new TreeSet<>(comparator);
        
        setEmpleados.add(empleado1);
        setEmpleados.add(empleado2);
        setEmpleados.add(empleado3);
        setEmpleados.add(empleado4);
        setEmpleados.add(empleado5);
        setEmpleados.add(empleado6);
        setEmpleados.add(empleado7);
        setEmpleados.add(empleado8);
        setEmpleados.add(empleado9);
        setEmpleados.add(empleado10);
        setEmpleados.add(empleado11);
        setEmpleados.forEach(System.out::println);
        
        System.out.println("Ordenar por Sueldo");
        comparator = (emp1,emp2) -> (int)(emp1.getSueldo() - emp2.getSueldo());
        Set<Empleado> setEmpleados2 = new TreeSet<>(comparator);
        setEmpleados2.addAll(setEmpleados);
        setEmpleados2.forEach(System.out::println);
        
        System.out.println("Ordenar por Nombre");
        comparator = (emp1,emp2) -> emp1.getNombre().compareTo(emp2.getNombre());
        Set<Empleado> setEmpleados3 = new TreeSet<>(comparator);
        setEmpleados3.addAll(setEmpleados);
        setEmpleados3.forEach(System.out::println);
        
        


	}

}

