package br.com.nordestech.usuario.infra.persistence.dinheiro;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SpringDataJpaDinheiroRepository extends JpaRepository<DinheiroEntity, UUID> {
    Optional<DinheiroEntity> findByUsuario_Id(UUID usuarioId);
}
