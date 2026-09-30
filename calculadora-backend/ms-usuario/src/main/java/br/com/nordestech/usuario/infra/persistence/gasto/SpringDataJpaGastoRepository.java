package br.com.nordestech.usuario.infra.persistence.gasto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataJpaGastoRepository extends JpaRepository<GastoEntity, UUID> {

    Page<GastoEntity> findAllByUsuarioGastos_Id(UUID usuarioGastosId, Pageable pageable);
}
