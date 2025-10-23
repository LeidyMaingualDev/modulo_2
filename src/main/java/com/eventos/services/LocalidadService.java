package com.eventos.services;

import com.eventos.entities.users.Evento;
import com.eventos.entities.users.Localidad;
import com.eventos.repositories.LocalidadRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LocalidadService {

    private final LocalidadRepository localidadRepository;

    //ver todos las localidades
    public List<Localidad> listarTodos() {
        return localidadRepository.findAll();
    }

    //ver localidad por id
    public Optional<Localidad> obtenerPorId(Long id) {
        return localidadRepository.findById(id);
    }

    //crear localidad
    public Localidad guardar(Localidad localidad) {
        return localidadRepository.save(localidad);
    }

    //actualizar localidad
    public Localidad actualizar(Long id, Localidad localidadActualizado) {
        return localidadRepository.findById(id)
                .map(localidad -> {
                    localidad.setCodigo(localidadActualizado.getCodigo());
                    localidad.setNombreLocalidad(localidadActualizado.getNombreLocalidad());
                    return localidadRepository.save(localidad);
                })
                .orElseThrow(() -> new RuntimeException("Localidad no encontrada con id: " + id));
    }

    public void eliminar(Long id) {
        localidadRepository.deleteById(id);
    }
}
