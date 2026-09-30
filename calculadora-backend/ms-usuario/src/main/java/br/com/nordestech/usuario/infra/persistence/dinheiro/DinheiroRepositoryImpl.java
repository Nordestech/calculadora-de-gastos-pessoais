package br.com.nordestech.usuario.infra.persistence.dinheiro;

import br.com.nordestech.usuario.domain.exceptions.ResourceNotFoundException;
import br.com.nordestech.usuario.domain.model.Dinheiro;
import br.com.nordestech.usuario.domain.repository.DinheiroRepository;
import br.com.nordestech.usuario.infra.persistence.dinheiro.mapper.DinheiroMapper;
import br.com.nordestech.usuario.infra.persistence.usuario.UsuarioEntity;
import br.com.nordestech.usuario.infra.utils.UsuarioBancoCheck;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DinheiroRepositoryImpl implements DinheiroRepository {

    private final SpringDataJpaDinheiroRepository repository;
    private final DinheiroMapper mapper;
    private final UsuarioBancoCheck usuarioBancoCheck;

    @Override
    public Dinheiro salvar(Dinheiro dinheiro) {
        UsuarioEntity usuarioEntity = usuarioBancoCheck.checkUsuario(dinheiro.getUsuarioId());

        DinheiroEntity dinheiroEntity = new DinheiroEntity(
                usuarioEntity,
                dinheiro.getSaldo()
        );

        return mapper.toDinheiro(repository.save(dinheiroEntity));
    }

    @Override
    public Dinheiro atualizarSaldo(BigDecimal saldo, UUID idDinheiro) {
        Optional<DinheiroEntity> dinheiroEntity = repository.findById(idDinheiro);

        if (dinheiroEntity.isEmpty()) {
            throw new ResourceNotFoundException("Dinheiro", "id", idDinheiro);
        }

        DinheiroEntity dinheiro = dinheiroEntity.get();

        BigDecimal saldoAtual = dinheiro.getSaldo();

        dinheiro.setSaldo(saldoAtual.add(saldo));

        return mapper.toDinheiro(repository.save(dinheiro));
    }

    @Override
    public Dinheiro buscarPorUsuarioId(UUID idUsuario) {
        Optional<DinheiroEntity> dinheiroEntity = repository.findByUsuario_Id(idUsuario);

        if (dinheiroEntity.isEmpty()) {
            throw new ResourceNotFoundException("Dinheiro", "id", idUsuario);
        }

        return mapper.toDinheiro(dinheiroEntity.get());
    }

    @Override
    public void deletarDinheiroPorId(UUID idDinheiro) {
        Optional<DinheiroEntity> dinheiroEntity = repository.findById(idDinheiro);

        if (dinheiroEntity.isEmpty()) {
            throw new ResourceNotFoundException("Dinheiro", "id", idDinheiro);
        }

        repository.delete(dinheiroEntity.get());
    }
}
