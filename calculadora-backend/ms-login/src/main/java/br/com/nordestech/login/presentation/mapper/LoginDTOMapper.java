package br.com.nordestech.login.presentation.mapper;

import br.com.nordestech.login.domain.model.DTO.LoginDTO;
import br.com.nordestech.login.domain.model.Login;
import br.com.nordestech.login.presentation.rest.request.LoginRequestDTO;
import br.com.nordestech.login.presentation.rest.response.LoginResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class LoginDTOMapper {

    public Login toLogin(LoginRequestDTO loginRequestDTO) {

        return new Login(
                loginRequestDTO.getEmail(),
                loginRequestDTO.getSenha()
        );

    }

    public LoginResponseDTO toLoginResponseDTO(LoginDTO loginDTO) {

        return new LoginResponseDTO(
                loginDTO.token(),
                loginDTO.type(),
                loginDTO.usuarioId(),
                loginDTO.perfis()
        );

    }

}
