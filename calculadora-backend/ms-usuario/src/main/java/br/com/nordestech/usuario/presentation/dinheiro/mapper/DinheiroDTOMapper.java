package br.com.nordestech.usuario.presentation.dinheiro.mapper;

import br.com.nordestech.usuario.domain.model.Dinheiro;
import br.com.nordestech.usuario.presentation.dinheiro.rest.request.DinheiroRequestDTO;
import br.com.nordestech.usuario.presentation.dinheiro.rest.request.DinheiroUpdateRequestDTO;
import br.com.nordestech.usuario.presentation.dinheiro.rest.response.DinheiroResponseDTO;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class DinheiroDTOMapper {

    public Dinheiro toDinheiro(DinheiroRequestDTO dto) {

        return Dinheiro.builder()
                .usuarioId(UUID.fromString(dto.usuarioId()))
                .saldo(BigDecimal.valueOf(dto.saldo()))
                .build();

    }

    public Dinheiro toDinheiro(DinheiroUpdateRequestDTO dto) {

        return Dinheiro.builder()
                .saldo(BigDecimal.valueOf(dto.saldo()))
                .build();

    }

    public DinheiroResponseDTO toDinheiroResponseDTO(Dinheiro dinheiro) {

        return DinheiroResponseDTO.builder()
                .dinheiroId(dinheiro.getId())
                .usuarioId(dinheiro.getUsuarioId())
                .saldo(dinheiro.getSaldo())
                .build();

    }

}
