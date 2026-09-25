package br.com.nordestech.usuario.domain.model;

import br.com.nordestech.usuario.domain.model.enums.TipoDespesa;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Despesa {

    private UUID id;
    private UUID usuarioId;
    private String descricao;
    private TipoDespesa tipoDespesa;
    private UUID pagamentoId;
    private LocalDate dataCompra;
    private LocalDate dataPagamento;

}
