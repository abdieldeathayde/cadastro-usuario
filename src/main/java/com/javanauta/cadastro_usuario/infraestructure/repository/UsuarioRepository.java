package com.javanauta.cadastro_usuario.infraestructure.repository;

import com.javanauta.cadastro_usuario.infraestructure.entities.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByEmail(String email);


    void deleteByEmail(String email);
}
