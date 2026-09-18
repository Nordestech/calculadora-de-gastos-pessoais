package br.com.nordestech.usuario.domain.exceptions.receita;

public class ReceitaNotFoundException extends RuntimeException {
    public ReceitaNotFoundException(String message) {
        super(message);
    }
}
