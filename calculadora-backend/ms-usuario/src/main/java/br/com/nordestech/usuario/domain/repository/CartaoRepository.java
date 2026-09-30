package br.com.nordestech.usuario.domain.repository;

import br.com.nordestech.usuario.domain.model.Cartao;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

public interface CartaoRepository {

    Cartao salvar(Cartao cartao);

    Cartao atualizarLimiteDisponivel(BigDecimal limiteDisponivel, UUID idCartao);

    Cartao atualizarSaldo(BigDecimal saldo, UUID idCartao);

    Set<Cartao> buscarCartoesPorUsuarioId(UUID idUsuario);

    void deletarCartaoPorId(UUID idCartao);

    Cartao buscarCartaoPorId(UUID idCartao);

}
