package br.com.nordestech.port.output.exception;

public class CheckoutException extends RuntimeException {

    public CheckoutException(
            String resourceName,
            String message
    ) {
        super(String.format("%s durante o checkout: '%s'", resourceName, message));
    }

}
