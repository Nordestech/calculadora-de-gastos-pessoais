package br.com.nordestech.usuario.domain.model;

import br.com.nordestech.usuario.domain.model.enums.PerfilEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Usuario {

    private UUID id;
    private String email;
    private String senha;
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private UUID receitaId;
    private Set<UUID> despesasId;
    private Set<UUID> cartoesId;
    private Set<PerfilEnum> perfis;

    public Usuario(String email, String senha, String nomeCompleto, LocalDate dataNascimento, Set<PerfilEnum> perfis) {
        this.email = email;
        this.senha = senha;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.perfis = perfis;
    }

    protected  Usuario() {
    }
}
