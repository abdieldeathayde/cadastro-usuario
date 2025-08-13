package com.javanauta.cadastro_usuario.validador;

import com.javanauta.cadastro_usuario.exception.ListaVazia;
import com.javanauta.cadastro_usuario.mapper.UsuarioMapper;
import org.springframework.stereotype.Component;

import com.javanauta.cadastro_usuario.exception.BuscaEmailException;
import com.javanauta.cadastro_usuario.exception.UsuarioNaoEncontradoException;
import com.javanauta.cadastro_usuario.infraestructure.entities.Usuario;
import com.javanauta.cadastro_usuario.infraestructure.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Component
public class UsuarioValidador {

	private final UsuarioRepository usuarioRepository;

	
	public Usuario buscaUsuarioOuLancaException(String email) {
		return usuarioRepository.findByEmail(email).orElseThrow(BuscaEmailException::new);
	}
	
	public Usuario validaSeUsuarioExiste(Integer id) {
		return usuarioRepository.findById(id).orElseThrow(UsuarioNaoEncontradoException::new);
	}

	public void validaSeListaEstaVazia(List<Usuario> lista) {
		if (lista.isEmpty()) {
			throw new ListaVazia();
		}
	}

}
