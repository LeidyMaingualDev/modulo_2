package com.eventos.controllers;

import com.eventos.entities.users.Boleteria;
import com.eventos.entities.users.Evento;
import com.eventos.services.BoleteriaService;
import com.eventos.services.EventoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boleteria")
@RequiredArgsConstructor
public class BoleteriaController {

    private final BoleteriaService boleteriaService;


    // Listar todos los eventos
    @GetMapping
    public ResponseEntity<List<Boleteria>> listarTodos() {
        return ResponseEntity.ok(boleteriaService.listarTodos());
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Boleteria> obtenerPorId(@PathVariable Long id) {
        return boleteriaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear nuevo CUPS
    @PostMapping
    public ResponseEntity<Boleteria> guardar(@RequestBody Boleteria boleteria) {
        return ResponseEntity.ok(boleteriaService.guardar(boleteria));
    }

    // Actualizar CUPS existente
    @PutMapping("/{id}")
    public ResponseEntity<Boleteria> actualizar(@PathVariable Long id, @RequestBody Boleteria boleteriaActualizado) {
        return ResponseEntity.ok(boleteriaService.actualizar(id, boleteriaActualizado));
    }

    // Eliminar CUPS
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boleteriaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
