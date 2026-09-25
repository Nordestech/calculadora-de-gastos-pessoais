package br.com.nordestech.login.presentation.rest.response;

import br.com.nordestech.usuario.domain.model.enums.PerfilEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDTO {

    @JsonProperty("token")
    private String token;

    @JsonProperty("type")
    private String type;

    @JsonProperty("usuarioId")
    private UUID usuarioId;

    @JsonProperty("perfis")
    private Set<PerfilEnum> perfis;

}
