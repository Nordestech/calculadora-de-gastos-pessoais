package br.com.nordestech.usuario.presentation.banco.rest;

import br.com.nordestech.usuario.domain.model.Banco;
import br.com.nordestech.usuario.domain.service.banco.AtualizarBancoUseCase;
import br.com.nordestech.usuario.domain.service.banco.BuscarBancoUseCase;
import br.com.nordestech.usuario.domain.service.banco.CadastrarBancoUseCase;
import br.com.nordestech.usuario.domain.service.banco.DeletarBancoUseCase;
import br.com.nordestech.usuario.presentation.banco.mapper.BancoDTOMapper;
import br.com.nordestech.usuario.presentation.banco.rest.request.BancoRequestDTO;
import br.com.nordestech.usuario.presentation.banco.rest.request.SaldoBancoDTO;
import br.com.nordestech.usuario.presentation.banco.rest.response.BancoResponseDTO;
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

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/banco")
@Slf4j
@RequiredArgsConstructor
@Tag(name = "Bancos", description = "Endpoints para gerenciamento dos bancos")
public class BancoController {

    private final AtualizarBancoUseCase atualizarBancoUseCase;
    private final CadastrarBancoUseCase cadastrarBancoUseCase;
    private final DeletarBancoUseCase deletarBancoUseCase;
    private final BuscarBancoUseCase buscarBancoUseCase;

    private final BancoDTOMapper mapper;

    @Operation(summary = "Cadastra um novo banco", description = "Cria um registro de banco na base PostgreSQL")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Banco criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados de requisição inválidos")
    })
    @PreAuthorize("hasAnyRole('FREE_ACCOUNT', 'PREMIUM_ACCOUNT', 'ADMIN', 'MASTER')")
    @PostMapping("/cadastro")
    public ResponseEntity<BancoResponseDTO> cadastrarBanco(@RequestBody @Valid BancoRequestDTO bancoRequestDTO) {

        log.info("Request de novo banco recebida: {}", bancoRequestDTO);
        Banco banco = cadastrarBancoUseCase.execute(mapper.toBanco(bancoRequestDTO));

        log.info("Banco criado com sucesso: {}", banco);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toBancoResponseDTO(banco));

    }
    
    @Operation(summary = "Atualizar saldo do banco",
            description = "Atualiza o saldo do banco pelo id fornecido por parâmetro de URL e um DTO")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Banco atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados de requisição inválidos"),
            @ApiResponse(responseCode = "404", description = "Nenhum banco encontrado com o id fornecido")
    })
    @PreAuthorize("hasAnyRole('FREE_ACCOUNT', 'PREMIUM_ACCOUNT', 'ADMIN', 'MASTER')")
    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<BancoResponseDTO> atualizarSaldoBanco(@PathVariable("id") String bancoId, @RequestBody @Valid SaldoBancoDTO saldoBancoDTO) {

        log.info("Request de atualizar saldo do banco recebida: {}", saldoBancoDTO);
        Banco banco = atualizarBancoUseCase.atualizarSaldo(BigDecimal.valueOf(saldoBancoDTO.valor()), UUID.fromString(bancoId));

        log.info("Banco atualizado com sucesso: {}", banco);
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toBancoResponseDTO(banco));

    }

    @Operation(summary = "Creditar saldo do banco",
            description = "Creditar o saldo do banco pelo id fornecido por parâmetro de URL e um DTO")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Banco atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados de requisição inválidos"),
            @ApiResponse(responseCode = "404", description = "Nenhum banco encontrado com o id fornecido")
    })
    @PreAuthorize("hasAnyRole('FREE_ACCOUNT', 'PREMIUM_ACCOUNT', 'ADMIN', 'MASTER')")
    @PatchMapping("/creditar/{id}")
    public ResponseEntity<BancoResponseDTO> creditarSaldoBanco(@PathVariable("id") String bancoId, @RequestBody @Valid SaldoBancoDTO saldoBancoDTO) {

        log.info("Request de creditar saldo do banco recebida: {}", saldoBancoDTO);
        Banco banco = atualizarBancoUseCase.creditarSaldo(BigDecimal.valueOf(saldoBancoDTO.valor()), UUID.fromString(bancoId));

        log.info("Banco atualizado com sucesso: {}", banco);
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toBancoResponseDTO(banco));

    }

    @Operation(summary = "Deleta um banco pelo id",
            description = "Deleta um banco pelo id fornecido por parâmetro de URL")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Banco deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum banco encontrado com o id fornecido")
    })
    @PreAuthorize("hasAnyRole('FREE_ACCOUNT', 'PREMIUM_ACCOUNT', 'ADMIN', 'MASTER')")
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarBanco(@PathVariable("id") String bancoId) {
        
        log.info("Request de deletar banco recebida: {}", bancoId);
        deletarBancoUseCase.execute(UUID.fromString(bancoId));
        
        log.info("Banco deletado com sucesso: {}", bancoId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        
    }

    @Operation(summary = "Busca todos os bancos por usuário", description = "Retorna todos os bancos, por usuário, cadastrados na base PostgreSQL")
    @GetMapping("/buscar/{id}")
    @PreAuthorize("hasAnyRole('FREE_ACCOUNT', 'PREMIUM_ACCOUNT', 'ADMIN', 'MASTER')")
    public ResponseEntity<Set<BancoResponseDTO>> buscarBancosPorUsuario(@PathVariable("id") String usuarioId) {

        log.info("Request de buscar todos os bancos recebida: {}", usuarioId);
        Set<Banco> bancos = buscarBancoUseCase.buscarBancosPorUsuarioId(UUID.fromString(usuarioId));

        log.info("Convertendo os bancos para response: {}", bancos);
        Set<BancoResponseDTO> bancoResponseDTOS = bancos.stream().map(mapper::toBancoResponseDTO).collect(Collectors.toSet());

        log.info("Bancos buscados e convertidos com sucesso: {}", bancoResponseDTOS);
        return ResponseEntity.status(HttpStatus.OK).body(bancoResponseDTOS);

    }

}
