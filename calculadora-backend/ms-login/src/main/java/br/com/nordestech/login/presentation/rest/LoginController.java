package br.com.nordestech.login.presentation.rest;

import br.com.nordestech.login.domain.model.DTO.LoginDTO;
import br.com.nordestech.login.domain.service.RealizarLoginUseCase;
import br.com.nordestech.login.presentation.mapper.LoginDTOMapper;
import br.com.nordestech.login.presentation.rest.request.LoginRequestDTO;
import br.com.nordestech.login.presentation.rest.response.LoginResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/login")
@Tag(name = "Login", description = "Endpoints para gerenciamento de logins")
public class LoginController {

    private final RealizarLoginUseCase loginUseCase;
    private final LoginDTOMapper mapper;

    @Operation(summary = "Realizar o login do usuário", description = "Realizar o login do usuário por meio do CPF e senha")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "401", description = "CPF não encontrado no banco de dados e/ou senha errada")
    })
    @PostMapping
    public ResponseEntity<LoginResponseDTO> realizarLogin(@Valid @RequestBody LoginRequestDTO dto) {

        log.info("Requisição de cadastro de usuário recebida com sucesso");
        LoginDTO loginRealizado = loginUseCase.execute(mapper.toLogin(dto));

        log.info("Usuário cadastrado com sucesso");
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toLoginResponseDTO(loginRealizado));
    }

}
