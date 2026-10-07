package br.com.nordestech.usuario.infra.persistence.order;

import br.com.nordestech.usuario.domain.exceptions.ResourceNotFoundException;
import br.com.nordestech.usuario.domain.model.Order;
import br.com.nordestech.usuario.domain.model.enums.StatusPayment;
import br.com.nordestech.usuario.domain.repository.OrderRepository;
import br.com.nordestech.usuario.infra.persistence.order.mapper.OrderMapper;
import br.com.nordestech.usuario.infra.persistence.usuario.SpringDataJpaUsuarioRepository;
import br.com.nordestech.usuario.infra.persistence.usuario.UsuarioEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    private final SpringDataJpaOrderRepository repository;
    private final SpringDataJpaUsuarioRepository usuarioRepository;
    private final OrderMapper mapper;

    @Override
    public Order createOrder(UUID usuarioId) {

        String orderId = "ORDER-" + UUID.randomUUID();

        Optional<UsuarioEntity> usuarioEntity = usuarioRepository.findById(usuarioId);

        if (usuarioEntity.isEmpty()) {
            throw new ResourceNotFoundException("Usuario", "id", usuarioId);
        }

        OrderEntity orderEntity = new OrderEntity(
                orderId,
                StatusPayment.PENDING,
                usuarioEntity.get()
        );

        return mapper.toOrder(repository.save(orderEntity));

    }

    @Override
    public void updateOrder(String nsu, StatusPayment statusPayment) {
        Optional<OrderEntity> orderEntity = repository.findOrderEntityByNsu(nsu);

        if (orderEntity.isEmpty()) {
            throw new ResourceNotFoundException("Order", "nsu", nsu);
        }

        OrderEntity orderToUpdate = orderEntity.get();

        if (statusPayment == StatusPayment.APPROVED) {
            orderToUpdate.setStatusPayment(statusPayment);
            orderToUpdate.setValidFrom(LocalDate.now());
            orderToUpdate.setValidTo(LocalDate.now().plusDays(30));

            repository.save(orderToUpdate);
        } else {
            orderToUpdate.setStatusPayment(statusPayment);
            repository.save(orderToUpdate);
        }
    }

    @Override
    public Order findOrderByNsu(String nsu) {
        Optional<OrderEntity> orderEntity = repository.findOrderEntityByNsu(nsu);

        if (orderEntity.isEmpty()) {
            throw new ResourceNotFoundException("Order", "nsu", nsu);
        }

        return mapper.toOrder(orderEntity.get());
    }

    @Override
    public Boolean existsOrderByNsu(String nsu) {
        return repository.existsOrderEntityByNsu(nsu);
    }

    @Override
    public void deleteOrderByNsu(String nsu) {
        repository.findOrderEntityByNsu(nsu).ifPresentOrElse(repository::delete, () -> {throw new ResourceNotFoundException("Order", "nsu", nsu);});
    }
}
