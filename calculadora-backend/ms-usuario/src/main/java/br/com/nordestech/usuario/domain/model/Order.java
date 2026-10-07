package br.com.nordestech.usuario.domain.model;

import br.com.nordestech.usuario.domain.model.enums.StatusPayment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Order {

    private UUID idOrder;
    private String nsu;
    private UUID usuarioId;
    private StatusPayment statusPayment;
    private LocalDate validFrom;
    private LocalDate validTo;

    protected Order() {
    }
}
