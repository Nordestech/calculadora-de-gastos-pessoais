package br.com.nordestech.usuario.domain.repository;

import br.com.nordestech.usuario.domain.model.Receita;

import java.util.UUID;

public interface ReceitaRepository {

    Receita salvar(Receita receita, UUID idUsuario);

    Receita buscarPorId(UUID id);

    void deletarReceitaPorId(UUID id);

}
