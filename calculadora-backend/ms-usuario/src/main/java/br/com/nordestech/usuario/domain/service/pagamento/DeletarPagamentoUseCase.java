package br.com.nordestech.usuario.domain.service.pagamento;

import br.com.nordestech.usuario.domain.repository.PagamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeletarPagamentoUseCase {

    private final PagamentoRepository repository;

    public void execute(UUID idPagamento) {

        repository.deletarPagamentoPorId(idPagamento);

    }

}
