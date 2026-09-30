package br.com.nordestech.usuario.domain.repository;

import br.com.nordestech.usuario.domain.model.Banco;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

public interface BancoRepository {

    Banco salvar(Banco banco);

    Banco atualizarSaldo(BigDecimal saldo, UUID idBanco);

    Set<Banco> buscarBancosPorUsuarioId(UUID id);

    void deletarBancoPorId(UUID idBanco);

    Banco buscarBancoPorId(UUID idBanco);

}
