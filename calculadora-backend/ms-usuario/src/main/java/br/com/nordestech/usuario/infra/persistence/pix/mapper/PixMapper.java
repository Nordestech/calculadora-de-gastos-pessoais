package br.com.nordestech.usuario.infra.persistence.pix.mapper;

import br.com.nordestech.usuario.domain.model.Pix;
import br.com.nordestech.usuario.infra.persistence.pix.PixEntity;
import org.springframework.stereotype.Component;

@Component
public class PixMapper {

    public Pix toPix(PixEntity pixEntity) {

        return Pix.builder()
                .id(pixEntity.getId())
                .bancoId(pixEntity.getBanco().getId())
                .chavePix(pixEntity.getChavePix())
                .build();
    }

}
