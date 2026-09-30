package br.com.nordestech.usuario.domain.repository;

import br.com.nordestech.usuario.domain.model.Gasto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface GastoRepository {

    Gasto salvar(Gasto gasto);

    Gasto buscarGastoPorId(UUID id);

    Page<Gasto> buscarTodosGastosPorUsuarioId(Pageable pageable, UUID idUsuario);

    void deletarGastoPorId(UUID idGasto);
    
}
