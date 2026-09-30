package br.com.nordestech.usuario.domain.model;

import br.com.nordestech.usuario.domain.model.enums.PerfilEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Usuario {

    private UUID idUsuario;
    private String email;
    private String senha;
    private String nomeCompleto;
    private String cpf;
    private LocalDate dataNascimento;
    private Set<PerfilEnum> perfis;

    public Usuario(String email, String senha, String nomeCompleto, String cpf, LocalDate dataNascimento) {
        this.email = email;
        this.senha = senha;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.perfis = new HashSet<PerfilEnum>();
    }

    public Usuario(String nomeCompleto, String email) {
        this.nomeCompleto = nomeCompleto;
        this.email = email;
    }

    protected  Usuario() {
    }
}
