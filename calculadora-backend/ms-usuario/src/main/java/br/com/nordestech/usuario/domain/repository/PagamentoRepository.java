package br.com.nordestech.usuario.domain.repository;

import br.com.nordestech.usuario.domain.model.Pagamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface PagamentoRepository {

    Pagamento salvar(Pagamento pagamento, UUID idUsuario);

    Pagamento buscarPorId(UUID id);

    Page<Pagamento> buscarTodosPagamentosPorUsuarioId(Pageable pageable, UUID idUsuario);

    void deletarPagamentoPorId(UUID id);


}
