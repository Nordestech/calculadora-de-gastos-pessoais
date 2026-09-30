package br.com.nordestech.usuario.domain.exceptions.enums;

import lombok.Getter;

@Getter
public enum ErrorCode {

    SALDO_INSUFICIENTE("ERROR_001", "Saldo insuficiente"),
    VALOR_INVALIDO("ERROR_002", "Valor inválido");

    private final String code;
    private final String defaultMessage;

    ErrorCode(String code, String defaultMessage) {
        this.code = code;
        this.defaultMessage = defaultMessage;
    }

}