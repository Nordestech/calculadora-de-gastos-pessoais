package br.com.nordestech.usuario.infra.persistence.type.tipoGastoFixo;

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
@Table(name = "TIPO_GASTOS_FIXOS")
@AllArgsConstructor
public class TipoGastoFixoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "tipos")
    private Set<String> tipos;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public TipoGastoFixoEntity() {
        this.updatedAt = LocalDateTime.now();
    }

    public TipoGastoFixoEntity(Set<String> tipos) {
        this();
        this.tipos = tipos;
    }
}
