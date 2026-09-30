package br.com.nordestech.usuario.infra.persistence.gastoFixo.mapper;

import br.com.nordestech.usuario.domain.model.GastoFixo;
import br.com.nordestech.usuario.infra.persistence.gastoFixo.GastoFixoEntity;
import org.springframework.stereotype.Component;

@Component
public class GastoFixoMapper {

    public GastoFixo toGastoFixo(GastoFixoEntity entity) {

        return GastoFixo.builder()
                .idGastoFixo(entity.getId())
                .usuarioId(entity.getUsuarioGastosFixos().getId())
                .descricao(entity.getDescricao())
                .tipoGastoFixo(entity.getTipoGastoFixo())
                .valor(entity.getValor())
                .pagamentoId(entity.getPagamento().getId())
                .dataReferencia(entity.getDataReferencia())
                .build();
    }

}
