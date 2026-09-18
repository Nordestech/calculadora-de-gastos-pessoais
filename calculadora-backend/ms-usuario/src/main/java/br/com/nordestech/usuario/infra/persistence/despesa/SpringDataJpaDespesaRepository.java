package br.com.nordestech.usuario.infra.persistence.despesa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataJpaDespesaRepository extends JpaRepository<DespesaEntity, UUID> {
}
