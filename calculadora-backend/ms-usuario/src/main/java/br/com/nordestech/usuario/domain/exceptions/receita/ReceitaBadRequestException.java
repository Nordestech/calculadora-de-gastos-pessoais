package br.com.nordestech.usuario.domain.exceptions.receita;

public class ReceitaBadRequestException extends RuntimeException {
    public ReceitaBadRequestException(String message) {
        super(message);
    }
}
