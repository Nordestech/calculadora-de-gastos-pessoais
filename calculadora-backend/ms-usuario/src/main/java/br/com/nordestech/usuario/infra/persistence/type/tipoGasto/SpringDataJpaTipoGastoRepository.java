package br.com.nordestech.usuario.infra.persistence.type.tipoGasto;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SpringDataJpaTipoGastoRepository extends JpaRepository<TipoGastoEntity, UUID> {
    UUID id(UUID id);

    Optional<TipoGastoEntity> findByUsuario_Id(UUID usuarioId);
}
