package br.com.nordestech.usuario.presentation.banco.mapper;

import br.com.nordestech.usuario.domain.model.Banco;
import br.com.nordestech.usuario.presentation.banco.rest.request.BancoRequestDTO;
import br.com.nordestech.usuario.presentation.banco.rest.response.BancoResponseDTO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BancoDTOMapper {

    public Banco toBanco(BancoRequestDTO dto) {
        return Banco.builder()
                .usuarioId(UUID.fromString(dto.usuarioId()))
                .nomeBanco(dto.nomeBanco())
                .build();
    }

    public BancoResponseDTO toBancoResponseDTO(Banco banco) {

        return BancoResponseDTO.builder()
                .idBanco(banco.getIdBanco())
                .usuarioId(banco.getUsuarioId())
                .nomeBanco(banco.getNomeBanco())
                .saldo(banco.getSaldo())
                .build();
    }

}
