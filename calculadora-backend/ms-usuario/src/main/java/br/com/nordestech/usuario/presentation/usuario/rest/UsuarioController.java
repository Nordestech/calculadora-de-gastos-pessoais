package br.com.nordestech.usuario.presentation.usuario.rest;

import br.com.nordestech.usuario.domain.model.Usuario;
import br.com.nordestech.usuario.domain.service.usuario.AtualizarUsuarioUseCase;
import br.com.nordestech.usuario.domain.service.usuario.BuscarUsuarioUseCase;
import br.com.nordestech.usuario.domain.service.usuario.CadastrarUsuarioUseCase;
import br.com.nordestech.usuario.domain.service.usuario.DeletarUsuarioUseCase;
import br.com.nordestech.usuario.presentation.usuario.mapper.UsuarioDTOMapper;
import br.com.nordestech.usuario.presentation.usuario.rest.request.UsuarioRequestDTO;
import br.com.nordestech.usuario.presentation.usuario.rest.request.UsuarioUpdateRequestDTO;
import br.com.nordestech.usuario.presentation.usuario.rest.response.UsuarioResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/usuario")
@Slf4j
@Tag(name = "Usuário", description = "Endpoints para gerenciamento do usuário")
public class UsuarioController {

    private final CadastrarUsuarioUseCase cadastrarUsuarioUseCase;
    private final AtualizarUsuarioUseCase atualizarUsuarioUseCase;
    private final BuscarUsuarioUseCase buscarUsuarioUseCase;
    private final DeletarUsuarioUseCase deletarUsuarioUseCase;
    private final UsuarioDTOMapper usuarioDTOMapper;

    @Operation(summary = "Cadastra um novo usuário", description = "Cria um registro de usuário na base PostgreSQL")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados de requisição inválidos"),
            @ApiResponse(responseCode = "409", description = "Dados já existentes no banco de dados")
    })
    @PostMapping("/cadastro")
    public ResponseEntity<UsuarioResponseDTO> cadastrarUsuario(@RequestBody @Valid UsuarioRequestDTO usuarioRequestDTO) {

        log.info("Request de usuário recebida: {}", usuarioRequestDTO);
        Usuario usuario = cadastrarUsuarioUseCase.execute(usuarioDTOMapper.toUsuario(usuarioRequestDTO));

        log.info("Usuário cadastrado com sucesso: {}", usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDTOMapper.toUsuarioResponseDTO(usuario));

    }

    @Operation(summary = "Busca todos os usuários", description = "Retorna todos os usuários cadastrados na base PostgreSQL")
    @GetMapping
    public ResponseEntity<Page<UsuarioResponseDTO>> buscarUsuarios(
            @PageableDefault(sort = "nomeCompleto") Pageable pageable) {

        log.info("Request de buscar todos usuários recebida: {}", pageable);
        Page<Usuario> usuarios = buscarUsuarioUseCase.buscarTodosUsuarios(pageable);

        log.info("Convertendo os usuários para response: {}", usuarios);
        Page<UsuarioResponseDTO> usuarioResponseDTOS = usuarios.map(usuarioDTOMapper::toUsuarioResponseDTO);

        log.info("Usuários encontrados e convertidos com sucesso: {}", usuarioResponseDTOS);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioResponseDTOS);

    }

    @Operation(summary = "Busca um usuário pelo id",
            description = "Retorna o usuário pelo id fornecido por parâmetro de URL")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum usuário encontrado com o id fornecido")
    })
    @GetMapping("/buscar/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscarUsuarioPorId(@PathVariable("id") String usuarioId) {

        log.info("Requisição de buscar usuário por id recebida: {}", usuarioId);
        Usuario usuario = buscarUsuarioUseCase.buscarUsuarioPorId(UUID.fromString(usuarioId));

        log.info("Usuário encontrado com sucesso: {}", usuario);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioDTOMapper.toUsuarioResponseDTO(usuario));

    }

    @Operation(summary = "Busca um usuário pelo e-mail",
            description = "Retorna o usuário por meio de query")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum usuário encontrado com os dados fornecidos")
    })
    @GetMapping("/buscar")
    public ResponseEntity<UsuarioResponseDTO> buscarUsuariosPorEmail(
            @RequestParam(name = "email") String email) {

        log.info("Request de buscar usuário por email recebida: {}", email);
        Usuario usuario = buscarUsuarioUseCase.buscarUsuarioPorEmail(email);

        log.info("Usuário encontrado com sucesso: {}", usuario);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioDTOMapper.toUsuarioResponseDTO(usuario));

    }

    @Operation(summary = "Deleta um usuário pelo id",
            description = "Deleta um usuário pelo id fornecido por parâmetro de URL")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Usuário deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum usuário encontrado com o id fornecido")
    })
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarUsuarioPorId(@PathVariable("id") String usuarioId) {

        log.info("Request de deletar usuário por id recebida: {}", usuarioId);
        deletarUsuarioUseCase.execute(UUID.fromString(usuarioId));

        log.info("Usuário deletado com sucesso");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @Operation(summary = "Atualiza um usuário",
            description = "Atualiza um usuário pelo id fornecido por parâmetro de URL e um DTO")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados de requisição inválidos"),
            @ApiResponse(responseCode = "404", description = "Nenhum usuário encontrado com o id fornecido")
    })
    @PreAuthorize("hasAnyRole('FREE_ACCOUNT', 'PREMIUM_ACCOUNT')")
    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<UsuarioResponseDTO> atualizarUsuarioPorId(@PathVariable("id") String usuarioId, @RequestBody UsuarioUpdateRequestDTO usuarioUpdateRequestDTO) {

        log.info("Requisição de atualizar usuário recebida: id {}, usuário {}", usuarioId, usuarioUpdateRequestDTO);
        Usuario usuario = atualizarUsuarioUseCase.atualizarDados(usuarioDTOMapper.toUsuario(usuarioUpdateRequestDTO), UUID.fromString(usuarioId));

        log.info("Usuario atualizado com sucesso: {}", usuario);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioDTOMapper.toUsuarioResponseDTO(usuario));

    }

}
