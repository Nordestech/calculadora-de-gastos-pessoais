package br.com.nordestech.usuario.infra.persistence.gasto.mapper;

import br.com.nordestech.usuario.domain.model.Gasto;
import br.com.nordestech.usuario.infra.persistence.gasto.GastoEntity;
import org.springframework.stereotype.Component;

@Component
public class GastoMapper {

    public Gasto toGasto(GastoEntity entity) {

        return Gasto.builder()
                .idGasto(entity.getId())
                .usuarioId(entity.getUsuarioGastos().getId())
                .descricao(entity.getDescricao())
                .tipoGasto(entity.getTipoGasto())
                .pagamentoId(entity.getPagamento().getId())
                .valor(entity.getValor())
                .dataCompra(entity.getDataCompra())
                .dataPagamento(entity.getDataPagamento())
                .build();
    }

}
