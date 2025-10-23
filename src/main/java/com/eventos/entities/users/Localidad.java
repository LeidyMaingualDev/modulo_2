package com.eventos.entities.users;

import jakarta.persistence.*;
import lombok.*;

//codigo localidad, nombre localidad
@Entity
@Table(name = "localidad")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Localidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 10)
    private String codigo;

    @Column(nullable = false)
    private LocalidadTipo nombreLocalidad;

}
