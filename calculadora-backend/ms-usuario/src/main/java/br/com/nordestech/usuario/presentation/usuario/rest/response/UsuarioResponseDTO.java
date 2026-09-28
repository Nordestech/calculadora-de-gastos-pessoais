package br.com.nordestech.usuario.presentation.usuario.rest.response;

import br.com.nordestech.usuario.domain.model.enums.PerfilEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Builder
public record UsuarioResponseDTO(

        @JsonProperty("id_usuario")
        UUID idUsuario,

        @JsonProperty("email")
        String email,

        @JsonProperty("nome_completo")
        String nomeCompleto,

        @JsonProperty("cpf")
        String cpf,

        @JsonProperty("data_nascimento")
        LocalDate dataNascimento,

        @JsonProperty("perfis")
        Set<PerfilEnum> perfis

) {
}
