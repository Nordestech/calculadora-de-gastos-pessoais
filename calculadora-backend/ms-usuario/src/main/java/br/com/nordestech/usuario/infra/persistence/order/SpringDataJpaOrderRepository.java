package br.com.nordestech.usuario.infra.persistence.order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SpringDataJpaOrderRepository extends JpaRepository<OrderEntity, UUID> {
    Optional<OrderEntity> findOrderEntityByNsu(String nsu);

    Boolean existsOrderEntityByNsu(String nsu);
}
