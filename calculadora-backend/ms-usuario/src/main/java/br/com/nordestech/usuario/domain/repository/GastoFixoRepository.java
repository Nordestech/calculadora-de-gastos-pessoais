package br.com.nordestech.usuario.domain.repository;

import br.com.nordestech.usuario.domain.model.GastoFixo;

import java.util.Set;
import java.util.UUID;

public interface GastoFixoRepository {

    GastoFixo salvar(GastoFixo gastoFixo);

    Set<GastoFixo> buscarTodosGastoFixosPorUsuarioId(UUID idUsuario);

    void deletarGastoFixoPorId(UUID idGastoFixo);

    GastoFixo buscarGastoFixoPorId(UUID idGastoFixo);
    
}
