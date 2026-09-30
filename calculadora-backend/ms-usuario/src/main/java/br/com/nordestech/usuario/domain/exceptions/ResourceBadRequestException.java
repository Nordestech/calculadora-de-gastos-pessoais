package br.com.nordestech.usuario.domain.exceptions;

public class ResourceBadRequestException extends RuntimeException {
    public ResourceBadRequestException(
            String resourceName,
            String fieldName,
            Object fieldValue
    ) {
        super(String.format("%s com campo inválido '%s': '%s'", resourceName, fieldName, fieldValue));
    }
}
