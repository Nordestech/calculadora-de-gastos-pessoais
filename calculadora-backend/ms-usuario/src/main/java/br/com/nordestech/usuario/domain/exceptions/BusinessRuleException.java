package br.com.nordestech.usuario.domain.exceptions;

import br.com.nordestech.usuario.domain.exceptions.enums.ErrorCode;
import lombok.Getter;

@Getter
public class BusinessRuleException extends RuntimeException {

    private final ErrorCode errorCode;

    public BusinessRuleException(ErrorCode errorCode) {
        super(errorCode.getDefaultMessage());
        this.errorCode = errorCode;
    }

    public BusinessRuleException(ErrorCode errorCode, String customMessage) {
        super(customMessage);
        this.errorCode = errorCode;
    }

}