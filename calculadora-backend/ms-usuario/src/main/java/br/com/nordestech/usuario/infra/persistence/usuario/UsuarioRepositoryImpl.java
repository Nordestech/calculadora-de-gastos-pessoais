package br.com.nordestech.usuario.infra.persistence.usuario;

import br.com.nordestech.usuario.domain.exceptions.usuario.UsuarioBadRequestException;
import br.com.nordestech.usuario.domain.exceptions.usuario.UsuarioNotFoundException;
import br.com.nordestech.usuario.domain.model.Usuario;
import br.com.nordestech.usuario.domain.repository.UsuarioRepository;
import br.com.nordestech.usuario.infra.persistence.usuario.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UsuarioRepositoryImpl implements UsuarioRepository {

    private final SpringDataJpaUsuarioRepository repository;
    private final UsuarioMapper mapper;

    @Override
    public Usuario salvar(Usuario usuario) {

        UsuarioEntity usuarioEntity = new UsuarioEntity(
                usuario.getEmail(),
                usuario.getSenha(),
                usuario.getNomeCompleto(),
                usuario.getCpf(),
                usuario.getDataNascimento()
        );

        return mapper.toUsuario(repository.save(usuarioEntity));

    }

    @Override
    public Usuario atualizar(Usuario usuario, UUID idUsuario) {

        Optional<UsuarioEntity> usuarioEntity = repository.findById(idUsuario);

        if (usuarioEntity.isPresent()) {

            UsuarioEntity usuarioToUpdate = usuarioEntity.get();

            if (usuario.getNomeCompleto() != null) {
                usuarioToUpdate.setNomeCompleto(usuario.getNomeCompleto());
            }
            if (usuario.getCpf() != null) {
                usuarioToUpdate.setCpf(usuario.getCpf());
            }
            if (usuario.getDataNascimento() != null) {
                usuarioToUpdate.setDataNascimento(usuario.getDataNascimento());
            }
            if (usuario.getEmail() != null) {
                usuarioToUpdate.setEmail(usuario.getEmail());
            }

            return mapper.toUsuario(repository.save(usuarioToUpdate));
        }

        throw new UsuarioBadRequestException("Nenhuma alteração realizada. Nenhum campo de atualização válido");

    }

    @Override
    public Usuario buscarPorEmail(String email) {
        Optional<UsuarioEntity> usuarioEntity = repository.findByEmailContainingIgnoreCase(email);

        if (usuarioEntity.isPresent()) {
            return mapper.toUsuario(usuarioEntity.get());
        }

        throw new UsuarioNotFoundException("Nenhum usuário encontrado com o email " + email);
    }

    @Override
    public Usuario buscarPorId(UUID idUsuario) {
        Optional<UsuarioEntity> usuarioEntity = repository.findById(idUsuario);

        if (usuarioEntity.isPresent()) {
            return mapper.toUsuario(usuarioEntity.get());
        }

        throw new UsuarioNotFoundException("Nenhum usuário encontrado com o id " + idUsuario);
    }

    @Override
    public void deletarUsuarioPorId(UUID idUsuario) {

        Optional<UsuarioEntity> usuarioEntity = repository.findById(idUsuario);

        if (usuarioEntity.isPresent()) {
            repository.deleteById(idUsuario);
        }

        throw new UsuarioNotFoundException("Nenhum usuário encontrado com o id " + idUsuario);

    }

    @Override
    public Page<Usuario> buscarTodosUsuarios(Pageable pageable) {

        return repository.findAll(pageable).map(mapper::toUsuario);

    }
}
