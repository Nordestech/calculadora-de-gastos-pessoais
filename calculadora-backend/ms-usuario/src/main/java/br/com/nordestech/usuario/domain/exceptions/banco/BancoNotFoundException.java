package br.com.nordestech.usuario.domain.exceptions.banco;

public class BancoNotFoundException extends RuntimeException {
    public BancoNotFoundException(String message) {
        super(message);
    }
}
