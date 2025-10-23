package com.eventos.repositories;

import com.eventos.entities.users.Usuario;
import com.eventos.entities.users.UsuarioRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    long countByRol(UsuarioRol rol);
}
