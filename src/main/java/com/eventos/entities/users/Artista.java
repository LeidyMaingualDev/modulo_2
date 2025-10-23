package com.eventos.entities.users;
//codigos, nombres, apellidos, genero musical, ciudad natal

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "artista")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String apellido;

    @Column(nullable = false, length = 30)
    private String genero;

    @Column(nullable = false, length = 60)
    private String ciudad;
}
