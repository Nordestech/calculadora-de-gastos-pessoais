package br.com.nordestech.usuario.infra.persistence.gastoFixo;

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
@Table(name = "GASTOS_FIXOS")
@AllArgsConstructor
public class GastoFixoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuarioGastosFixos;

    @Column(name = "descricao", nullable = false, length = 50)
    private String descricao;

    @Column(name = "tipo_gasto_fixo", nullable = false)
    private String tipoGastoFixo;

    @Column(name = "valor", precision = 10, scale = 2, nullable = false)
    private BigDecimal valor;

    @Column(name = "data_referencia")
    private LocalDate dataReferencia;

    @Column(name = "created_at")
    private LocalDateTime createdAt;


    public GastoFixoEntity() {
        this.createdAt = LocalDateTime.now();
    }

    public GastoFixoEntity(String descricao, String tipoGastoFixo, BigDecimal valor, LocalDate dataReferencia) {
        this();
        this.descricao = descricao;
        this.tipoGastoFixo = tipoGastoFixo;
        this.valor = valor;
        this.dataReferencia = dataReferencia;
    }
}
