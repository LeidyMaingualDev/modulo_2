package com.eventos.entities.users;

import jakarta.persistence.*;
import lombok.*;

import java.security.Timestamp;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

//id, nombre, descripcion, artista, fecha, hora inicio, hora fin
@Entity
@Table(name = "evento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 60)
    private String nombre;

    @Column(nullable = false, length = 400)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_municipio", nullable = false)
    private Municipio municipio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_artista", nullable = false)
    private Artista artista;

    @Column(nullable = false)
    private ActividadEvento actividad;

    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private Time horaInicio;

    @Column(nullable = false)
    private Time horaFin;
}
