package br.com.nordestech.usuario.infra.persistence.type.tipoGasto.mapper;

import br.com.nordestech.usuario.domain.model.type.TipoGasto;
import br.com.nordestech.usuario.infra.persistence.type.tipoGasto.TipoGastoEntity;
import org.springframework.stereotype.Component;

@Component
public class TipoGastoMapper {

    public TipoGasto toTipoGasto(TipoGastoEntity entity) {

        return TipoGasto.builder()
                .idTipoGasto(entity.getId())
                .usuarioId(entity.getUsuario().getId())
                .tipos(entity.getTipos())
                .build();
    }

}
