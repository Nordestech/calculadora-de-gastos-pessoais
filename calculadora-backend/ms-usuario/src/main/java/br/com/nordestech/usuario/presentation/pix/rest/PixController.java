package br.com.nordestech.usuario.presentation.pix.rest;

import br.com.nordestech.usuario.domain.model.Pix;
import br.com.nordestech.usuario.domain.service.pix.BuscarPixUseCase;
import br.com.nordestech.usuario.domain.service.pix.CadastrarPixUseCase;
import br.com.nordestech.usuario.domain.service.pix.DeletarPixUseCase;
import br.com.nordestech.usuario.presentation.pix.mapper.PixDTOMapper;
import br.com.nordestech.usuario.presentation.pix.rest.request.PixRequestDTO;
import br.com.nordestech.usuario.presentation.pix.rest.response.PixResponseDTO;
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

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pix")
@Slf4j
@RequiredArgsConstructor
@Tag(name = "Pix", description = "Endpoint para gerenciamento do pix")
public class PixController {
    
    private final CadastrarPixUseCase cadastrarPixUseCase;
    private final BuscarPixUseCase buscarPixUseCase;
    private final DeletarPixUseCase deletarPixUseCase;
    
    private final PixDTOMapper pixDTOMapper;

    @Operation(summary = "Cadastra um novo pix", description = "Cria um registro de pix na base PostgreSQL")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pix criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados de requisição inválidos")
    })
    @PreAuthorize("hasAnyRole('FREE_ACCOUNT', 'PREMIUM_ACCOUNT', 'ADMIN', 'MASTER')")
    @PostMapping("/cadastro")
    public ResponseEntity<PixResponseDTO> cadastrarPix(@RequestBody @Valid PixRequestDTO pixRequestDTO) {
        
        log.info("Request de novo pix recebido: {}", pixRequestDTO);
        Pix pix = cadastrarPixUseCase.execute(pixDTOMapper.toPix(pixRequestDTO));
        
        log.info("Pix cadastrado com sucesso: {}", pix);
        return ResponseEntity.status(HttpStatus.OK).body(pixDTOMapper.toPixResponseDTO(pix));

    }

    @Operation(summary = "Busca todos os bancos por usuário", description = "Retorna todos os bancos, por usuário, cadastrados na base PostgreSQL")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pix encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum usuário encontrado com o id fornecido")
    })
    @PreAuthorize("hasAnyRole('FREE_ACCOUNT', 'PREMIUM_ACCOUNT', 'ADMIN', 'MASTER')")
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Set<PixResponseDTO>> buscarPix(@PathVariable("id") String usuarioId) {
        
        log.info("Request de buscar pix recebido: {}", usuarioId);
        Set<Pix> pixes = buscarPixUseCase.buscarPixsPorUsuarioId(UUID.fromString(usuarioId));
        
        log.info("Convertendo os pix para response: {}", pixes);
        Set<PixResponseDTO> pixResponseDTOS = pixes.stream().map(pixDTOMapper::toPixResponseDTO).collect(Collectors.toSet());
        
        log.info("Pix buscados e convertidos com sucesso: {}", pixResponseDTOS);
        return ResponseEntity.status(HttpStatus.OK).body(pixResponseDTOS);
        
    }

    @Operation(summary = "Deleta um pix pelo id",
            description = "Deleta um pix pelo id fornecido por parâmetro de URL")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Pix deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum pix encontrado com o id fornecido")
    })
    @PreAuthorize("hasAnyRole('FREE_ACCOUNT', 'PREMIUM_ACCOUNT', 'ADMIN', 'MASTER')")
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarPix(@PathVariable("id") String pixId) {
        
        log.info("Request de deletar pix recebido: {}", pixId);
        deletarPixUseCase.execute(UUID.fromString(pixId));
        
        log.info("Pix deletado com sucesso: {}", pixId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        
    }
    
}
