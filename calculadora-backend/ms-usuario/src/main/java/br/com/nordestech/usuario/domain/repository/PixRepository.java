package br.com.nordestech.usuario.domain.repository;

import br.com.nordestech.usuario.domain.model.Pix;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

public interface PixRepository {

    Pix salvar(Pix pix);

    Pix atualizarSaldo(BigDecimal saldo, UUID idPix);

    Set<Pix> buscarPixPorUsuarioId(UUID idUsuario);

    void deletarPixPorId(UUID idPix);

}
