package br.com.nordestech.usuario.domain.model;

import br.com.nordestech.usuario.domain.exceptions.BusinessRuleException;
import br.com.nordestech.usuario.domain.exceptions.enums.ErrorCode;
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

    public void debitar(BigDecimal valor) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new BusinessRuleException(ErrorCode.VALOR_INVALIDO);
        }
        if (this.saldo.compareTo(valor) < 0) {
            throw new BusinessRuleException(ErrorCode.SALDO_INSUFICIENTE);
        }
        this.saldo = this.saldo.subtract(valor);
    }

    public void creditar(BigDecimal valor) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new BusinessRuleException(ErrorCode.VALOR_INVALIDO);
        }
        this.saldo = this.saldo.add(valor);
    }
}
