package br.com.nordestech.usuario.domain.exceptions.dinheiro;

public class DinheiroNotFoundException extends RuntimeException {
    public DinheiroNotFoundException(String message) {
        super(message);
    }
}
