package br.com.nordestech.usuario.domain.model;

import br.com.nordestech.usuario.domain.exceptions.BusinessRuleException;
import br.com.nordestech.usuario.domain.exceptions.enums.ErrorCode;
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

    public Banco(UUID usuarioId, String nomeBanco) {
        this.usuarioId = usuarioId;
        this.nomeBanco = nomeBanco;
        this.saldo = BigDecimal.ZERO;
    }

    protected Banco() {

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
