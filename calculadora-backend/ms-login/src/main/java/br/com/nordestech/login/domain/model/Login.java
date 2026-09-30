package br.com.nordestech.login.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Login {

    private String email;
    private String senha;

    public Login(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

}
