package br.com.nordestech.usuario.domain.service.order;

import br.com.nordestech.usuario.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeletarOrderUseCase {

    private final OrderRepository repository;

    public void execute(String orderNsu) {

        repository.deleteOrderByNsu(orderNsu);

    }

}
