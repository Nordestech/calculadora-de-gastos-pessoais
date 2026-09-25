package br.com.nordestech.usuario.infra.persistence.usuario;

import br.com.nordestech.usuario.domain.exceptions.usuario.UsuarioBadRequestException;
import br.com.nordestech.usuario.domain.model.Usuario;
import br.com.nordestech.usuario.domain.model.enums.PerfilEnum;
import br.com.nordestech.usuario.domain.repository.UsuarioRepository;
import br.com.nordestech.usuario.infra.persistence.banco.BancoEntity;
import br.com.nordestech.usuario.infra.persistence.cartao.CartaoEntity;
import br.com.nordestech.usuario.infra.persistence.despesa.DespesaEntity;
import br.com.nordestech.usuario.infra.persistence.dinheiro.DinheiroEntity;
import br.com.nordestech.usuario.infra.persistence.dinheiro.SpringDataJpaDinheiroRepository;
import br.com.nordestech.usuario.infra.persistence.receita.ReceitaEntity;
import br.com.nordestech.usuario.infra.persistence.receita.SpringDataJpaReceitaRepository;
import br.com.nordestech.usuario.infra.persistence.usuario.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UsuarioRepositoryImpl implements UsuarioRepository {

    private final SpringDataJpaUsuarioRepository repositoryUsuario;
    private final SpringDataJpaReceitaRepository repositoryReceita;
    private final SpringDataJpaDinheiroRepository repositoryDinheiro;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioMapper mapper;

    @Override
    public Usuario salvar(Usuario usuario) {
        if (repositoryUsuario.existsUsuarioEntityByEmailContainingIgnoreCase(usuario.getEmail())) {
            throw new UsuarioBadRequestException("E-mail já cadastrado: " + usuario.getEmail());
        }

        Set<BancoEntity> bancos = new HashSet<>();
        Set<DespesaEntity> despesas = new HashSet<>();
        Set<CartaoEntity> cartoes = new HashSet<>();

        DinheiroEntity dinheiro = new DinheiroEntity(
                BigDecimal.valueOf(0)
        );

        repositoryDinheiro.save(dinheiro);

        ReceitaEntity receita = new ReceitaEntity(
                dinheiro,
                bancos
        );

        repositoryReceita.save(receita);

        Set<PerfilEnum> perfis =  new HashSet<>();
        perfis.add(PerfilEnum.FREE_ACCOUNT);

        String senhaHash = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaHash);

        UsuarioEntity usuarioEntityToSave =  new UsuarioEntity(
                usuario.getEmail(),
                usuario.getSenha(),
                usuario.getNomeCompleto(),
                usuario.getDataNascimento(),
                receita,
                despesas,
                cartoes,
                perfis
        );

        return mapper.toUsuario(repositoryUsuario.save(usuarioEntityToSave));
    }

    @Override
    public Usuario atualizar(Usuario usuario, UUID idUsuario) {
        return null;
    }

    @Override
    public Usuario buscarPorEmail(String email) {
        return null;
    }

    @Override
    public Usuario buscarPorId(UUID id) {
        return null;
    }

    @Override
    public void deletarUsuarioPorId(UUID id) {

    }

    @Override
    public Page<Usuario> buscarTodosUsuarios(Pageable pageable) {
        return null;
    }
}
