package br.com.nordestech.usuario.infra.persistence.dinheiro.mapper;

import br.com.nordestech.usuario.domain.model.Dinheiro;
import br.com.nordestech.usuario.infra.persistence.dinheiro.DinheiroEntity;
import org.springframework.stereotype.Component;

@Component
public class DinheiroMapper {

    public Dinheiro toDinheiro(DinheiroEntity entity) {

        return Dinheiro.builder()
                .id(entity.getId())
                .usuarioId(entity.getUsuario().getId())
                .saldo(entity.getSaldo())
                .build();
    }

}
