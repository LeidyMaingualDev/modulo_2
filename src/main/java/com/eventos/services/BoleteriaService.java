package com.eventos.services;

import com.eventos.entities.users.Boleteria;
import com.eventos.entities.users.Evento;
import com.eventos.repositories.BoleteriaRepository;
import com.eventos.repositories.EventoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BoleteriaService {

    private final BoleteriaRepository boleteriaRepository;

    //ver boleteria
    public List<Boleteria> listarTodos() {
        return boleteriaRepository.findAll();
    }

    //ver boletas por id
    public Optional<Boleteria> obtenerPorId(Long id) {
        return boleteriaRepository.findById(id);
    }

    //crear boletas
    public Boleteria guardar(Boleteria boleteria) {
        return boleteriaRepository.save(boleteria);
    }

    //actualizar evento
    public Boleteria actualizar(Long id, Boleteria boleteriaActualizado) {
        return boleteriaRepository.findById(id)
                .map(boleteria -> {
                    boleteria.setEvento(boleteriaActualizado.getEvento());
                    boleteria.setLocalidad(boleteriaActualizado.getLocalidad());
                    boleteria.setPrecioBoleta(boleteriaActualizado.getPrecioBoleta());
                    boleteria.setDisponibilidadBoletas(boleteriaActualizado.getDisponibilidadBoletas());
                    return boleteriaRepository.save(boleteria);
                })
                .orElseThrow(() -> new RuntimeException("Boleteria no encontrado con id: " + id));
    }

    public void eliminar(Long id) {
        boleteriaRepository.deleteById(id);
    }

}
