package br.com.nordestech.usuario.domain.model;

import br.com.nordestech.usuario.domain.model.enums.TipoCartao;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Cartao {

    private UUID id;
    private UUID usuarioId;
    private String nomeCartao;
    private Set<TipoCartao> tiposCartao;
    private BigDecimal limiteDisponivel;
    private Integer diaVencimento;

}
