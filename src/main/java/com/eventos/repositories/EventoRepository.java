package com.eventos.repositories;

import com.eventos.entities.users.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
}
