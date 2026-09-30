package br.com.nordestech.usuario.domain.model;

import br.com.nordestech.usuario.domain.model.abstracts.Pagamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class Pix extends Pagamento {

    private UUID usuarioId;
    private UUID bancoId;
    private String chavePix;

    public Pix(UUID id, UUID usuarioId, UUID bancoId, String chavePix) {
        super(id);
        this.usuarioId = usuarioId;
        this.bancoId = bancoId;
        this.chavePix = chavePix;
    }

    protected Pix() {
    }
}
