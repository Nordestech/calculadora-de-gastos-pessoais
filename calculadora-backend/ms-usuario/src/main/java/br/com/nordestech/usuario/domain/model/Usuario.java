package br.com.nordestech.usuario.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = "senha")
public class Usuario {

    @EqualsAndHashCode.Include
    private UUID id;
    private String email;
    private String senha;
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private UUID receitaId;
    private Set<UUID> despesasId;
    private Set<UUID> cartoesId;

}
