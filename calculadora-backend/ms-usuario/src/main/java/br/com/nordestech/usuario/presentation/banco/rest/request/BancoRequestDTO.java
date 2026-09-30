package br.com.nordestech.usuario.presentation.banco.rest.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record BancoRequestDTO(

        @NotBlank(message = "usuario_id é obrigatório")
        @JsonProperty("usuario_id")
        String usuarioId,

        @NotBlank(message = "O nome_banco é obrigatório")
        @JsonProperty("nome_banco")
        String nomeBanco

) {
}
