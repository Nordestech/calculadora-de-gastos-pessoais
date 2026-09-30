package br.com.nordestech.usuario.infra.persistence.gastoFixo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SpringDataJpaGastoFixoRepository extends JpaRepository<GastoFixoEntity, UUID> {
    List<GastoFixoEntity> findAllByUsuarioGastosFixos_Id(UUID usuarioGastosFixosId);
}
