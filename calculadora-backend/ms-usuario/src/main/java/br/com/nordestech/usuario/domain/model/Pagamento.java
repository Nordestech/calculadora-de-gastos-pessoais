package br.com.nordestech.usuario.domain.model;

import br.com.nordestech.usuario.domain.model.enums.TipoPagamento;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Pagamento {

    private UUID id;
    private UUID usuarioId;
    private BigDecimal valor;
    private TipoPagamento tipoPagamento;
    private UUID cartaoId;
    private UUID pixId;
    private UUID dinheiroId;

}
