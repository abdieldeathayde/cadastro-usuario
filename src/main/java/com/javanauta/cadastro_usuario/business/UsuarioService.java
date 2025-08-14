package com.javanauta.cadastro_usuario.business;

import com.javanauta.cadastro_usuario.dto.AtualizaUsuarioDto;
import com.javanauta.cadastro_usuario.dto.CriarUsuarioDto;
import com.javanauta.cadastro_usuario.dto.response.UsuarioDto;
import com.javanauta.cadastro_usuario.infraestructure.entities.Usuario;
import com.javanauta.cadastro_usuario.infraestructure.repository.UsuarioRepository;
import com.javanauta.cadastro_usuario.mapper.UsuarioMapper;
import com.javanauta.cadastro_usuario.validador.UsuarioValidador;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	private final UsuarioValidador usuarioValidador;
	private final UsuarioMapper usuarioMapper;

	public UsuarioDto salvarUsuario(CriarUsuarioDto dto) {
		Usuario usuario = usuarioMapper.toEntity(dto);
		usuarioRepository.save(usuario);
		return usuarioMapper.toDto(usuario);
	}

	public UsuarioDto buscarUsuarioPorEmail(String email) {
		Usuario usuario = usuarioValidador.buscaUsuarioOuLancaException(email);
		return usuarioMapper.toDto(usuario);
	}

	public List<UsuarioDto> buscarTodos() {
		List<Usuario> user = usuarioRepository.findAll();
		usuarioValidador.validaSeListaEstaVazia(user);
		return usuarioMapper.converteLista(user);
	}



	public void deletarUsuarioPorEmail(String email) {
		Usuario usuario = usuarioValidador.buscaUsuarioOuLancaException(email);
		usuarioRepository.delete(usuario);
	}


	public UsuarioDto atualizarUsuarioPorId(Integer id, AtualizaUsuarioDto dto) {
		Usuario usuario = usuarioValidador.validaSeUsuarioExiste(id);
		usuarioMapper.atualizaDto(dto, usuario);
		usuarioRepository.save(usuario);
		return usuarioMapper.toDto(usuario);
	}

	public List<UsuarioDto> salvarUsuarios(List<CriarUsuarioDto> dtoList) {
		// Converte a lista de DTOs de criação para entidades Usuario
		List<Usuario> usuarios = usuarioMapper.toEntityList(dtoList);

		// Salva todos de uma vez no banco
		List<Usuario> usuariosSalvos = usuarioRepository.saveAll(usuarios);

		// Converte a lista salva para DTOs de resposta
		return usuarioMapper.converteLista(usuariosSalvos);
	}


}