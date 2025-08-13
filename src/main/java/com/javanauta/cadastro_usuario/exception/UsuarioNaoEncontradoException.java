package com.javanauta.cadastro_usuario.exception;

public class UsuarioNaoEncontradoException extends RuntimeException{
	
	private static final String USUARIO_NAO_ENCONTRADO = "Usuario não encontrado!";
	
	public UsuarioNaoEncontradoException() {
		super(USUARIO_NAO_ENCONTRADO);
	}

}
