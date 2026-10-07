package br.com.nordestech.usuario.infra.persistence.usuario;

import br.com.nordestech.usuario.domain.model.enums.PerfilEnum;
import br.com.nordestech.usuario.infra.persistence.cartao.CartaoEntity;
import br.com.nordestech.usuario.infra.persistence.dinheiro.DinheiroEntity;
import br.com.nordestech.usuario.infra.persistence.gasto.GastoEntity;
import br.com.nordestech.usuario.infra.persistence.gastoFixo.GastoFixoEntity;
import br.com.nordestech.usuario.infra.persistence.order.OrderEntity;
import br.com.nordestech.usuario.infra.persistence.pix.PixEntity;
import br.com.nordestech.usuario.infra.persistence.type.tipoGasto.TipoGastoEntity;
import br.com.nordestech.usuario.infra.persistence.type.tipoGastoFixo.TipoGastoFixoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "USUARIOS")
@AllArgsConstructor
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "nome_completo")
    private String nomeCompleto;

    @Column(name = "cpf", unique = true)
    private String cpf;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    @Column(name = "perfis")
    private Set<PerfilEnum> perfis;

    @OneToMany(mappedBy = "usuarioPix", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<PixEntity> pix;

    @OneToMany(mappedBy = "usuarioCartoes", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CartaoEntity> cartoes;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private DinheiroEntity dinheiro;

    @OneToMany(mappedBy = "usuarioGastos", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<GastoEntity> gastos;

    @OneToMany(mappedBy = "usuarioGastosFixos", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<GastoFixoEntity> gastosFixos;

    @OneToMany(mappedBy = "usuarioOrders", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<OrderEntity> orders;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private TipoGastoEntity tipoGasto;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private TipoGastoFixoEntity tipoGastoFixo;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "update_at")
    private LocalDateTime updatedAt;

    public UsuarioEntity() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public UsuarioEntity(String email, String senha, String nomeCompleto, String cpf, LocalDate dataNascimento) {
        this();

        Set<PerfilEnum> perfis = new HashSet<>();
        perfis.add(PerfilEnum.FREE_ACCOUNT);

        this.email = email;
        this.senha = senha;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.perfis = perfis;
        this.pix = new HashSet<PixEntity>();
        this.cartoes = new HashSet<CartaoEntity>();
        this.dinheiro = new DinheiroEntity(BigDecimal.valueOf(0));
        this.gastos = new HashSet<GastoEntity>();
        this.gastosFixos = new HashSet<GastoFixoEntity>();
        this.tipoGasto = new TipoGastoEntity();
        this.tipoGastoFixo = new TipoGastoFixoEntity();
    }

}
