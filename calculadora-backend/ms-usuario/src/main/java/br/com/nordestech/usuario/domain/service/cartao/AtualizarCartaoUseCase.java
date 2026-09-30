package br.com.nordestech.usuario.domain.service.cartao;

import br.com.nordestech.usuario.domain.model.Cartao;
import br.com.nordestech.usuario.domain.repository.CartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AtualizarCartaoUseCase {

    private final CartaoRepository repository;

    public Cartao debitarLimiteDisponivel(BigDecimal saldo, UUID idCartao) {
        Cartao cartao = repository.buscarCartaoPorId(idCartao);

        cartao.debitar(saldo);

        return repository.atualizarLimiteDisponivel(cartao.getLimiteDisponivel(), idCartao);
    }

    public Cartao creditarLimiteDisponivel(BigDecimal saldo, UUID idCartao) {
        Cartao cartao = repository.buscarCartaoPorId(idCartao);

        cartao.creditar(saldo);

        return repository.atualizarLimiteDisponivel(cartao.getLimiteDisponivel(), idCartao);
    }

}
