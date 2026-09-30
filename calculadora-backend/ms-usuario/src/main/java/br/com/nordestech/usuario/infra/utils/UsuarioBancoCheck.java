package br.com.nordestech.usuario.infra.utils;

import br.com.nordestech.usuario.domain.exceptions.ResourceNotFoundException;
import br.com.nordestech.usuario.infra.persistence.banco.BancoEntity;
import br.com.nordestech.usuario.infra.persistence.banco.SpringDataJpaBancoRepository;
import br.com.nordestech.usuario.infra.persistence.usuario.SpringDataJpaUsuarioRepository;
import br.com.nordestech.usuario.infra.persistence.usuario.UsuarioEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UsuarioBancoCheck {

    private final SpringDataJpaBancoRepository bancoRepository;
    private final SpringDataJpaUsuarioRepository usuarioRepository;

    public UsuarioEntity checkUsuario(UUID usuarioId) {
        Optional<UsuarioEntity> usuarioEntity = usuarioRepository.findById(usuarioId);

        if (usuarioEntity.isEmpty()) {
            throw new ResourceNotFoundException("Usuario", "id", usuarioId);
        }
         return usuarioEntity.get();
    }

    public BancoEntity checkBanco(UUID bancoId) {
        Optional<BancoEntity> bancoEntity = bancoRepository.findById(bancoId);

        if (bancoEntity.isEmpty()) {
            throw new ResourceNotFoundException("Banco", "id", bancoId);
        }

        return bancoEntity.get();
    }

}
