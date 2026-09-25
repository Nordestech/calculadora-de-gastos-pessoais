package br.com.nordestech.login.presentation.rest.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDTO {

    @NotBlank(message = "O e-mail é obrigatório")
    @JsonProperty("email")
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    @JsonProperty("senha")
    private String senha;

}
