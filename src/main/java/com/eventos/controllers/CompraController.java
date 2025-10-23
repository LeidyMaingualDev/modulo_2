package com.eventos.controllers;

import com.eventos.entities.users.Boleteria;
import com.eventos.entities.users.Compra;
import com.eventos.services.BoleteriaService;
import com.eventos.services.CompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compra")
@RequiredArgsConstructor
public class CompraController {

    private final CompraService compraService;

    // Listar todos los eventos
    @GetMapping
    public ResponseEntity<List<Compra>> listarTodos() {
        return ResponseEntity.ok(compraService.listarTodos());
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Compra> obtenerPorId(@PathVariable Long id) {
        return compraService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear nuevo CUPS
    @PostMapping
    public ResponseEntity<Compra> guardar(@RequestBody Compra compra) {
        return ResponseEntity.ok(compraService.guardar(compra));
    }

    // Actualizar CUPS existente
    @PutMapping("/{id}")
    public ResponseEntity<Compra> actualizar(@PathVariable Long id, @RequestBody Compra compraActualizado) {
        return ResponseEntity.ok(compraService.actualizar(id, compraActualizado));
    }

    // Eliminar CUPS
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        compraService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
