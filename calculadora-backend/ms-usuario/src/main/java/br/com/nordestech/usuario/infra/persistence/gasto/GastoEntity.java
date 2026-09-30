package br.com.nordestech.usuario.infra.persistence.gasto;

import br.com.nordestech.usuario.domain.model.enums.TipoPagamento;
import br.com.nordestech.usuario.infra.persistence.abstracts.PagamentoEntity;
import br.com.nordestech.usuario.infra.persistence.usuario.UsuarioEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "GASTOS")
@AllArgsConstructor
public class GastoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuarioGastos;

    @Column(name = "descricao", nullable = false, length = 50)
    private String descricao;

    @Column(name = "tipo_gasto", nullable = false)
    private String tipoGasto;

    @Column(name = "valor", precision = 10, scale = 2, nullable = false)
    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_pagamento")
    private TipoPagamento tipoPagamento;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "pagamento_id")
    private PagamentoEntity pagamento;

    @Column(name = "data_compra")
    private LocalDate dataCompra;

    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public GastoEntity() {
        this.createdAt = LocalDateTime.now();
    }

    public GastoEntity(UsuarioEntity usuarioGastos, String descricao, String tipoGasto, BigDecimal valor, TipoPagamento tipoPagamento, PagamentoEntity pagamento, LocalDate dataCompra, LocalDate dataPagamento) {
        this();
        this.usuarioGastos = usuarioGastos;
        this.descricao = descricao;
        this.tipoGasto = tipoGasto;
        this.valor = valor;
        this.tipoPagamento = tipoPagamento;
        this.pagamento = pagamento;
        this.dataCompra = dataCompra;
        this.dataPagamento = dataPagamento;
    }
}
