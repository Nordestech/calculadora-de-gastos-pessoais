package br.com.nordestech.usuario.infra.persistence.order.mapper;

import br.com.nordestech.usuario.domain.model.Order;
import br.com.nordestech.usuario.infra.persistence.order.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public Order toOrder(OrderEntity entity) {
        return Order.builder()
                .idOrder(entity.getId())
                .nsu(entity.getNsu())
                .usuarioId(entity.getUsuarioOrders().getId())
                .statusPayment(entity.getStatusPayment())
                .validFrom(entity.getValidFrom())
                .validTo(entity.getValidTo())
                .build();
    }

}
