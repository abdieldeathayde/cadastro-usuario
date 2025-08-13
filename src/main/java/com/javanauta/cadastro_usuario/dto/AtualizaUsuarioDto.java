package com.javanauta.cadastro_usuario.dto;

import jakarta.validation.constraints.NotBlank;

public record AtualizaUsuarioDto(
		
		@NotBlank(message = "O email é obrigatorio.")
		String email,
		@NotBlank(message = "O nome é obrigatorio.")
		String nome) {

}
