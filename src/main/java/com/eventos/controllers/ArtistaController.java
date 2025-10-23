package com.eventos.controllers;

import com.eventos.entities.users.Artista;
import com.eventos.entities.users.Municipio;
import com.eventos.services.ArtistaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artistas")
@RequiredArgsConstructor
public class ArtistaController {

    @GetMapping("/admin-test")
    public String adminOnlyTest() {
        return "✅ Acceso autorizado solo para ADMIN";
    }

    private final ArtistaService artistaService;

    // Listar todas los artistas
    @GetMapping
    public ResponseEntity<List<Artista>> listarTodos() {
        return ResponseEntity.ok(artistaService.listarTodos());
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Artista> obtenerPorId(@PathVariable Long id) {
        return artistaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear nuevo municipio
    @PostMapping
    public ResponseEntity<Artista> guardar(@RequestBody Artista artista) {
        return ResponseEntity.ok(artistaService.guardar(artista));
    }

    // Actualizar artista existente
    @PutMapping("/{id}")
    public ResponseEntity<Artista> actualizar(@PathVariable Long id, @RequestBody Artista artistaActualizado) {
        return ResponseEntity.ok(artistaService.actualizar(id, artistaActualizado));
    }

    // Eliminar artista
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        artistaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
