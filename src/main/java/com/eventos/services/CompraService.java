package com.eventos.services;

import com.eventos.entities.users.Boleteria;
import com.eventos.entities.users.Compra;
import com.eventos.repositories.BoleteriaRepository;
import com.eventos.repositories.CompraRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CompraService {

    private final CompraRepository compraRepository;

    //ver boleteria
    public List<Compra> listarTodos() {
        return compraRepository.findAll();
    }

    //ver boletas por id
    public Optional<Compra> obtenerPorId(Long id) {
        return compraRepository.findById(id);
    }

    //crear boletas
    public Compra guardar(Compra compra) {
        return compraRepository.save(compra);
    }

    //actualizar evento
    public Compra actualizar(Long id, Compra compraActualizado) {
        return compraRepository.findById(id)
                .map(compra -> {
                    compra.setUsuario(compraActualizado.getUsuario());
                    compra.setEvento(compraActualizado.getEvento());
                    compra.setLocalidad(compraActualizado.getLocalidad());
                    compra.setCantidadBoletas(compraActualizado.getCantidadBoletas());
                    compra.setValorTotal(compraActualizado.getValorTotal());
                    compra.setMetodoPago(compraActualizado.getMetodoPago());
                    compra.setEstadoTransaccion(compraActualizado.getEstadoTransaccion());
                    compra.setFecha(compraActualizado.getFecha());
                    compra.setHora(compraActualizado.getHora());
                    return compraRepository.save(compra);
                })
                .orElseThrow(() -> new RuntimeException("venta no encontrado con id: " + id));
    }

    public void eliminar(Long id) {
        compraRepository.deleteById(id);
    }
}
