package com.javanauta.cadastro_usuario.exception;

public class BuscaEmailException extends RuntimeException{

	private static final String BUSCA_EMAIL = "O email nao encontrado.";
	
	public BuscaEmailException() {
		super(BUSCA_EMAIL);
	}
}
