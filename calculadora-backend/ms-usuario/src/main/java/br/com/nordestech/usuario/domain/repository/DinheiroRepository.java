package br.com.nordestech.usuario.domain.repository;

import br.com.nordestech.usuario.domain.model.Dinheiro;

import java.math.BigDecimal;
import java.util.UUID;

public interface DinheiroRepository {

    Dinheiro salvar(Dinheiro dinheiro);

    Dinheiro atualizarSaldo(BigDecimal saldo, UUID idDinheiro);

    Dinheiro buscarPorUsuarioId(UUID idUsuario);

    void deletarDinheiroPorId(UUID idDinheiro);

}
