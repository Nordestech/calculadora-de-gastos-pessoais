package br.com.nordestech.usuario.domain.repository.type;

import br.com.nordestech.usuario.domain.model.type.TipoGastoFixo;

import java.util.UUID;

public interface TipoGastoFixoRepository {

    TipoGastoFixo atualizarTipoGastoFixo(TipoGastoFixo tipoGastoFixo, UUID idTipoGastoFixo);

    TipoGastoFixo buscarTipoGastoFixoPorUsuarioId(UUID idUsuario);

    void deletarTipoGastoFixo(UUID idTipoGastoFixo);

}
