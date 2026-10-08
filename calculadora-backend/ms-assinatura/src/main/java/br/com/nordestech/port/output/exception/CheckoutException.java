package br.com.nordestech.port.output.exception;

public class CheckoutException extends RuntimeException {

    public CheckoutException(
            String resourceName,
            String message
    ) {
        super(String.format("Erro durante o processamento da API %s: '%s'", resourceName, message));
    }

}
