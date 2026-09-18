package br.com.nordestech.usuario.domain.exceptions.banco;

public class BancoIllegalArgumentException extends RuntimeException {
    public BancoIllegalArgumentException(String message) {
        super(message);
    }
}
