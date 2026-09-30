package br.com.nordestech.usuario.domain.repository.abstracts;

import br.com.nordestech.usuario.domain.model.abstracts.Pagamento;

import java.util.UUID;

public interface PagamentoRepository {

    Pagamento buscarPagamentoPorId(UUID idPagamento);

}
