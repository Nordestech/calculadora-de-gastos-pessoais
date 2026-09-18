package br.com.nordestech.usuario.domain.exceptions.pagamento;

public class PagamentoNotFoundException extends RuntimeException {
    public PagamentoNotFoundException(String message) {
        super(message);
    }
}
