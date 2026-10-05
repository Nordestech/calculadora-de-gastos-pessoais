package br.com.nordestech.usuario.presentation.pix.rest.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.UUID;

@Builder
public record PixResponseDTO(

        @JsonProperty("pix_id")
        UUID pixId,

        @JsonProperty("usuario_id")
        UUID usuarioId,

        @JsonProperty("banco_id")
        UUID bancoId,

        @JsonProperty("chave_pix")
        String chavePix

) {
}
