package br.com.nordestech.login.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = "senha")
public class Login {

    @EqualsAndHashCode.Include
    private String id;
    private String email;
    private String senha;

    public Login(String id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
    }

    public Login(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    protected Login() {
    }

}
