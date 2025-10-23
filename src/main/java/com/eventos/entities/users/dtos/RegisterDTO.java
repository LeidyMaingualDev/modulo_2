package com.eventos.entities.users.dtos;

import lombok.Getter;
import lombok.Setter;

public record RegisterDTO(
        String email,
        String password,
        String tipoDocumento,
        String documento,
        String nombre,
        String apellido,
        String telefono,
        String rol
) {
}
