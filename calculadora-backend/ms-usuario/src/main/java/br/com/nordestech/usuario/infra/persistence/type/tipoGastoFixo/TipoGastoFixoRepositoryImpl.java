package br.com.nordestech.usuario.infra.persistence.type.tipoGastoFixo;

import br.com.nordestech.usuario.domain.exceptions.ResourceNotFoundException;
import br.com.nordestech.usuario.domain.model.type.TipoGastoFixo;
import br.com.nordestech.usuario.domain.repository.type.TipoGastoFixoRepository;
import br.com.nordestech.usuario.infra.persistence.type.tipoGastoFixo.mapper.TipoGastoFixoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class TipoGastoFixoRepositoryImpl implements TipoGastoFixoRepository {
    
    private final SpringDataJpaTipoGastoFixoRepository repository;
    private final TipoGastoFixoMapper mapper;

    @Override
    public TipoGastoFixo atualizarTipoGastoFixo(TipoGastoFixo tipoGastoFixo, UUID idTipoGastoFixo) {
        Optional<TipoGastoFixoEntity> tipoGastoFixoEntity = repository.findById(idTipoGastoFixo);

        if (tipoGastoFixoEntity.isEmpty()) {
            throw new ResourceNotFoundException("TipoGastoFixo", "id", idTipoGastoFixo);
        }

        TipoGastoFixoEntity tipoGastoFixoToUpdate = tipoGastoFixoEntity.get();

        if (tipoGastoFixo.getTipos() != null) {
            tipoGastoFixoToUpdate.setTipos(tipoGastoFixo.getTipos());
        }

        return mapper.toTipoGastoFixo(repository.save(tipoGastoFixoToUpdate));
    }

    @Override
    public TipoGastoFixo buscarTipoGastoFixoPorUsuarioId(UUID idUsuario) {
        Optional<TipoGastoFixoEntity> tipoGastoFixoEntity = repository.findByUsuario_Id(idUsuario);

        if (tipoGastoFixoEntity.isEmpty()) {
            throw new ResourceNotFoundException("TipoGastoFixo", "id", idUsuario);
        }

        return  mapper.toTipoGastoFixo(tipoGastoFixoEntity.get());
    }

    @Override
    public void deletarTipoGastoFixo(UUID idTipoGastoFixo) {
        Optional<TipoGastoFixoEntity> tipoGastoFixoEntity = repository.findById(idTipoGastoFixo);

        if (tipoGastoFixoEntity.isEmpty()) {
            throw new ResourceNotFoundException("TipoGastoFixo", "id", idTipoGastoFixo);
        }

        repository.delete(tipoGastoFixoEntity.get());
    }
}
