package br.com.nordestech.usuario.domain.service.usuario;

import br.com.nordestech.usuario.domain.model.Usuario;
import br.com.nordestech.usuario.domain.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastrarUsuarioUseService {

    private final UsuarioRepository repository;

    public Usuario execute(Usuario usuario) {
        return repository.salvar(usuario);
    }

}
