package br.com.nordestech.usuario.infra.persistence.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataJpaUsuarioRepository extends JpaRepository<UsuarioEntity, UUID> {

    boolean existsUsuarioEntityByEmailContainingIgnoreCase(String email);
}
