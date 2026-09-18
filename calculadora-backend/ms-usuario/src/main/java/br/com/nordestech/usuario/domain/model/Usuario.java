package br.com.nordestech.usuario.domain.model;

import lombok.*;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = "senha")
@AllArgsConstructor
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

    public Usuario(String email, String senha, String nomeCompleto, LocalDate dataNascimento) {
        this.email = email;
        this.senha = senha;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
    }



    protected  Usuario() {
    }
}
