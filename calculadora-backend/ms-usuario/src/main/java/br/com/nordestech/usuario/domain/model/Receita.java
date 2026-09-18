package br.com.nordestech.usuario.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Receita {

    @EqualsAndHashCode.Include
    private UUID uuid;
    private UUID dinheiroId;
    private Set<UUID> bancoId;

}
