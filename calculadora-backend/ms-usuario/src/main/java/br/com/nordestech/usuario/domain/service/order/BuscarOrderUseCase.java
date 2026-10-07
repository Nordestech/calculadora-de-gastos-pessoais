package br.com.nordestech.usuario.domain.service.order;

import br.com.nordestech.usuario.domain.model.Order;
import br.com.nordestech.usuario.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuscarOrderUseCase {

    private final OrderRepository repository;

    public Order buscarOrderPorNsu(String orderNsu) {

        return repository.findOrderByNsu(orderNsu);

    }

}
