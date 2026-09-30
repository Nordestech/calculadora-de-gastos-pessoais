package br.com.nordestech.usuario.infra.persistence.cartao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SpringDataJpaCartaoRepository extends JpaRepository<CartaoEntity, UUID> {
    List<CartaoEntity> findAllByUsuarioCartoes_Id(UUID usuarioCartoesId);
}
