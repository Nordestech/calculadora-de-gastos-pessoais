package br.com.nordestech.usuario.domain.service.usuario;

import br.com.nordestech.usuario.domain.model.Usuario;
import br.com.nordestech.usuario.domain.model.enums.PerfilEnum;
import br.com.nordestech.usuario.domain.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CadastrarUsuarioUseCase {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;

    public Usuario execute(Usuario usuario) {

        String senhaHash = passwordEncoder.encode(usuario.getSenha());

        usuario.setSenha(senhaHash);

        Set<PerfilEnum> perfis = new HashSet<>();

        perfis.add(PerfilEnum.FREE_ACCOUNT);

        usuario.setPerfis(perfis);

        return repository.salvar(usuario);

    }

}
