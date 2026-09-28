package br.com.nordestech.usuario.presentation.usuario.rest;

import br.com.nordestech.usuario.domain.model.Usuario;
import br.com.nordestech.usuario.domain.service.usuario.CadastrarUsuarioUseCase;
import br.com.nordestech.usuario.presentation.usuario.mapper.UsuarioDTOMapper;
import br.com.nordestech.usuario.presentation.usuario.rest.request.UsuarioRequestDTO;
import br.com.nordestech.usuario.presentation.usuario.rest.response.UsuarioResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/usuario")
public class UsuarioController {

    private final CadastrarUsuarioUseCase cadastrarUsuarioUseCase;
    private final UsuarioDTOMapper usuarioDTOMapper;

    @PostMapping("cadastro")
    public ResponseEntity<UsuarioResponseDTO> cadastrarUsuario(@RequestBody @Valid UsuarioRequestDTO usuarioRequestDTO) {

        Usuario usuario = cadastrarUsuarioUseCase.execute(usuarioDTOMapper.toUsuario(usuarioRequestDTO));

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDTOMapper.toUsuarioResponseDTO(usuario));

    }

}
