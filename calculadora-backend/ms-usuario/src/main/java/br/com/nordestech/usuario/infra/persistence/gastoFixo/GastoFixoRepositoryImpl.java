package br.com.nordestech.usuario.infra.persistence.gastoFixo;

import br.com.nordestech.usuario.domain.exceptions.ResourceNotFoundException;
import br.com.nordestech.usuario.domain.model.GastoFixo;
import br.com.nordestech.usuario.domain.repository.GastoFixoRepository;
import br.com.nordestech.usuario.infra.persistence.abstracts.PagamentoEntity;
import br.com.nordestech.usuario.infra.persistence.abstracts.SpringDataJpaPagamentoRepository;
import br.com.nordestech.usuario.infra.persistence.gastoFixo.mapper.GastoFixoMapper;
import br.com.nordestech.usuario.infra.persistence.usuario.UsuarioEntity;
import br.com.nordestech.usuario.infra.utils.UsuarioBancoCheck;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GastoFixoRepositoryImpl implements GastoFixoRepository {

    private final SpringDataJpaGastoFixoRepository repository;
    private final SpringDataJpaPagamentoRepository pagamentoRepository;
    private final GastoFixoMapper mapper;
    private final UsuarioBancoCheck usuarioBancoCheck;

    @Override
    public GastoFixo salvar(GastoFixo gastoFixo) {
        PagamentoEntity pagamentoEntity = pagamentoRepository.findById(gastoFixo.getPagamentoId())
                .orElseThrow(() -> new ResourceNotFoundException("Pagamento", "id", gastoFixo.getPagamentoId()));

        UsuarioEntity usuarioEntity = usuarioBancoCheck.checkUsuario(gastoFixo.getUsuarioId());

        GastoFixoEntity gastoFixoEntity = new GastoFixoEntity(
                usuarioEntity,
                gastoFixo.getDescricao(),
                gastoFixo.getTipoGastoFixo(),
                pagamentoEntity,
                gastoFixo.getValor(),
                gastoFixo.getDataReferencia()
        );

        return mapper.toGastoFixo(repository.save(gastoFixoEntity));
    }

    @Override
    public Set<GastoFixo> buscarTodosGastoFixosPorUsuarioId(UUID idUsuario) {
        return repository.findAllByUsuarioGastosFixos_Id(idUsuario).stream().map(mapper::toGastoFixo).collect(Collectors.toSet());
    }

    @Override
    public void deletarGastoFixoPorId(UUID idGastoFixo) {
        Optional<GastoFixoEntity> gastoFixoEntity = repository.findById(idGastoFixo);

        if (gastoFixoEntity.isEmpty()) {
            throw new ResourceNotFoundException("Gasto Fixo", "id", idGastoFixo);
        }

        repository.delete(gastoFixoEntity.get());
    }

    @Override
    public GastoFixo buscarGastoFixoPorId(UUID idGastoFixo) {
        Optional<GastoFixoEntity> gastoFixoEntity = repository.findById(idGastoFixo);

        if (gastoFixoEntity.isEmpty()) {
            throw new ResourceNotFoundException("Gasto Fixo", "id", idGastoFixo);
        }

        return mapper.toGastoFixo(gastoFixoEntity.get());
    }
}
