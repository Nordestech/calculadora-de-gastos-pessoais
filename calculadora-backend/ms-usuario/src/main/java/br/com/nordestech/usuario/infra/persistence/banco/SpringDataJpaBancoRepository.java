package br.com.nordestech.usuario.infra.persistence.banco;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataJpaBancoRepository extends JpaRepository<BancoEntity, UUID> {
}
