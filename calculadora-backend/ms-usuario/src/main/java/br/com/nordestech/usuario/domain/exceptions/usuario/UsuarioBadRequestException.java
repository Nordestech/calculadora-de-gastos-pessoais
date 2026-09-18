package br.com.nordestech.usuario.domain.exceptions.usuario;

public class UsuarioBadRequestException extends RuntimeException {
    public UsuarioBadRequestException(String message) {
        super(message);
    }
}
