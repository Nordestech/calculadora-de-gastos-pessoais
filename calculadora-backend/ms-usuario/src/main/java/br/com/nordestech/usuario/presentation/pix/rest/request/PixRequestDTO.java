package br.com.nordestech.usuario.presentation.pix.rest.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record PixRequestDTO(

        @NotBlank(message = "O usuario_id é obrigatório")
        @JsonProperty("usuario_id")
        String usuarioId,

        @NotBlank(message = "O banco_id é obrigatório")
        @JsonProperty("banco_id")
        String bancoId,

        @NotBlank(message = "A chave_pix é obrigatória")
        @JsonProperty("chave_pix")
        String chavePix

) {
}
