package br.com.nordestech.usuario.infra.persistence.abstracts;

import br.com.nordestech.usuario.domain.exceptions.ResourceNotFoundException;
import br.com.nordestech.usuario.domain.model.abstracts.Pagamento;
import br.com.nordestech.usuario.domain.repository.abstracts.PagamentoRepository;
import br.com.nordestech.usuario.infra.persistence.abstracts.mapper.PagamentoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PagamentoRepositoryImpl implements PagamentoRepository {

    private final SpringDataJpaPagamentoRepository repository;
    private final PagamentoMapper mapper;

    @Override
    public Pagamento buscarPagamentoPorId(UUID idPagamento) {

        Optional<PagamentoEntity> pagamentoEntity = repository.findById(idPagamento);

        if (pagamentoEntity.isEmpty()) {
            throw new ResourceNotFoundException("Pagamento", "id", idPagamento);
        }

        return mapper.toPagamento(pagamentoEntity.get());
    }
}
