package br.com.nordestech.usuario.domain.service.usuario;

import br.com.nordestech.usuario.domain.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeletarUsuarioUseCase {

    private final UsuarioRepository repository;

    public void execute(UUID idUsuario) {

        repository.deletarUsuarioPorId(idUsuario);

    }

}
