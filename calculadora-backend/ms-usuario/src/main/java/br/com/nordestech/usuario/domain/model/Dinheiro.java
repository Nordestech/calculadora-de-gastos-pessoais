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
public class Dinheiro {

    private UUID idDinheiro;
    private UUID usuarioId;
    private BigDecimal saldo;

    public Dinheiro(UUID usuarioId, BigDecimal saldo) {
        this.usuarioId = usuarioId;
        this.saldo = saldo;
    }

    protected Dinheiro() {

    }
}
