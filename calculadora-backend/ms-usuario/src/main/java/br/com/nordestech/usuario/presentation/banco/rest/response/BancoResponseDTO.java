package br.com.nordestech.usuario.presentation.banco.rest.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public record BancoResponseDTO(

        @JsonProperty("id_banco")
        UUID idBanco,

        @JsonProperty("usuario_id")
        UUID usuarioId,

        @JsonProperty("nome_banco")
        String nomeBanco,

        @JsonProperty("saldo")
        BigDecimal saldo

) {
}
