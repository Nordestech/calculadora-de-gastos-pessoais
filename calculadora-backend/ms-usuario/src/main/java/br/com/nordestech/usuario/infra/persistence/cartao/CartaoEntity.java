package br.com.nordestech.usuario.infra.persistence.cartao;

import br.com.nordestech.usuario.domain.model.enums.TipoCartao;
import br.com.nordestech.usuario.infra.persistence.abstracts.PagamentoEntity;
import br.com.nordestech.usuario.infra.persistence.banco.BancoEntity;
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
@Table(name = "CARTOES")
@AllArgsConstructor
public class CartaoEntity extends PagamentoEntity {

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
    private TipoCartao tipoCartao;

    @Column(name = "limite_disponivel", precision = 10, scale = 2, nullable = false)
    private BigDecimal limiteDisponivel;

    @OneToMany(mappedBy = "pagamento", cascade = CascadeType.ALL)
    private Set<GastoEntity> gastos;

    @OneToMany(mappedBy = "pagamento", cascade = CascadeType.ALL)
    private Set<GastoFixoEntity> gastosFixo;

    @Column(name = "dia_vencimento")
    private Integer diaVencimento;

    @Column(name = "updated_At")
    private LocalDateTime updatedAt;

    public CartaoEntity() {
        this.updatedAt = LocalDateTime.now();
    }

    public CartaoEntity(String nomeCartao, TipoCartao tipoCartao, BigDecimal limiteDisponivel, Integer diaVencimento, BancoEntity bancoCartoes, UsuarioEntity usuarioCartoes) {
        this();
        this.nomeCartao = nomeCartao;
        this.tipoCartao = tipoCartao;
        this.limiteDisponivel = limiteDisponivel;
        this.diaVencimento = diaVencimento;
        this.bancoCartoes = bancoCartoes;
        this.usuarioCartoes = usuarioCartoes;
    }
}