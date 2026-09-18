package br.com.nordestech.usuario.domain.exceptions.despesa;

public class DespesaNotFoundException extends RuntimeException {
    public DespesaNotFoundException(String message) {
        super(message);
    }
}
