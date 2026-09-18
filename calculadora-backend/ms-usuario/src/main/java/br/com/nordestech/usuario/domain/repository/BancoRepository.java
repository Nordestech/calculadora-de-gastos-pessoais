package br.com.nordestech.usuario.domain.repository;

import br.com.nordestech.usuario.domain.model.Banco;

import java.util.Set;
import java.util.UUID;

public interface BancoRepository {

    Banco salvar(Banco banco, UUID idUsuario);

    Banco buscarPorId(UUID id);

    Set<Banco> buscarBancosPorUsuarioId(UUID id);

    void deletarBancoPorId(UUID id);

}
