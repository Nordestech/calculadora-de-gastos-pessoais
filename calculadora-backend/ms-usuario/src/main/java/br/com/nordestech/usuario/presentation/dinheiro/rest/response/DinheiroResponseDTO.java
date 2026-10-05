package br.com.nordestech.usuario.presentation.dinheiro.rest.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public record DinheiroResponseDTO(

        @JsonProperty("dinheiro_id")
        UUID dinheiroId,

        @JsonProperty("usuario_id")
        UUID usuarioId,

        @JsonProperty("saldo")
        BigDecimal saldo

) {
}
