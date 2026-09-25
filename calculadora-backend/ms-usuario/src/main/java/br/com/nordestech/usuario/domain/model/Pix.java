package br.com.nordestech.usuario.domain.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Pix {

    private UUID id;
    private UUID bancoId;
    private String chavePix;

}
