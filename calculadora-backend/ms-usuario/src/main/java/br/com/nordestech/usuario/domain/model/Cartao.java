package br.com.nordestech.usuario.domain.model;

import br.com.nordestech.usuario.domain.model.abstracts.Pagamento;
import br.com.nordestech.usuario.domain.model.enums.TipoCartao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class Cartao extends Pagamento {

    private UUID usuarioId;
    private String nomeCartao;
    private UUID bancoId;
    private Set<TipoCartao> tiposCartao;
    private BigDecimal limiteDisponivel;
    private Integer diaVencimento;

    public Cartao(UUID id, UUID usuarioId, String nomeCartao, UUID bancoId, Set<TipoCartao> tiposCartao, BigDecimal limiteDisponivel, Integer diaVencimento) {
        super(id);
        this.usuarioId = usuarioId;
        this.nomeCartao = nomeCartao;
        this.bancoId = bancoId;
        this.tiposCartao = tiposCartao;
        this.limiteDisponivel = limiteDisponivel;
        this.diaVencimento = diaVencimento;
    }

    protected Cartao() {

    }
}
