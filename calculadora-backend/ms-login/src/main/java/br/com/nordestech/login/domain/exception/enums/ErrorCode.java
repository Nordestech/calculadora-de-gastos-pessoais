package br.com.nordestech.login.domain.exception.enums;

import lombok.Getter;

@Getter
public enum ErrorCode {

    LOGIN_INCORRECT("AUTH_001", "E-mail e/ou senha incorretos"),
    ROLE_UNAUTHORIZED("AUTH_002", "Role não autorizada"),
    EXPIRED_TOKEN("AUTH_003", "Token expirado");

    private final String code;
    private final String defaultMessage;

    ErrorCode(String code, String defaultMessage) {
        this.code = code;
        this.defaultMessage = defaultMessage;
    }

}