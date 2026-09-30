package br.com.nordestech.usuario.infra.persistence.gasto;

import br.com.nordestech.usuario.domain.exceptions.ResourceNotFoundException;
import br.com.nordestech.usuario.domain.model.Gasto;
import br.com.nordestech.usuario.domain.repository.GastoRepository;
import br.com.nordestech.usuario.infra.persistence.abstracts.PagamentoEntity;
import br.com.nordestech.usuario.infra.persistence.abstracts.SpringDataJpaPagamentoRepository;
import br.com.nordestech.usuario.infra.persistence.gasto.mapper.GastoMapper;
import br.com.nordestech.usuario.infra.persistence.usuario.UsuarioEntity;
import br.com.nordestech.usuario.infra.utils.UsuarioBancoCheck;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class GastoRepositoryImpl implements GastoRepository {

    private final SpringDataJpaGastoRepository repository;
    private final SpringDataJpaPagamentoRepository pagamentoRepository;
    private final UsuarioBancoCheck usuarioBancoCheck;
    private final GastoMapper mapper;

    @Override
    public Gasto salvar(Gasto gasto) {

        PagamentoEntity pagamentoEntity = pagamentoRepository.findById(gasto.getPagamentoId())
                .orElseThrow(() -> new ResourceNotFoundException("Pagamento", "id", gasto.getPagamentoId()));

        UsuarioEntity usuarioEntity = usuarioBancoCheck.checkUsuario(gasto.getUsuarioId());

        GastoEntity gastoEntity = new GastoEntity(
                usuarioEntity,
                gasto.getDescricao(),
                gasto.getTipoGasto(),
                gasto.getValor(),
                gasto.getTipoPagamento(),
                pagamentoEntity,
                gasto.getDataCompra(),
                gasto.getDataPagamento()
        );

        return mapper.toGasto(repository.save(gastoEntity));
    }

    @Override
    public Gasto buscarGastoPorId(UUID id) {
        Optional<GastoEntity> gastoEntity = repository.findById(id);

        if (gastoEntity.isEmpty()) {
            throw new ResourceNotFoundException("Gasto", "id", id);
        }

        return mapper.toGasto(gastoEntity.get());
    }

    @Override
    public Page<Gasto> buscarTodosGastosPorUsuarioId(Pageable pageable, UUID idUsuario) {
        return repository.findAllByUsuarioGastos_Id(idUsuario, pageable).map(mapper::toGasto);
    }

    @Override
    public void deletarGastoPorId(UUID idGasto) {
        Optional<GastoEntity> gastoEntity = repository.findById(idGasto);

        if (gastoEntity.isEmpty()) {
            throw new ResourceNotFoundException("Gasto", "id", idGasto);
        }

        repository.delete(gastoEntity.get());
    }
}
