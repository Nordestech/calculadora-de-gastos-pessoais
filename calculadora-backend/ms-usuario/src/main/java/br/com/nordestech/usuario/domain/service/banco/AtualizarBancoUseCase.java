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

    public Banco atualizarSaldo(BigDecimal saldo, UUID idBanco) {
        return repository.atualizarSaldo(saldo, idBanco);
    }

}
