package br.com.nordestech.usuario.domain.exceptions;

public class ResourceAlreadyExistsException extends RuntimeException {
    public ResourceAlreadyExistsException(
            String resourceName,
            String fieldName,
            Object fieldValue
    ) {
        super(String.format("%s já existe com o %s: '%s'", resourceName, fieldName, fieldValue));
    }
}
