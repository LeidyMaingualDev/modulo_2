package com.eventos.entities.users.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AuthenticationDTO {

    private String email;
    private String password;
}
