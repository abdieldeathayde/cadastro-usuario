package com.javanauta.cadastro_usuario.controller;

import org.springframework.http.HttpStatus;
import com.javanauta.cadastro_usuario.business.UsuarioService;
import com.javanauta.cadastro_usuario.dto.AtualizaUsuarioDto;
import com.javanauta.cadastro_usuario.dto.CriarUsuarioDto;
import com.javanauta.cadastro_usuario.dto.response.UsuarioDto;
import com.javanauta.cadastro_usuario.infraestructure.entities.Usuario;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

	private final UsuarioService usuarioService;

	@PostMapping
	public ResponseEntity<UsuarioDto> salvarUsuario(@RequestBody @Valid CriarUsuarioDto dto) {
		UsuarioDto usuarioSalvo = usuarioService.salvarUsuario(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
	}

	@GetMapping
	public ResponseEntity<UsuarioDto> buscarUsuarioPorEmail(
			@RequestParam @NotBlank(message = "O email é obrigatorio.") String email) {
		UsuarioDto usuarioDto = usuarioService.buscarUsuarioPorEmail(email);
		return ResponseEntity.ok(usuarioDto);

	}

	@GetMapping("/filtrar")
    public ResponseEntity<List<UsuarioDto>> listarTodos(){
        List<UsuarioDto> usuarioDto = usuarioService.buscarTodos();
		return ResponseEntity.ok(usuarioDto);
    }


	@DeleteMapping
	public ResponseEntity<String> deletarUsuarioPorEmail(
			@RequestParam @NotBlank(message = "O email é obrigatorio.") String email) {
		usuarioService.deletarUsuarioPorEmail(email);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("User deleted successfully.");

	}

	@PutMapping
	public ResponseEntity<UsuarioDto> atualizarUsuarioPorId(
			@RequestParam @NotNull(message = "O id nao pode ser nullo.") Integer id,
			@RequestBody @Valid AtualizaUsuarioDto dto) {
		UsuarioDto usuarioAtualizado = usuarioService.atualizarUsuarioPorId(id, dto);
		return ResponseEntity.ok(usuarioAtualizado);

	}

}
