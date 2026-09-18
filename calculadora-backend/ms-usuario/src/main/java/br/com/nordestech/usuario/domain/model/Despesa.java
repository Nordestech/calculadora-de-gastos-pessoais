package br.com.nordestech.usuario.domain.model;

import br.com.nordestech.usuario.domain.model.enums.TipoDespesa;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Despesa {

    @EqualsAndHashCode.Include
    private UUID id;
    private String descricao;
    private TipoDespesa tipoDespesa;
    private UUID pagamentoId;
    private LocalDate dataCompra;
    private LocalDate dataPagamento;

}
