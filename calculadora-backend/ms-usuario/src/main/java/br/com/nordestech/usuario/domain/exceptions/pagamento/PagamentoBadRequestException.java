package br.com.nordestech.usuario.domain.exceptions.pagamento;

public class PagamentoBadRequestException extends RuntimeException {
    public PagamentoBadRequestException(String message) {
        super(message);
    }
}
