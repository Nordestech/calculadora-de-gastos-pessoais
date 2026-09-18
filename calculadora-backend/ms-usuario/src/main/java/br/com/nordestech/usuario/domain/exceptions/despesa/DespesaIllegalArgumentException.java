package br.com.nordestech.usuario.domain.exceptions.despesa;

public class DespesaIllegalArgumentException extends RuntimeException {
    public DespesaIllegalArgumentException(String message) {
        super(message);
    }
}
