package br.com.nordestech.login.domain.service;

import br.com.nordestech.login.domain.exception.UnauthorizedException;
import br.com.nordestech.login.domain.exception.enums.ErrorCode;
import br.com.nordestech.login.domain.model.DTO.LoginDTO;
import br.com.nordestech.login.domain.model.Login;
import br.com.nordestech.login.infra.security.JwtTokenService;
import br.com.nordestech.usuario.domain.exceptions.ResourceNotFoundException;
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
        String token;

        try {
            usuario = buscarUsuarioUseCase.buscarUsuarioPorEmail(login.getEmail());
        } catch (ResourceNotFoundException e) {
            throw new UnauthorizedException(ErrorCode.LOGIN_INCORRECT);
        }

        if (passwordEncoder.matches(login.getSenha(), usuario.getSenha())) {
            token = jwtTokenService.gerarToken(usuario);
        } else {
            throw new UnauthorizedException(ErrorCode.LOGIN_INCORRECT);
        }

        return new LoginDTO(
                token,
                "Bearer",
                usuario.getIdUsuario(),
                usuario.getPerfis()
        );
    }

}
