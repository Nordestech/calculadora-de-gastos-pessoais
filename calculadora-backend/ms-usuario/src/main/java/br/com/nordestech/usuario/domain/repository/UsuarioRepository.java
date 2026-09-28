package br.com.nordestech.usuario.domain.repository;

import br.com.nordestech.usuario.domain.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface UsuarioRepository {

    Usuario salvar(Usuario usuario);

    Usuario atualizar(Usuario usuario, UUID idUsuario);

    Usuario buscarPorEmail(String email);

    Usuario buscarPorId(UUID idUsuario);

    void deletarUsuarioPorId(UUID idUsuario);

    Page<Usuario> buscarTodosUsuarios(Pageable pageable);

}
