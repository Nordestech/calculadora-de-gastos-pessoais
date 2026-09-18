package br.com.nordestech.usuario.domain.model;

import br.com.nordestech.usuario.domain.model.enums.TipoCartao;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cartao {

    @EqualsAndHashCode.Include
    private UUID id;
    private String nomeCartao;
    private Set<TipoCartao> tiposCartao;
    private BigDecimal limiteDisponivel;
    private Integer diaVencimento;

}
