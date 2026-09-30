package br.com.nordestech.usuario.presentation.usuario.rest.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import lombok.Builder;
import org.hibernate.validator.constraints.Length;

@Builder
public record UsuarioUpdateRequestDTO(

        @Email(message = "E-mail inválido")
        @JsonProperty("email")
        String email,

        @Length(min = 7, max = 40, message = "O nome deve conter entre 7 a 40 caracteres")
        @JsonProperty("nome_completo")
        String nomeCompleto

) {
}
