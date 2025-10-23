package com.eventos.controllers;

import com.eventos.entities.users.Localidad;
import com.eventos.entities.users.Municipio;
import com.eventos.services.MunicipioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/municipios")
@RequiredArgsConstructor
public class MunicipioController {

    private final MunicipioService municipioService;

    // Listar todas los municipios
    @GetMapping
    public ResponseEntity<List<Municipio>> listarTodos() {
        return ResponseEntity.ok(municipioService.listarTodos());
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Municipio> obtenerPorId(@PathVariable Long id) {
        return municipioService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear nuevo municipio
    @PostMapping
    public ResponseEntity<Municipio> guardar(@RequestBody Municipio municipio) {
        return ResponseEntity.ok(municipioService.guardar(municipio));
    }

    // Actualizar municipio existente
    @PutMapping("/{id}")
    public ResponseEntity<Municipio> actualizar(@PathVariable Long id, @RequestBody Municipio municipioActualizado) {
        return ResponseEntity.ok(municipioService.actualizar(id, municipioActualizado));
    }

    // Eliminar municipio
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        municipioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
