package br.com.nordestech.login.domain.exception;

public class LoginUnauthorizedException extends RuntimeException {
    public LoginUnauthorizedException(String message) {
        super(message);
    }
}
