package br.com.nordestech.usuario.domain.repository;

import br.com.nordestech.usuario.domain.model.Despesa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface DespesaRepository {

    Despesa salvar(Despesa despesa, UUID idUsuario);

    Despesa buscarPorId(UUID id);

    Page<Despesa> buscarTodasDespesasPorUsuarioId(Pageable pageable, UUID id);

    void deletarDespesaPorId(UUID id);
    
}
