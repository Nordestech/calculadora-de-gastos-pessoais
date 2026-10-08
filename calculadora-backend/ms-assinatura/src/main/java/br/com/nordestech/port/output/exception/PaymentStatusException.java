package br.com.nordestech.port.output.exception;

public class PaymentStatusException extends RuntimeException {

    public PaymentStatusException(
            String resourceName,
            String message
    ) {
        super(String.format("Erro durante o processamento da API %s: '%s'", resourceName, message));
    }

}
