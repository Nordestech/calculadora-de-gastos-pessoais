package br.com.nordestech.usuario.infra.persistence.receita;

import br.com.nordestech.usuario.infra.persistence.banco.BancoEntity;
import br.com.nordestech.usuario.infra.persistence.dinheiro.DinheiroEntity;
import br.com.nordestech.usuario.infra.persistence.usuario.UsuarioEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "RECEITAS")
public class ReceitaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(mappedBy = "receitaDinheiro", cascade = CascadeType.ALL)
    private DinheiroEntity dinheiroReceita;

    @OneToMany(mappedBy = "receitaBancos", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<BancoEntity> bancosReceita;

    @OneToOne(mappedBy = "receitaReceita", cascade = CascadeType.ALL)
    private UsuarioEntity usuarioReceita;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public ReceitaEntity() {
        this.updatedAt = LocalDateTime.now();
    }

    public ReceitaEntity(DinheiroEntity dinheiroReceita, Set<BancoEntity> bancosReceita) {
        this();
        this.dinheiroReceita = dinheiroReceita;
        this.bancosReceita = bancosReceita;
    }
}