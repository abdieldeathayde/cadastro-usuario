package com.javanauta.cadastro_usuario.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.javanauta.cadastro_usuario.dto.AtualizaUsuarioDto;
import com.javanauta.cadastro_usuario.dto.CriarUsuarioDto;
import com.javanauta.cadastro_usuario.dto.response.UsuarioDto;
import com.javanauta.cadastro_usuario.infraestructure.entities.Usuario;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

	UsuarioDto toDto(Usuario entity);

	List<Usuario> toEntityList(List<CriarUsuarioDto> dtoList);

	Usuario toEntity(CriarUsuarioDto dto);
	
	Usuario atualizaDto(AtualizaUsuarioDto dto, @MappingTarget Usuario entity);

	List<UsuarioDto> converteLista(List<Usuario> entity);
}
