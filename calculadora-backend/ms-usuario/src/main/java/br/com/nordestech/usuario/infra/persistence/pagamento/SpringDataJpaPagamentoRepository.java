package br.com.nordestech.usuario.infra.persistence.pagamento;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataJpaPagamentoRepository extends JpaRepository<PagamentoEntity, UUID> {
}
