package br.com.nordestech.usuario.infra.persistence.banco;

import br.com.nordestech.usuario.infra.persistence.pix.PixEntity;
import br.com.nordestech.usuario.infra.persistence.receita.ReceitaEntity;
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
@Table(name = "BANCOS")
@AllArgsConstructor
public class BancoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome_banco")
    private String nomeBanco;

    @Column(name = "valor_disponivel", precision = 10, scale = 2, nullable = false)
    private BigDecimal valorDisponivel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receita_id")
    private ReceitaEntity receitaBancos;

    @OneToOne(mappedBy = "banco")
    private PixEntity pix;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public BancoEntity() {
        this.updatedAt = LocalDateTime.now();
    }

    public BancoEntity(String nomeBanco, BigDecimal valorDisponivel) {
        this();
        this.nomeBanco = nomeBanco;
        this.valorDisponivel = valorDisponivel;
    }

}