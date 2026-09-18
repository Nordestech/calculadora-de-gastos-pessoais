package br.com.nordestech.usuario.infra.persistence.pix;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataJpaPixRepository extends JpaRepository<PixEntity, UUID> {
}
