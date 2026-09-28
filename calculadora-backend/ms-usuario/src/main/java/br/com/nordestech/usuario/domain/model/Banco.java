package br.com.nordestech.usuario.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Banco {

    private UUID idBanco;
    private UUID usuarioId;
    private String nomeBanco;
    private BigDecimal saldo;

    public Banco(UUID usuarioId, String nomeBanco, BigDecimal saldo) {
        this.usuarioId = usuarioId;
        this.nomeBanco = nomeBanco;
        this.saldo = saldo;
    }

    protected Banco() {

    }

}
