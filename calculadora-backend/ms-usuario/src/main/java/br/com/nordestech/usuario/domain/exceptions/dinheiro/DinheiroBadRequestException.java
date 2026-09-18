package br.com.nordestech.usuario.domain.exceptions.dinheiro;

public class DinheiroBadRequestException extends RuntimeException {
    public DinheiroBadRequestException(String message) {
        super(message);
    }
}
