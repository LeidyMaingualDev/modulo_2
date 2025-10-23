package com.eventos.controllers;

import com.eventos.entities.users.Boleteria;
import com.eventos.entities.users.Localidad;
import com.eventos.services.LocalidadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/localidad")
@RequiredArgsConstructor
public class LocalidadController {

    @GetMapping("/admin-test")
    public String adminOnlyTest() {
        return "✅ Acceso autorizado solo para ADMIN";
    }

    private final LocalidadService localidadService;

    // Listar todas las localidades
    @GetMapping
    public ResponseEntity<List<Localidad>> listarTodos() {
        return ResponseEntity.ok(localidadService.listarTodos());
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Localidad> obtenerPorId(@PathVariable Long id) {
        return localidadService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear nueva localidad
    @PostMapping
    public ResponseEntity<Localidad> guardar(@RequestBody Localidad localidad) {
        return ResponseEntity.ok(localidadService.guardar(localidad));
    }

    // Actualizar localidad existente
    @PutMapping("/{id}")
    public ResponseEntity<Localidad> actualizar(@PathVariable Long id, @RequestBody Localidad localidadActualizado) {
        return ResponseEntity.ok(localidadService.actualizar(id, localidadActualizado));
    }

    // Eliminar localidad
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        localidadService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
