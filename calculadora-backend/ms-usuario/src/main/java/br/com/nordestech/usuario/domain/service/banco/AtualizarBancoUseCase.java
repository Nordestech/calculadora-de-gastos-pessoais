package br.com.nordestech.usuario.domain.service.banco;

import br.com.nordestech.usuario.domain.model.Banco;
import br.com.nordestech.usuario.domain.repository.BancoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AtualizarBancoUseCase {

    private final BancoRepository repository;

    public Banco debitarSaldo(BigDecimal valor, UUID idBanco) {
        Banco banco = repository.buscarBancoPorId(idBanco);

        banco.debitar(valor);

        return repository.atualizarSaldo(banco.getSaldo(), idBanco);
    }

    public Banco creditarSaldo(BigDecimal valor, UUID idBanco) {
        Banco banco = repository.buscarBancoPorId(idBanco);

        banco.creditar(valor);

        return repository.atualizarSaldo(banco.getSaldo(), idBanco);
    }

}
