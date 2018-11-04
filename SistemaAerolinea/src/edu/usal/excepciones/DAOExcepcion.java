package edu.usal.excepciones;

public class DAOExcepcion extends Exception{

	
	public DAOExcepcion(String mensaje) {
		super(mensaje);
	}

	public DAOExcepcion(String message, Throwable cause) {
		super(message, cause);
		
	}
	
	
	
}
