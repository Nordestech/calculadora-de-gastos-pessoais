package br.com.nordestech.usuario.presentation.dinheiro.rest;

import br.com.nordestech.usuario.domain.model.Dinheiro;
import br.com.nordestech.usuario.domain.service.dinheiro.AtualizarDinheiroUseCase;
import br.com.nordestech.usuario.domain.service.dinheiro.BuscarDinheiroUseCase;
import br.com.nordestech.usuario.domain.service.dinheiro.CadastrarDinheiroUseCase;
import br.com.nordestech.usuario.domain.service.dinheiro.DeletarDinheiroUseCase;
import br.com.nordestech.usuario.presentation.dinheiro.mapper.DinheiroDTOMapper;
import br.com.nordestech.usuario.presentation.dinheiro.rest.request.DinheiroRequestDTO;
import br.com.nordestech.usuario.presentation.dinheiro.rest.request.DinheiroUpdateRequestDTO;
import br.com.nordestech.usuario.presentation.dinheiro.rest.response.DinheiroResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/dinhero")
@Slf4j
@RequiredArgsConstructor
@Tag(name = "Dinheiro", description = "Endpoints para gerenciamento do dinheiro")
public class DinheiroController {

    private final CadastrarDinheiroUseCase cadastrarDinheiroUseCase;
    private final BuscarDinheiroUseCase buscarDinheiroUseCase;
    private final AtualizarDinheiroUseCase atualizarDinheiroUseCase;
    private final DeletarDinheiroUseCase deletarDinheiroUseCase;

    private final DinheiroDTOMapper dinheiroDTOMapper;

    @Operation(summary = "Cadastra um novo dinheiro", description = "Cria um registro de dinheiro na base PostgreSQL")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Dinheiro criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados de requisição inválidos")
    })
    @PreAuthorize("hasAnyRole('FREE_ACCOUNT', 'PREMIUM_ACCOUNT', 'ADMIN', 'MASTER')")
    @PostMapping("/cadastrar")
    public ResponseEntity<DinheiroResponseDTO> cadastarDinheiro(@RequestBody @Valid DinheiroRequestDTO dinheiroRequestDTO) {

        log.info("Request de novo dinheiro recebido: {}", dinheiroRequestDTO);
        Dinheiro dinheiro = cadastrarDinheiroUseCase.execute(dinheiroDTOMapper.toDinheiro(dinheiroRequestDTO));
        
        log.info("Dinheiro cadastrado com sucesso: {}", dinheiro);
        return ResponseEntity.status(HttpStatus.OK).body(dinheiroDTOMapper.toDinheiroResponseDTO(dinheiro));

    }

    @Operation(summary = "Atualizar saldo do dinheiro",
            description = "Atualiza o saldo do dinheiro pelo id fornecido por parâmetro de URL e um DTO")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dinheiro atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados de requisição inválidos"),
            @ApiResponse(responseCode = "404", description = "Nenhum dinheiro encontrado com o id fornecido")
    })
    @PreAuthorize("hasAnyRole('FREE_ACCOUNT', 'PREMIUM_ACCOUNT', 'ADMIN', 'MASTER')")
    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<DinheiroResponseDTO> atualizarSaldo(
            @PathVariable("id") String dinheiroId,
            @RequestBody @Valid DinheiroUpdateRequestDTO dinheiroUpdateRequestDTO) {

        log.info("Request de atualizar dinheiro recebido: {}", dinheiroUpdateRequestDTO);
        Dinheiro dinheiro = atualizarDinheiroUseCase.atualizarSaldo(dinheiroDTOMapper.toDinheiro(dinheiroUpdateRequestDTO), UUID.fromString(dinheiroId));

        log.info("Dinheiro atualizado com sucesso: {}", dinheiro);
        return ResponseEntity.status(HttpStatus.OK).body(dinheiroDTOMapper.toDinheiroResponseDTO(dinheiro));

    }

    @Operation(summary = "Busca o dinheiro por usuário", description = "Retorna o dinheiro, por usuário, cadastrado na base PostgreSQL")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dinheiro encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum usuário encontrado com o id fornecido")
    })
    @PreAuthorize("hasAnyRole('FREE_ACCOUNT', 'PREMIUM_ACCOUNT', 'ADMIN', 'MASTER')")
    @GetMapping("/buscar/{id}")
    public ResponseEntity<DinheiroResponseDTO> buscarDinheiro(@PathVariable("id") String usuarioId) {

        log.info("Request de buscar dinheiro recebido: {}", usuarioId);
        Dinheiro dinheiro = buscarDinheiroUseCase.buscarDinheiroPorUsuarioId(UUID.fromString(usuarioId));

        log.info("Dinheiro buscado com sucesso: {}", dinheiro);
        return ResponseEntity.status(HttpStatus.OK).body(dinheiroDTOMapper.toDinheiroResponseDTO(dinheiro));
    
    }

    @Operation(summary = "Deleta um dinheiro pelo id",
            description = "Deleta um dinheiro pelo id fornecido por parâmetro de URL")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Dinheiro deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum dinheiro encontrado com o id fornecido")
    })
    @PreAuthorize("hasAnyRole('FREE_ACCOUNT', 'PREMIUM_ACCOUNT', 'ADMIN', 'MASTER')")
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarDinheiro(@PathVariable("id") String dinheiroId) {
        
        log.info("Request de deletar dinheiro recebido: {}", dinheiroId);
        deletarDinheiroUseCase.execute(UUID.fromString(dinheiroId));
        
        log.info("Dinheiro deletado com sucesso: {}", dinheiroId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        
    }

}
