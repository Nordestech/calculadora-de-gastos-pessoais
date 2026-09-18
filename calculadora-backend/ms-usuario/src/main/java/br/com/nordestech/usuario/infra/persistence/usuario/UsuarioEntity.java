package br.com.nordestech.usuario.infra.persistence.usuario;

import br.com.nordestech.usuario.infra.persistence.cartao.CartaoEntity;
import br.com.nordestech.usuario.infra.persistence.despesa.DespesaEntity;
import br.com.nordestech.usuario.infra.persistence.receita.ReceitaEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @OneToOne(mappedBy = "usuarioReceita", cascade = CascadeType.ALL)
    private ReceitaEntity receitaUsuario;

    @OneToMany(mappedBy = "usuarioDespesas", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<DespesaEntity> despesasUsuario;

    @OneToMany(mappedBy = "usuarioCartoes", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<CartaoEntity> cartoesUsuario;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "update_at")
    private LocalDateTime updatedAt;

    public UsuarioEntity() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public UsuarioEntity(String email, String senha, String nomeCompleto, LocalDate dataNascimento) {
        this();
        this.email = email;
        this.senha = senha;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
    }

    public UsuarioEntity(String email, String senha, String nomeCompleto, LocalDate dataNascimento, ReceitaEntity receitaUsuario, Set<DespesaEntity> despesasUsuario, Set<CartaoEntity> cartoesUsuario) {
        this();
        this.email = email;
        this.senha = senha;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.receitaUsuario = receitaUsuario;
        this.despesasUsuario = despesasUsuario;
        this.cartoesUsuario = cartoesUsuario;
    }

}
