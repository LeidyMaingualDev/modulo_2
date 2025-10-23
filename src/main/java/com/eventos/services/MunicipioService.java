package com.eventos.services;

import com.eventos.entities.users.Localidad;
import com.eventos.entities.users.Municipio;
import com.eventos.repositories.MunicipioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MunicipioService {

    private final MunicipioRepository municipioRepository;

    //ver todos los municipios
    public List<Municipio> listarTodos() {
        return municipioRepository.findAll();
    }

    //ver municipio por id
    public Optional<Municipio> obtenerPorId(Long id) {
        return municipioRepository.findById(id);
    }

    //crear munucipio
    public Municipio guardar(Municipio municipio) {
        return municipioRepository.save(municipio);
    }

    //actualizar municipio
    public Municipio actualizar(Long id, Municipio municipioActualizado) {
        return municipioRepository.findById(id)
                .map(municipio -> {
                    municipio.setCodigo(municipioActualizado.getCodigo());
                    municipio.setNombre(municipioActualizado.getNombre());
                    return municipioRepository.save(municipio);
                })
                .orElseThrow(() -> new RuntimeException("Municipio no encontrada con id: " + id));
    }

    public void eliminar(Long id) {
        municipioRepository.deleteById(id);
    }
}
