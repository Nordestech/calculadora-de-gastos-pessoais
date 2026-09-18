package br.com.nordestech.usuario.domain.exceptions.despesa;

public class DespesaBadRequestException extends RuntimeException {
    public DespesaBadRequestException(String message) {
        super(message);
    }
}
