package br.com.nordestech.usuario.domain.model;

import br.com.nordestech.usuario.domain.model.abstracts.Pagamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class Dinheiro extends Pagamento {

    private UUID usuarioId;
    private BigDecimal saldo;

    public Dinheiro(UUID id, UUID usuarioId, BigDecimal saldo) {
        super(id);
        this.usuarioId = usuarioId;
        this.saldo = saldo;
    }

    protected Dinheiro() {

    }
}
