package br.com.nordestech.usuario.domain.exceptions.cartao;

public class CartaoBadRequestException extends RuntimeException {
    public CartaoBadRequestException(String message) {
        super(message);
    }
}
