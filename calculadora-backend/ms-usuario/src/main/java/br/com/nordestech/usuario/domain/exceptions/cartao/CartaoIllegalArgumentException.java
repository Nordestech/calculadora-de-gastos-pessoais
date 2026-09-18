package br.com.nordestech.usuario.domain.exceptions.cartao;

public class CartaoIllegalArgumentException extends RuntimeException {
    public CartaoIllegalArgumentException(String message) {
        super(message);
    }
}
