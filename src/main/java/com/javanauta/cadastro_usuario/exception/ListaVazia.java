package com.javanauta.cadastro_usuario.exception;

public class ListaVazia extends RuntimeException{
    private static final String LISTA_VAZIA = "Lista está vázia";

    public ListaVazia() {
        super(LISTA_VAZIA);
    }
}
