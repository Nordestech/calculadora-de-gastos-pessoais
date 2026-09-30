package br.com.nordestech.usuario.infra.persistence.type.tipoGastoFixo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SpringDataJpaTipoGastoFixoRepository extends JpaRepository<TipoGastoFixoEntity, UUID> {

    Optional<TipoGastoFixoEntity> findByUsuario_Id(UUID usuarioId);

}
