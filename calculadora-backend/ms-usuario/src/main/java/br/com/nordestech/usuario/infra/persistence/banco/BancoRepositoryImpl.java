package br.com.nordestech.usuario.infra.persistence.banco;

import br.com.nordestech.usuario.domain.exceptions.ResourceNotFoundException;
import br.com.nordestech.usuario.domain.model.Banco;
import br.com.nordestech.usuario.domain.repository.BancoRepository;
import br.com.nordestech.usuario.infra.persistence.banco.mapper.BancoMapper;
import br.com.nordestech.usuario.infra.persistence.usuario.SpringDataJpaUsuarioRepository;
import br.com.nordestech.usuario.infra.persistence.usuario.UsuarioEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BancoRepositoryImpl implements BancoRepository {

    private final SpringDataJpaBancoRepository repository;
    private final SpringDataJpaUsuarioRepository usuarioRepository;
    private final BancoMapper mapper;

    @Override
    public Banco salvar(Banco banco) {
        Optional<UsuarioEntity> usuarioEntity = usuarioRepository.findById(banco.getUsuarioId());

        if (usuarioEntity.isEmpty()) {
            throw new ResourceNotFoundException("Usuario", "id", banco.getUsuarioId());
        }

        BancoEntity bancoEntity = new BancoEntity(
                usuarioEntity.get(),
                banco.getNomeBanco(),
                banco.getSaldo()
        );

        return mapper.toBanco(repository.save(bancoEntity));
    }

    @Override
    public Banco atualizarSaldo(BigDecimal saldo, UUID idBanco) {
        Optional<BancoEntity> bancoEntity = repository.findById(idBanco);

        if (bancoEntity.isEmpty()) {
            throw new ResourceNotFoundException("Banco", "id", idBanco);
        }

        BancoEntity banco = bancoEntity.get();

        banco.setSaldo(saldo);

        return mapper.toBanco(repository.save(banco));
    }

    @Override
    public Set<Banco> buscarBancosPorUsuarioId(UUID id) {
        return repository.findAllByUsuarioBanco_Id(id).stream().map(mapper::toBanco).collect(Collectors.toSet());
    }

    @Override
    public void deletarBancoPorId(UUID idBanco) {
        Optional<BancoEntity> bancoEntity = repository.findById(idBanco);

        if (bancoEntity.isEmpty()) {
            throw new ResourceNotFoundException("Banco", "id", idBanco);
        }

        repository.delete(bancoEntity.get());
    }

    @Override
    public Banco buscarBancoPorId(UUID idBanco) {
        Optional<BancoEntity> bancoEntity = repository.findById(idBanco);

        if (bancoEntity.isEmpty()) {
            throw new ResourceNotFoundException("Banco", "id", idBanco);
        }

        return mapper.toBanco(repository.save(bancoEntity.get()));
    }
}
