package br.com.nordestech.usuario.domain.model.type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class TipoGasto {

    private UUID idTipoGasto;
    private UUID usuarioId;
    private Set<String> tipos;

    public TipoGasto(UUID usuarioId, Set<String> tipos) {
        this.usuarioId = usuarioId;
        this.tipos = tipos;
    }

    protected TipoGasto() {
    }
}
