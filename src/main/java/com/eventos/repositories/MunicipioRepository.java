package com.eventos.repositories;

import com.eventos.entities.users.Evento;
import com.eventos.entities.users.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MunicipioRepository extends JpaRepository <Municipio, Long> {
    Optional<Municipio> findByNombre(String nombre);
}
