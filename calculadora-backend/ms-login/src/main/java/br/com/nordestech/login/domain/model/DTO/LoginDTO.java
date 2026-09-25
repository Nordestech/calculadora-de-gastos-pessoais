package br.com.nordestech.login.domain.model.DTO;

import br.com.nordestech.usuario.domain.model.enums.PerfilEnum;

import java.util.Set;
import java.util.UUID;

public record LoginDTO(
        String token,
        String type,
        UUID usuarioId,
        Set<PerfilEnum> perfis
) {

    public LoginDTO(String token, UUID usuarioId, Set<PerfilEnum> perfis) {
        this(token, "Bearer", usuarioId, perfis);
    }
}