package br.com.nordestech.usuario.infra.persistence.pix;

import br.com.nordestech.usuario.infra.persistence.abstracts.PagamentoEntity;
import br.com.nordestech.usuario.infra.persistence.banco.BancoEntity;
import br.com.nordestech.usuario.infra.persistence.gasto.GastoEntity;
import br.com.nordestech.usuario.infra.persistence.gastoFixo.GastoFixoEntity;
import br.com.nordestech.usuario.infra.persistence.usuario.UsuarioEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "PIX")
@AllArgsConstructor
public class PixEntity extends PagamentoEntity {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuarioPix;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "banco_id")
    private BancoEntity banco;

    @OneToMany(mappedBy = "pagamento", cascade = CascadeType.ALL)
    private Set<GastoEntity> gastos;

    @OneToMany(mappedBy = "pagamento", cascade = CascadeType.ALL)
    private Set<GastoFixoEntity> gastosFixo;

    @Column(name = "chave_pix", nullable = false, unique = true)
    private String chavePix;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public PixEntity() {
        this.createdAt = LocalDateTime.now();
    }

    public PixEntity(UsuarioEntity usuarioPix, BancoEntity banco, String chavePix) {
        this();
        this.usuarioPix = usuarioPix;
        this.banco = banco;
        this.chavePix = chavePix;
    }
}