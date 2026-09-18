package br.com.nordestech.usuario.infra.persistence.receita;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataJpaReceitaRepository extends JpaRepository<ReceitaEntity, UUID> {
}
