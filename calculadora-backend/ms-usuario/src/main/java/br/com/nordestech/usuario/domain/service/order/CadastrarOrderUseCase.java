package br.com.nordestech.usuario.domain.service.order;

import br.com.nordestech.usuario.domain.model.Order;
import br.com.nordestech.usuario.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CadastrarOrderUseCase {

    private final OrderRepository repository;

    public Order execute(UUID usuarioId) {

        return repository.createOrder(usuarioId);

    }

}
