package br.com.nordestech.usuario.domain.repository.type;

import br.com.nordestech.usuario.domain.model.type.TipoGasto;

import java.util.Set;
import java.util.UUID;

public interface TipoGastoRepository {

    TipoGasto atualizarTipoGasto(TipoGasto tipoGasto, UUID idTipoGasto);

    Set<TipoGasto> buscarTipoGastoPorUsuarioId(UUID idUsuario);

    void deletarTipoGasto(UUID idTipoGasto);
}
