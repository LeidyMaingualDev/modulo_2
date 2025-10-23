package com.eventos.repositories;

import com.eventos.entities.users.Localidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalidadRepository extends JpaRepository <Localidad, Long> {
}
