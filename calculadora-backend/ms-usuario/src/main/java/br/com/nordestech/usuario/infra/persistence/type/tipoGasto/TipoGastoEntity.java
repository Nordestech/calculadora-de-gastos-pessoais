package br.com.nordestech.usuario.infra.persistence.type.tipoGasto;

import br.com.nordestech.usuario.infra.persistence.usuario.UsuarioEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "TIPO_GASTOS")
@AllArgsConstructor
public class TipoGastoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuario;

    @Column(name = "tipos")
    private Set<String> tipos;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public TipoGastoEntity() {
        this.updatedAt = LocalDateTime.now();
    }

    public TipoGastoEntity(UsuarioEntity usuario, Set<String> tipos) {
        this();
        this.usuario = usuario;
        this.tipos = tipos;
    }
}
