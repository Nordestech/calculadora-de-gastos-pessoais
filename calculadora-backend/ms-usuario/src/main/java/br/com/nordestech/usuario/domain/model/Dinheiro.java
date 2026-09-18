package br.com.nordestech.usuario.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Dinheiro {

    @EqualsAndHashCode.Include
    private UUID id;
    private BigDecimal valor;

}
