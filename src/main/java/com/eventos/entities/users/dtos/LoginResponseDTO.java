package com.eventos.entities.users.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class LoginResponseDTO {

    private String token;
    private String email;
    private String nombre;
    private String apellido;
    private String rol;
}
