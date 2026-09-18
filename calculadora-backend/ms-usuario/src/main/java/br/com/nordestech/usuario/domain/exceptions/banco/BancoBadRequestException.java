package br.com.nordestech.usuario.domain.exceptions.banco;

public class BancoBadRequestException extends RuntimeException {
    public BancoBadRequestException(String message) {
        super(message);
    }
}
