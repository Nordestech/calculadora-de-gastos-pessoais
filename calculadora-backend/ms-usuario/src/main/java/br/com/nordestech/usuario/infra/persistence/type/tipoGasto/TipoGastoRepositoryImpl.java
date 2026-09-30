package br.com.nordestech.usuario.infra.persistence.type.tipoGasto;

import br.com.nordestech.usuario.domain.exceptions.ResourceNotFoundException;
import br.com.nordestech.usuario.domain.model.type.TipoGasto;
import br.com.nordestech.usuario.domain.repository.type.TipoGastoRepository;
import br.com.nordestech.usuario.infra.persistence.type.tipoGasto.mapper.TipoGastoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class TipoGastoRepositoryImpl implements TipoGastoRepository {

    private final SpringDataJpaTipoGastoRepository repository;
    private final TipoGastoMapper mapper;

    @Override
    public TipoGasto atualizarTipoGasto(TipoGasto tipoGasto, UUID idTipoGasto) {
        Optional<TipoGastoEntity> tipoGastoEntity = repository.findById(idTipoGasto);

        if (tipoGastoEntity.isEmpty()) {
            throw new ResourceNotFoundException("TipoGasto", "id", idTipoGasto);
        }

        TipoGastoEntity tipoGastoToUpdate = tipoGastoEntity.get();

        if (tipoGasto.getTipos() != null) {
            tipoGastoToUpdate.setTipos(tipoGasto.getTipos());
        }

        return mapper.toTipoGasto(repository.save(tipoGastoToUpdate));
    }

    @Override
    public TipoGasto buscarTipoGastoPorUsuarioId(UUID idUsuario) {
        Optional<TipoGastoEntity> tipoGastoEntity = repository.findByUsuario_Id(idUsuario);

        if (tipoGastoEntity.isEmpty()) {
            throw new ResourceNotFoundException("TipoGasto", "id", idUsuario);
        }

        return mapper.toTipoGasto(tipoGastoEntity.get());
    }

    @Override
    public void deletarTipoGasto(UUID idTipoGasto) {
        Optional<TipoGastoEntity> tipoGastoEntity = repository.findById(idTipoGasto);

        if (tipoGastoEntity.isEmpty()) {
            throw new ResourceNotFoundException("TipoGasto", "id", idTipoGasto);
        }

        repository.delete(tipoGastoEntity.get());
    }
}
