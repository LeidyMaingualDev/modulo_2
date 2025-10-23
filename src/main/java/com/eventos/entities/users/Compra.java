package com.eventos.entities.users;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "compras")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evento", nullable = false)
    private Evento evento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_localidad", nullable = false)
    private Localidad localidad;

    @Column(nullable = false)
    private int cantidadBoletas;


    @Column(nullable = false)
    private int valorTotal;

    @Enumerated(EnumType.STRING)
    private MetodoPAgo metodoPago;

    @Enumerated(EnumType.STRING)
    private EstadoTransaccion estadoTransaccion;

    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private Time hora;
}
