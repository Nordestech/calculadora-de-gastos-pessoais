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

    public Dinheiro atualizarSaldo(BigDecimal saldo, UUID idDinheiro){
        return repository.atualizarSaldo(saldo, idDinheiro);
    }

}
