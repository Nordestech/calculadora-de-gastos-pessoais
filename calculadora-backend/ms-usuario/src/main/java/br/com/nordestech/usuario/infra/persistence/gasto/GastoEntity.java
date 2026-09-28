package br.com.nordestech.usuario.infra.persistence.gasto;

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

    @Column(name = "data_compra")
    private LocalDate dataCompra;

    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public GastoEntity() {
        this.createdAt = LocalDateTime.now();
    }

    public GastoEntity(String descricao, String tipoGasto, BigDecimal valor, LocalDate dataCompra, LocalDate dataPagamento) {
        this();
        this.descricao = descricao;
        this.tipoGasto = tipoGasto;
        this.valor = valor;
        this.dataCompra = dataCompra;
        this.dataPagamento = dataPagamento;
    }

}
