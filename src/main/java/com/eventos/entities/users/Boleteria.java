package com.eventos.entities.users;

import jakarta.persistence.*;
import lombok.*;

//selecionar evento, localidad, precio boleta, boletas disponbles
@Entity
@Table(name = "boleteria")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Boleteria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evento", nullable = false)
    private Evento evento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_localidad", nullable = false)
    private Localidad localidad;

    @Column(nullable = false)
    private float precioBoleta;

    @Column(nullable = false)
    private int disponibilidadBoletas;
}
