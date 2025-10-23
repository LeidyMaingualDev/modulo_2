package com.eventos.entities.users;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "municipio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Municipio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String codigo;

    @Column(nullable = false, length = 40)
    private String nombre;
}
