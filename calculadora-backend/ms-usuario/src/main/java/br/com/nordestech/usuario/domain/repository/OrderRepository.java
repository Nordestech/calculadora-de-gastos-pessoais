package br.com.nordestech.usuario.domain.repository;

import br.com.nordestech.usuario.domain.model.Order;
import br.com.nordestech.usuario.domain.model.enums.StatusPayment;

import java.util.UUID;

public interface OrderRepository {

    Order createOrder(UUID usuarioId);
    void updateOrder(String nsu, StatusPayment statusPayment);
    Order findOrderByNsu(String nsu);
    Boolean existsOrderByNsu(String nsu);
    void deleteOrderByNsu(String nsu);

}
