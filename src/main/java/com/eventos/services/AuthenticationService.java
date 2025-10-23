package com.eventos.services;

import com.eventos.entities.users.Usuario;
import com.eventos.entities.users.UsuarioRol;
import com.eventos.entities.users.dtos.AuthenticationDTO;
import com.eventos.entities.users.dtos.LoginResponseDTO;
import com.eventos.entities.users.dtos.RegisterDTO;
import com.eventos.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;


    public Usuario register(RegisterDTO dto) {
        UsuarioRol rol = UsuarioRol.valueOf(dto.rol().toUpperCase());

        Usuario usuario = Usuario.builder()
                .email(dto.email())
                .password(passwordEncoder.encode(dto.password()))
                .tipoDocumento(dto.tipoDocumento())
                .documento(dto.documento())
                .nombre(dto.nombre())
                .apellido(dto.apellido())
                .telefono(dto.telefono())
                .rol(rol)
                .build();

        return usuarioRepository.save(usuario);
    }

    public LoginResponseDTO login(AuthenticationDTO dto) {
        // Buscar usuario en la base de datos
        Usuario usuario = usuarioRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Validar la contraseña
        if (!passwordEncoder.matches(dto.getPassword(), usuario.getPassword())) {
            throw new RuntimeException("Credenciales inválidas");
        }

        // Generar JWT
        String token = tokenService.generateToken(usuario);

        // Retornar la respuesta con token + datos del usuario
        return new LoginResponseDTO(
                token,
                usuario.getEmail(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getRol().name()
        );
    }
}
