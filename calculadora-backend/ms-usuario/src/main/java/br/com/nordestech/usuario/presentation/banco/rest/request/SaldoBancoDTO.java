package br.com.nordestech.usuario.presentation.banco.rest.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public record SaldoBancoDTO(

        @NotNull(message = "O valor é obrigatório")
        @JsonProperty("valor")
        Double valor

) {
}
