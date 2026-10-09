package br.com.nordestech.usuario.port.output.dto;

import lombok.Builder;

@Builder
public record EmailHtmlRequest(

        String to,
        String nomeCompleto,
        String subject

) {
}