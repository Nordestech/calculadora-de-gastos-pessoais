package br.com.nordestech.usuario.domain.model;

import br.com.nordestech.usuario.domain.model.enums.TipoPagamento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Gasto {

    private UUID idGasto;
    private UUID usuarioId;
    private String descricao;
    private String tipoGasto;
    private BigDecimal valor;
    private TipoPagamento tipoPagamento;
    private UUID pagamentoId;
    private LocalDate dataCompra;
    private LocalDate dataPagamento;

    public Gasto(UUID usuarioId, String descricao, String tipoGasto, BigDecimal valor, TipoPagamento tipoPagamento, UUID pagamentoId, LocalDate dataCompra) {
        this.usuarioId = usuarioId;
        this.descricao = descricao;
        this.tipoGasto = tipoGasto;
        this.valor = valor;
        this.tipoPagamento = tipoPagamento;
        this.pagamentoId = pagamentoId;
        this.dataCompra = dataCompra;
    }

    protected Gasto() {
    }
}
