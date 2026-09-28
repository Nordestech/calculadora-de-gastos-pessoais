package br.com.nordestech.usuario.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Pix {

    private UUID idPix;
    private UUID bancoId;
    private String chavePix;

    public Pix(UUID bancoId, String chavePix) {
        this.bancoId = bancoId;
        this.chavePix = chavePix;
    }

    protected Pix() {
    }
}
