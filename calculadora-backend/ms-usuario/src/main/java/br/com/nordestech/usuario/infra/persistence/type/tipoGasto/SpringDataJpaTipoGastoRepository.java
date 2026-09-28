package br.com.nordestech.usuario.infra.persistence.type.tipoGasto;

import br.com.nordestech.usuario.infra.persistence.gastoFixo.GastoFixoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataJpaTipoGastoRepository extends JpaRepository<GastoFixoEntity, UUID> {

}
