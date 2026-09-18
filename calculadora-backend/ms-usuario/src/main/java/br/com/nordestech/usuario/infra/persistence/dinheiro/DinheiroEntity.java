package br.com.nordestech.usuario.infra.persistence.dinheiro;

import br.com.nordestech.usuario.infra.persistence.pagamento.PagamentoEntity;
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
public class DinheiroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "valor", precision = 10, scale = 2, nullable = false)
    private BigDecimal valor;

    @OneToOne(mappedBy = "dinheiroPagamento", cascade = CascadeType.ALL)
    private PagamentoEntity pagamentoDinheiro;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public DinheiroEntity() {
        this.updatedAt = LocalDateTime.now();
    }

    public DinheiroEntity(BigDecimal valor) {
        this();
        this.valor = valor;
    }
}