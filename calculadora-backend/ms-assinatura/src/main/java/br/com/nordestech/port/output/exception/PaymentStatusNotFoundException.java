package br.com.nordestech.port.output.exception;

public class PaymentStatusNotFoundException extends RuntimeException {

    public PaymentStatusNotFoundException(
            String resourceName,
            String message
    ) {
        super(String.format("Pagamento não encontrado na API %s: '%s'", resourceName, message));
    }

}
