package br.com.nordestech.usuario.domain.model;

import br.com.nordestech.usuario.domain.model.enums.TipoPagamento;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pagamento {

    @EqualsAndHashCode.Include
    private UUID id;
    private BigDecimal valor;
    private TipoPagamento tipoPagamento;
    private UUID cartaoId;
    private UUID pixId;
    private UUID dinheiroId;

}
