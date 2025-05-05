package com.curso.v2;

class InternalException extends RuntimeException {
	public InternalException(String message) {
		super(message);
	}
}

class ExternalException extends Exception {
	public ExternalException(String message) {
		super(message);
	}
}

class Microservice implements AutoCloseable {
	private String name;

	public Microservice(String name) {
		this.name = name;
		System.out.println(name + " started"); //<==1 Z started
	}

	public void availService(String name) {
		if (!this.name.equals(name)) {
			throw new InternalException("Unknown service " + name);
		}
	}

	@Override
	public void close() throws ExternalException {
		if (name.equals("X")) {
			throw new ExternalException("Can't close X service");
		}
		System.out.println(name + " closed"); //<==2 Z closed
	}

	public static void main(String[] args) {
		try (Microservice ms = new Microservice("Z")) {
			//ms.availService("test");
		} 
		catch (InternalException | ExternalException e) {
			System.out.println(e); 
//			for (Throwable t : e.getSuppressed())
//				System.out.println(t);
		}
	}
}