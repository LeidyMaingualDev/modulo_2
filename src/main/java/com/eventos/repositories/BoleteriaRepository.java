package com.eventos.repositories;

import com.eventos.entities.users.Boleteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoleteriaRepository extends JpaRepository <Boleteria, Long> {
}
