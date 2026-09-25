package br.com.nordestech.usuario.domain.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Dinheiro {

    private UUID id;
    private UUID usuarioId;
    private BigDecimal valor;

}
