package br.com.nordestech.usuario.domain.model;

import lombok.*;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Receita {

    private UUID id;
    private UUID usuarioId;
    private UUID dinheiroId;
    private Set<UUID> bancoId;

}
