package br.com.nordestech.usuario.infra.persistence.banco.mapper;

import br.com.nordestech.usuario.domain.model.Banco;
import br.com.nordestech.usuario.infra.persistence.banco.BancoEntity;
import org.springframework.stereotype.Component;

@Component
public class BancoMapper {

    public Banco toBanco(BancoEntity entity) {

        return Banco.builder()
                .idBanco(entity.getId())
                .usuarioId(entity.getUsuarioBanco().getId())
                .nomeBanco(entity.getNomeBanco())
                .saldo(entity.getSaldo())
                .build();
    }

}
