package br.com.nordestech.usuario.infra.persistence.banco;

import br.com.nordestech.usuario.infra.persistence.cartao.CartaoEntity;
import br.com.nordestech.usuario.infra.persistence.pix.PixEntity;
import br.com.nordestech.usuario.infra.persistence.usuario.UsuarioEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuarioBanco;

    @Column(name = "nome_banco")
    private String nomeBanco;

    @Column(name = "saldo", precision = 10, scale = 2, nullable = false)
    private BigDecimal saldo;

    @OneToOne(mappedBy = "banco")
    private PixEntity pix;

    @OneToMany(mappedBy = "bancoCartoes", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CartaoEntity> cartoes;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public BancoEntity() {
        this.updatedAt = LocalDateTime.now();
    }

    public BancoEntity(String nomeBanco, BigDecimal saldo) {
        this();
        this.nomeBanco = nomeBanco;
        this.saldo = saldo;
    }

}