package br.com.nordestech.usuario.domain.repository;

import br.com.nordestech.usuario.domain.model.Dinheiro;

import java.util.UUID;

public interface DinheiroRepository {

    Dinheiro salvar(Dinheiro dinheiro, UUID idUsuario);

    Dinheiro buscarPorId(UUID id);

    void deletarDinheiroPorId(UUID id);

}
