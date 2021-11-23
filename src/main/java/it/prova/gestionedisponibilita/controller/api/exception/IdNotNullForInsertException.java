package it.prova.gestionedisponibilita.controller.api.exception;

public class IdNotNullForInsertException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public IdNotNullForInsertException(String message) {
		super(message);
	}
}
