package br.com.nordestech.login.domain.service;

import br.com.nordestech.login.domain.exception.LoginUnauthorizedException;
import br.com.nordestech.login.domain.model.DTO.LoginDTO;
import br.com.nordestech.login.domain.model.Login;
import br.com.nordestech.login.infra.security.JwtTokenService;
import br.com.nordestech.usuario.domain.exceptions.usuario.UsuarioNotFoundException;
import br.com.nordestech.usuario.domain.model.Usuario;
import br.com.nordestech.usuario.domain.service.usuario.BuscarUsuarioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RealizarLoginUseCase {

    private final BuscarUsuarioUseCase buscarUsuarioUseCase;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenService jwtTokenService;

    public LoginDTO execute(Login login) {

        Usuario usuario;

        try {
            usuario = buscarUsuarioUseCase.buscarUsuarioPorEmail(login.getEmail());
        } catch (UsuarioNotFoundException e) {
            throw new LoginUnauthorizedException("E-mail ou senha incorretos");
        }

        boolean senhaValida = passwordEncoder.matches(login.getSenha(), usuario.getSenha());
        if (!senhaValida) {
            throw new LoginUnauthorizedException("E-mail ou senha incorretos");
        }

        String token = jwtTokenService.gerarToken(usuario);

        return new LoginDTO(
                token,
                "Bearer",
                usuario.getIdUsuario(),
                usuario.getPerfis()
        );
    }

}
