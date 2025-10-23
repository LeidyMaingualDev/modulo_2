package com.eventos.controllers;

import com.eventos.entities.users.Evento;
import com.eventos.services.EventoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
@RequiredArgsConstructor
public class EventoController {

    private final EventoService eventoService;


    // Listar todos los eventos
    @GetMapping
    public ResponseEntity<List<Evento>> listarTodos() {
        return ResponseEntity.ok(eventoService.listarTodos());
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Evento> obtenerPorId(@PathVariable Long id) {
        return eventoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear nuevo CUPS
    @PostMapping
    public ResponseEntity<Evento> guardar(@RequestBody Evento evento) {
        return ResponseEntity.ok(eventoService.guardar(evento));
    }

    // Actualizar CUPS existente
    @PutMapping("/{id}")
    public ResponseEntity<Evento> actualizar(@PathVariable Long id, @RequestBody Evento eventoActualizado) {
        return ResponseEntity.ok(eventoService.actualizar(id, eventoActualizado));
    }

    // Eliminar CUPS
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        eventoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
























