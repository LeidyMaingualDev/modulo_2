package com.eventos.services;

import com.eventos.entities.users.Artista;
import com.eventos.entities.users.Boleteria;
import com.eventos.entities.users.Municipio;
import com.eventos.repositories.ArtistaRepository;
import com.eventos.repositories.BoleteriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ArtistaService {

    private final ArtistaRepository artistaRepository;

    //ver boleteria
    public List<Artista> listarTodos() {
        return artistaRepository.findAll();
    }

    //ver boletas por id
    public Optional<Artista> obtenerPorId(Long id) {
        return artistaRepository.findById(id);
    }

    //crear boletas
    public Artista guardar(Artista artista) {
        return artistaRepository.save(artista);
    }

    //actualizar evento
    public Artista actualizar(Long id, Artista boleteriaActualizado) {
        return artistaRepository.findById(id)
                .map(artista -> {
                    artista.setNombre(boleteriaActualizado.getNombre());
                    artista.setApellido(boleteriaActualizado.getApellido());
                    artista.setGenero(boleteriaActualizado.getGenero());
                    artista.setCiudad(boleteriaActualizado.getCiudad());
                    return artistaRepository.save(artista);
                })
                .orElseThrow(() -> new RuntimeException("Artista no encontrado con id: " + id));
    }

    public void eliminar(Long id) {
        artistaRepository.deleteById(id);
    }

}
