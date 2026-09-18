package br.com.nordestech.usuario.infra.persistence.pagamento;

import br.com.nordestech.usuario.domain.model.enums.TipoPagamento;
import br.com.nordestech.usuario.infra.persistence.cartao.CartaoEntity;
import br.com.nordestech.usuario.infra.persistence.despesa.DespesaEntity;
import br.com.nordestech.usuario.infra.persistence.dinheiro.DinheiroEntity;
import br.com.nordestech.usuario.infra.persistence.pix.PixEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table
@AllArgsConstructor
public class PagamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "valor", precision = 10, scale = 2, nullable = false)
    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_pagamento", nullable = false)
    private TipoPagamento tipoPagamento;

    @OneToOne(mappedBy = "pagamentoCartao", cascade = CascadeType.ALL)
    private CartaoEntity cartaoPagamento;

    @OneToOne(mappedBy = "pagamentoPix", cascade = CascadeType.ALL)
    private PixEntity pixPagamento;

    @OneToOne(mappedBy = "pagamentoDinheiro", cascade = CascadeType.ALL)
    private DinheiroEntity dinheiroPagamento;

    @OneToOne(mappedBy = "pagamentoDespesa", cascade = CascadeType.ALL)
    private DespesaEntity despesaPagamento;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public PagamentoEntity() {
        this.createdAt = LocalDateTime.now();
    }

    public PagamentoEntity(BigDecimal valor, TipoPagamento tipoPagamento, CartaoEntity cartaoPagamento) {
        this();
        this.valor = valor;
        this.tipoPagamento = tipoPagamento;
        this.cartaoPagamento = cartaoPagamento;
    }

    public PagamentoEntity(BigDecimal valor, TipoPagamento tipoPagamento, PixEntity pixPagamento) {
        this();
        this.valor = valor;
        this.tipoPagamento = tipoPagamento;
        this.pixPagamento = pixPagamento;
    }

    public PagamentoEntity(BigDecimal valor, TipoPagamento tipoPagamento, DinheiroEntity dinheiroPagamento) {
        this();
        this.valor = valor;
        this.tipoPagamento = tipoPagamento;
        this.dinheiroPagamento = dinheiroPagamento;
    }
}