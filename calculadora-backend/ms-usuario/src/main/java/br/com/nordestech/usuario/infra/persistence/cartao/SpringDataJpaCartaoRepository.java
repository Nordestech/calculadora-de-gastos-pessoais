package br.com.nordestech.usuario.infra.persistence.cartao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataJpaCartaoRepository extends JpaRepository<CartaoEntity, UUID> {
}
