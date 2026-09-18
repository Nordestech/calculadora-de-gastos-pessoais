package br.com.nordestech.usuario.domain.service.pagamento;

import br.com.nordestech.usuario.domain.model.Pagamento;
import br.com.nordestech.usuario.domain.repository.PagamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BuscarPagamentoUseCase {

    private final PagamentoRepository repository;

    public Pagamento buscarPagamentoPorId(UUID idPagamento) {
        return repository.buscarPorId(idPagamento);
    }
    
    public Page<Pagamento> buscarTodasPagamentosPorUsuarioId(Pageable pageable, UUID idUsuario) {
        return repository.buscarTodosPagamentosPorUsuarioId(pageable, idUsuario);
    }

}
