package br.com.nordestech.usuario.infra.persistence.dinheiro;

import br.com.nordestech.usuario.infra.persistence.abstracts.PagamentoEntity;
import br.com.nordestech.usuario.infra.persistence.gasto.GastoEntity;
import br.com.nordestech.usuario.infra.persistence.gastoFixo.GastoFixoEntity;
import br.com.nordestech.usuario.infra.persistence.usuario.UsuarioEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "DINHEIRO")
@AllArgsConstructor
public class DinheiroEntity extends PagamentoEntity {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuario;

    @OneToMany(mappedBy = "pagamento", cascade = CascadeType.ALL)
    private Set<GastoEntity> gastos;

    @OneToMany(mappedBy = "pagamento", cascade = CascadeType.ALL)
    private Set<GastoFixoEntity> gastosFixo;

    @Column(name = "valor", precision = 10, scale = 2, nullable = false)
    private BigDecimal saldo;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public DinheiroEntity() {
        this.updatedAt = LocalDateTime.now();
    }

    public DinheiroEntity(UsuarioEntity usuario, BigDecimal saldo) {
        this();
        this.usuario = usuario;
        this.saldo = saldo;
    }

    public DinheiroEntity(BigDecimal saldo) {
        this();
        this.saldo = saldo;
    }
}