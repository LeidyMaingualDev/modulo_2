package com.eventos.services;

import com.eventos.entities.users.Evento;
import com.eventos.repositories.EventoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EventoService {

    private final EventoRepository eventoRepository;


    //ver todos los eventos
    public List<Evento> listarTodos() {
        return eventoRepository.findAll();
    }

    //ver evento por id
    public Optional<Evento> obtenerPorId(Long id) {
        return eventoRepository.findById(id);
    }

    //crear evento
    public Evento guardar(Evento evento) {
        return eventoRepository.save(evento);
    }

   //actualizar evento
    public Evento actualizar(Long id, Evento eventoActualizado) {
        return eventoRepository.findById(id)
                .map(evento -> {
                    evento.setNombre(eventoActualizado.getNombre());
                    evento.setDescripcion(eventoActualizado.getDescripcion());
                    evento.setMunicipio(eventoActualizado.getMunicipio());
                    evento.setArtista(eventoActualizado.getArtista());
                    evento.setActividad(eventoActualizado.getActividad());
                    evento.setFecha(eventoActualizado.getFecha());
                    evento.setHoraInicio(eventoActualizado.getHoraInicio());
                    evento.setHoraFin(eventoActualizado.getHoraFin());
                    return eventoRepository.save(evento);
                })
                .orElseThrow(() -> new RuntimeException("Evento no encontrado con id: " + id));
    }

    public void eliminar(Long id) {
        eventoRepository.deleteById(id);
    }


}