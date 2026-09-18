package br.com.nordestech.usuario.domain.repository;

import br.com.nordestech.usuario.domain.model.Pix;

import java.util.Set;
import java.util.UUID;

public interface PixRepository {

    Pix salvar(Pix pix, UUID idUsuario);

    Pix buscarPorId(UUID id);

    Set<Pix> buscarPixPorUsuarioId(UUID id);

    void deletarPixPorId(UUID id);


}
