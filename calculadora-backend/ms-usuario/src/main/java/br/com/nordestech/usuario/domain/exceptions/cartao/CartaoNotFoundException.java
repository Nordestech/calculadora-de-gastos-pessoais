package br.com.nordestech.usuario.domain.exceptions.cartao;

public class CartaoNotFoundException extends RuntimeException {
    public CartaoNotFoundException(String message) {
        super(message);
    }
}
