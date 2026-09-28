package br.com.nordestech.usuario.domain.model;

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
public class GastoFixo {

    private UUID idGastoFixo;
    private UUID usuarioId;
    private String descricao;
    private String tipoGastoFixo;
    private BigDecimal valor;
    private LocalDate dataReferencia;

    public GastoFixo(UUID usuarioId, String descricao, String tipoGastoFixo, BigDecimal valor) {
        this.usuarioId = usuarioId;
        this.descricao = descricao;
        this.tipoGastoFixo = tipoGastoFixo;
        this.valor = valor;
    }

    protected GastoFixo() {
    }
}
