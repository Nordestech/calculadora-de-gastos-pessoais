package br.com.nordestech.usuario.presentation.dinheiro.rest.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

@Builder
public record DinheiroUpdateRequestDTO(

        @NotNull(message = "O saldo é obrigatório")
        @Positive(message = "O saldo deve ser maior que ou igual a 0")
        @JsonProperty("saldo")
        Double saldo

) {
}
