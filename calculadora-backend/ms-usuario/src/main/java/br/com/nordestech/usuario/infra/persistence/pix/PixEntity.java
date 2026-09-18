package br.com.nordestech.usuario.infra.persistence.pix;

import br.com.nordestech.usuario.infra.persistence.banco.BancoEntity;
import br.com.nordestech.usuario.infra.persistence.pagamento.PagamentoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "PIX")
@AllArgsConstructor
public class PixEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(mappedBy = "pix", cascade = CascadeType.ALL)
    private BancoEntity banco;

    @Column(name = "chave_pix", nullable = false, unique = true)
    private String chavePix;

    @OneToOne(mappedBy = "pix", cascade = CascadeType.ALL)
    private PagamentoEntity pagamento;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public PixEntity() {
        this.createdAt = LocalDateTime.now();
    }

    public PixEntity(BancoEntity banco, String chavePix) {
        this();
        this.banco = banco;
        this.chavePix = chavePix;
    }
}