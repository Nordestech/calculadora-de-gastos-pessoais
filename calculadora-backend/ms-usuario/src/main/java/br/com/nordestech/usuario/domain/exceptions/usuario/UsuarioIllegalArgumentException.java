package br.com.nordestech.usuario.domain.exceptions.usuario;

public class UsuarioIllegalArgumentException extends RuntimeException {
    public UsuarioIllegalArgumentException(String message) {
        super(message);
    }
}
