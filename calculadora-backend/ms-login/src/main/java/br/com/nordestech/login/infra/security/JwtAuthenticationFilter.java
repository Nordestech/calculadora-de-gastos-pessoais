package br.com.nordestech.login.infra.security;

import br.com.nordestech.usuario.domain.model.Usuario;
import br.com.nordestech.usuario.domain.service.usuario.BuscarUsuarioUseCase;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenService jwtTokenService;
    private final BuscarUsuarioUseCase buscarUsuarioUseCase;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String jwt = authHeader.substring(7);

        try {
            String emailUsuario = jwtTokenService.validarETerEmail(jwt);

            if (emailUsuario != null && SecurityContextHolder.getContext().getAuthentication() == null) {

                Usuario usuario = buscarUsuarioUseCase.buscarUsuarioPorEmail(emailUsuario);

                List<SimpleGrantedAuthority> authorities = usuario.getPerfis().stream()
                        .map(perfil -> {
                            String nomePerfil = perfil.name();
                            if (!nomePerfil.startsWith("ROLE_")) {
                                nomePerfil = "ROLE_" + nomePerfil;
                            }
                            return new SimpleGrantedAuthority(nomePerfil);
                        })
                        .toList();

                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        usuario,
                        null,
                        authorities
                );

                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        } catch (Exception e) {
            SecurityContextHolder.clearContext();
        }

        filterChain.doFilter(request, response);
    }
}