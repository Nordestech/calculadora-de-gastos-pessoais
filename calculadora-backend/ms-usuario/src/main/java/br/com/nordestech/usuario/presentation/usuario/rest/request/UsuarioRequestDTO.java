package br.com.nordestech.usuario.presentation.usuario.rest.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Builder;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

@Builder
public record UsuarioRequestDTO(

        @NotNull(message = "O E-mail é obrigatório.")
        @Email(message = "E-mail inválido")
        @JsonProperty("email")
        String email,

        @NotBlank(message = "A senha é obrigatória")
        @Size(min = 8, max = 64, message = "A senha deve ter entre 8 e 64 caracteres")
        @Pattern(
                regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).*$",
                message = "A senha deve conter ao menos uma letra maiúscula, uma minúscula, um número e um caractere especial."
        )
        @JsonProperty("senha")
        String senha,

        @NotBlank(message = "O nome completo é obrigatório.")
        @Length(min = 7, max = 40, message = "O nome deve conter entre 7 a 40 caracteres")
        @JsonProperty("nome_completo")
        String nomeCompleto,

        @NotNull(message = "O CPF é obrigatório.")
        @CPF(message = "CPF inválido")
        @JsonProperty("cpf")
        String cpf,

        @NotBlank(message = "A data de nascimento é obrigatória.")
        @Pattern(
                regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$",
                message = "A data deve estar no formato DD/MM/AAAA (ex: 25/12/1995)."
        )
        @JsonProperty("data_nascimento")
        String dataNascimento

) {
}
