package br.com.nordestech.usuario.domain.service.usuario;

import br.com.nordestech.usuario.domain.model.Usuario;
import br.com.nordestech.usuario.domain.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BuscarUsuarioUseCase {

    private final UsuarioRepository repository;

    public Usuario buscarUsuarioPorId(UUID idUsuario) {
        return repository.buscarPorId(idUsuario);
    }

    public Usuario buscarUsuarioPorEmail(String email) {
        return repository.buscarPorEmail(email);
    }
    
    public Page<Usuario> buscarTodosUsuarios(Pageable pageable) {
        return repository.buscarTodosUsuarios(pageable);
    }

}
