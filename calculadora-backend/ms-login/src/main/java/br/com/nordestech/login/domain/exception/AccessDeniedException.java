package br.com.nordestech.login.domain.exception;

import br.com.nordestech.login.domain.exception.enums.ErrorCode;

public class AccessDeniedException extends RuntimeException {
    private final ErrorCode errorCode;

    public AccessDeniedException(ErrorCode errorCode) {
        super(errorCode.getDefaultMessage());
        this.errorCode = errorCode;
    }

    public AccessDeniedException(ErrorCode errorCode, String customMessage) {
        super(customMessage);
        this.errorCode = errorCode;
    }
}
