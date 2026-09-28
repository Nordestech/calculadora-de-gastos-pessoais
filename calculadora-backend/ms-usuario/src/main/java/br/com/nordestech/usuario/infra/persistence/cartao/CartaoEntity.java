package br.com.nordestech.usuario.infra.persistence.cartao;

import br.com.nordestech.usuario.domain.model.enums.TipoCartao;
import br.com.nordestech.usuario.infra.persistence.banco.BancoEntity;
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
@Table(name = "CARTOES")
@AllArgsConstructor
public class CartaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuarioCartoes;

    @Column(name = "nome_cartao")
    private String nomeCartao;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "banco_id")
    private BancoEntity bancoCartoes;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipos_cartao")
    private Set<TipoCartao> tiposCartao;

    @Column(name = "limite_disponivel", precision = 10, scale = 2, nullable = false)
    private BigDecimal limiteDisponivel;

    @Column(name = "dia_vencimento")
    private Integer diaVencimento;


    @Column(name = "updated_At")
    private LocalDateTime updatedAt;

    public CartaoEntity() {
        this.updatedAt = LocalDateTime.now();
    }

    public CartaoEntity(String nomeCartao, Set<TipoCartao> tiposCartao, BigDecimal limiteDisponivel, Integer diaVencimento, UsuarioEntity usuarioCartoes) {
        this();
        this.nomeCartao = nomeCartao;
        this.tiposCartao = tiposCartao;
        this.limiteDisponivel = limiteDisponivel;
        this.diaVencimento = diaVencimento;
        this.usuarioCartoes = usuarioCartoes;
    }
}