package br.com.nordestech.usuario.infra.persistence.dinheiro;

import br.com.nordestech.usuario.infra.persistence.usuario.UsuarioEntity;
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
@Table(name = "DINHEIRO")
@AllArgsConstructor
public class DinheiroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(mappedBy = "dinheiro", cascade = CascadeType.ALL)
    private UsuarioEntity usuario;

    @Column(name = "valor", precision = 10, scale = 2, nullable = false)
    private BigDecimal saldo;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public DinheiroEntity() {
        this.updatedAt = LocalDateTime.now();
    }

    public DinheiroEntity(BigDecimal saldo) {
        this();
        this.saldo = saldo;
    }
}