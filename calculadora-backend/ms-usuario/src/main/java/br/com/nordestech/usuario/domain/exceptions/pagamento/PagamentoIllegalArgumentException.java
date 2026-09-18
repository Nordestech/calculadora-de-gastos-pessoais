package br.com.nordestech.usuario.domain.exceptions.pagamento;

public class PagamentoIllegalArgumentException extends RuntimeException {
    public PagamentoIllegalArgumentException(String message) {
        super(message);
    }
}
