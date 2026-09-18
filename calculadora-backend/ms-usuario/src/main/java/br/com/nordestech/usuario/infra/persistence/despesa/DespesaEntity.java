package br.com.nordestech.usuario.infra.persistence.despesa;

import br.com.nordestech.usuario.domain.model.enums.TipoDespesa;
import br.com.nordestech.usuario.infra.persistence.pagamento.PagamentoEntity;
import br.com.nordestech.usuario.infra.persistence.usuario.UsuarioEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "DESPESASAS")
@AllArgsConstructor
public class DespesaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "descricao")
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_despesa")
    private TipoDespesa tipoDespesa;

    @OneToOne(mappedBy = "despesaPagamento", cascade = CascadeType.ALL)
    private PagamentoEntity pagamentoDespesa;

    @Column(name = "data_compra")
    private LocalDate dataCompra;

    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;

    @ManyToOne()
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuarioDespesas;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public DespesaEntity() {
        this.createdAt = LocalDateTime.now();
    }

    public DespesaEntity(String descricao, TipoDespesa tipoDespesa, PagamentoEntity pagamentoDespesa, LocalDate dataCompra, LocalDate dataPagamento, UsuarioEntity usuarioDespesas) {
        this();
        this.descricao = descricao;
        this.tipoDespesa = tipoDespesa;
        this.pagamentoDespesa = pagamentoDespesa;
        this.dataCompra = dataCompra;
        this.dataPagamento = dataPagamento;
        this.usuarioDespesas = usuarioDespesas;
    }
}