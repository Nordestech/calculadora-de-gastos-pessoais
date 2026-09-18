package br.com.nordestech.usuario.domain.repository;

import br.com.nordestech.usuario.domain.model.Cartao;

import java.util.Set;
import java.util.UUID;

public interface CartaoRepository {

    Cartao salvar(Cartao cartao, UUID idUsuario);

    Cartao buscarPorId(UUID id);

    Set<Cartao> buscarCartoesPorUsuarioId(UUID id);

    void deletarCartaoPorId(UUID id);

}
