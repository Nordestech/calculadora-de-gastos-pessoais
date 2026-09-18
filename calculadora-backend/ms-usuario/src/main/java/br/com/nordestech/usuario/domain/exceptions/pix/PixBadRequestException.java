package br.com.nordestech.usuario.domain.exceptions.pix;

public class PixBadRequestException extends RuntimeException {
    public PixBadRequestException(String message) {
        super(message);
    }
}
