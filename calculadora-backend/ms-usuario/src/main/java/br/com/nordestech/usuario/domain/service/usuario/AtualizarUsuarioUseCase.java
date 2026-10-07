package br.com.nordestech.usuario.domain.service.usuario;

import br.com.nordestech.usuario.domain.model.Usuario;
import br.com.nordestech.usuario.domain.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AtualizarUsuarioUseCase {

    private final UsuarioRepository repository;

    public Usuario atualizarDados(Usuario usuario, UUID usuarioId) {

        return repository.atualizar(usuario, usuarioId);

    }

    public Usuario atualizarAssinatura(String orderNsu) {

        return repository.atualizarAssinatura(orderNsu);

    }

}
