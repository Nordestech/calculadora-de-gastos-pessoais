package br.com.nordestech.usuario.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pix {

    @EqualsAndHashCode.Include
    private UUID id;
    private UUID bancoId;
    private String chavePix;

}
