package br.com.nordestech.usuario.infra.persistence.type.tipoGastoFixo.mapper;

import br.com.nordestech.usuario.domain.model.type.TipoGastoFixo;
import br.com.nordestech.usuario.infra.persistence.type.tipoGastoFixo.TipoGastoFixoEntity;
import org.springframework.stereotype.Component;

@Component
public class TipoGastoFixoMapper {

    public TipoGastoFixo toTipoGastoFixo(TipoGastoFixoEntity entity) {

        return TipoGastoFixo.builder()
                .idTipoGastoFixo(entity.getId())
                .usuarioId(entity.getUsuario().getId())
                .tipos(entity.getTipos())
                .build();
    }

}
