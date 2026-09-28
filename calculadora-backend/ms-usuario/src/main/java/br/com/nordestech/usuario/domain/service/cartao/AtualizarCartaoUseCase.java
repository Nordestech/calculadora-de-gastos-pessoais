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

    public Cartao atualizarSaldo(BigDecimal saldo, UUID idCartao) {
        return repository.atualizarSaldo(saldo, idCartao);
    }

    public Cartao atualizarLimiteDisponivel(BigDecimal limiteDisponivel, UUID idCartao) {
        return repository.atualizarLimiteDisponivel(limiteDisponivel, idCartao);
    }

}
