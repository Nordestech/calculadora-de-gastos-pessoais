package br.com.nordestech.usuario.domain.exceptions.pix;

public class PixNotFoundException extends RuntimeException {
    public PixNotFoundException(String message) {
        super(message);
    }
}
