package br.com.nordestech.usuario.infra.persistence.type.tipoGastoFixo;

import br.com.nordestech.usuario.infra.persistence.gastoFixo.GastoFixoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataJpaTipoGastoFixoRepository extends JpaRepository<GastoFixoEntity, UUID> {
}
