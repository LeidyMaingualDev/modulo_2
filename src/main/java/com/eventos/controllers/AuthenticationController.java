package com.eventos.controllers;

import com.eventos.entities.users.Usuario;
import com.eventos.entities.users.dtos.AuthenticationDTO;
import com.eventos.entities.users.dtos.LoginResponseDTO;
import com.eventos.entities.users.dtos.RegisterDTO;
import com.eventos.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<Usuario> register(@RequestBody RegisterDTO dto) {
        Usuario usuario = authenticationService.register(dto);
        return ResponseEntity.ok(usuario);
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody AuthenticationDTO dto) {
        LoginResponseDTO response = authenticationService.login(dto);
        return ResponseEntity.ok(response);
    }
}
