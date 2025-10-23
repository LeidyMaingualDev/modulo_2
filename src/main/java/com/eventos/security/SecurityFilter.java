package com.eventos.security;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.eventos.entities.users.Usuario;
import com.eventos.repositories.UsuarioRepository;
import com.eventos.services.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@AllArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {

    private final TokenService tokenService;
    private final UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        // 1. Extraer el token desde el header Authorization
        String authHeader = request.getHeader("Authorization");

        // Si no hay un header o no empieza con "Bearer", continua sin autenticar
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        // 2. Obtener el token sin el prefijo "Bearer "
        String token = authHeader.substring(7);

        // 2.1 Validar y decodificar el token con manejo de errores
        DecodedJWT decoded;
        try {
            decoded = tokenService.validateToken(token); // Se usa la instancia, no la clase
        } catch (Exception e) {
            // Si el token es inválido o expiró, se continúa sin autenticar
            filterChain.doFilter(request, response);
            return;
        }

        String email = decoded.getSubject(); // El subject del token es el email del usuario

        // 3. Si no hay email o ya existe autenticación, continuar
        if (email == null || SecurityContextHolder.getContext().getAuthentication() != null) {
            filterChain.doFilter(request, response);
            return;
        }

        // 4. Buscar el usuario en la base de datos
        var user = usuarioRepository.findByEmail(email).orElse(null);

        // 5. Si el usuario existe y aún no hay autenticación en el contexto, registrarla
        if (user != null) {
            var authToken = new UsernamePasswordAuthenticationToken(
                    user,
                    null,
                    user.getAuthorities()
            );
            authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authToken);
        }

        // 6. Continuar con el resto de filtros
        filterChain.doFilter(request, response);
    }
}
