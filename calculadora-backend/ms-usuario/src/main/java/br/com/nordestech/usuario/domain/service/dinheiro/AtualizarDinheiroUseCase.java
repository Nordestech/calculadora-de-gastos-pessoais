package br.com.nordestech.usuario.domain.service.dinheiro;

import br.com.nordestech.usuario.domain.model.Dinheiro;
import br.com.nordestech.usuario.domain.repository.DinheiroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AtualizarDinheiroUseCase {

    private final DinheiroRepository repository;

    public Dinheiro debitarSaldo(BigDecimal saldo, UUID idDinheiro){

        Dinheiro dinheiro = repository.buscarDinheiroPorId(idDinheiro);

        dinheiro.debitar(saldo);

        return repository.atualizarSaldo(dinheiro.getSaldo(), idDinheiro);
    }

    public Dinheiro creditarSaldo(BigDecimal saldo, UUID idDinheiro){

        Dinheiro dinheiro = repository.buscarDinheiroPorId(idDinheiro);

        dinheiro.creditar(saldo);

        return repository.atualizarSaldo(dinheiro.getSaldo(), idDinheiro);
    }

}
