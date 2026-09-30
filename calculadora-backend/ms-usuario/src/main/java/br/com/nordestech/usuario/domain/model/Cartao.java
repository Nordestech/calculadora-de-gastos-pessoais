package br.com.nordestech.usuario.domain.model;

import br.com.nordestech.usuario.domain.exceptions.BusinessRuleException;
import br.com.nordestech.usuario.domain.exceptions.enums.ErrorCode;
import br.com.nordestech.usuario.domain.model.abstracts.Pagamento;
import br.com.nordestech.usuario.domain.model.enums.TipoCartao;
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
public class Cartao extends Pagamento {

    private UUID usuarioId;
    private String nomeCartao;
    private UUID bancoId;
    private TipoCartao tipoCartao;
    private BigDecimal limiteDisponivel;
    private Integer diaVencimento;

    public Cartao(UUID id, UUID usuarioId, String nomeCartao, UUID bancoId, TipoCartao tipoCartao, BigDecimal limiteDisponivel, Integer diaVencimento) {
        super(id);
        this.usuarioId = usuarioId;
        this.nomeCartao = nomeCartao;
        this.bancoId = bancoId;
        this.tipoCartao = tipoCartao;
        this.limiteDisponivel = limiteDisponivel;
        this.diaVencimento = diaVencimento;
    }

    protected Cartao() {

    }

    public void debitar(BigDecimal valor) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new BusinessRuleException(ErrorCode.VALOR_INVALIDO);
        }
        if (this.limiteDisponivel.compareTo(valor) < 0) {
            throw new BusinessRuleException(ErrorCode.SALDO_INSUFICIENTE);
        }
        this.limiteDisponivel = this.limiteDisponivel.subtract(valor);
    }

    public void creditar(BigDecimal valor) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new BusinessRuleException(ErrorCode.VALOR_INVALIDO);
        }
        this.limiteDisponivel = this.limiteDisponivel.add(valor);
    }
}
