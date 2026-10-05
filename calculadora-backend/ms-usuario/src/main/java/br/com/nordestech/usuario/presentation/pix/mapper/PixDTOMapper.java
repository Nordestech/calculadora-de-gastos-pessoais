package br.com.nordestech.usuario.presentation.pix.mapper;

import br.com.nordestech.usuario.domain.model.Pix;
import br.com.nordestech.usuario.presentation.pix.rest.request.PixRequestDTO;
import br.com.nordestech.usuario.presentation.pix.rest.response.PixResponseDTO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PixDTOMapper {

    public Pix toPix(PixRequestDTO dto) {

        return Pix.builder()
                .usuarioId(UUID.fromString(dto.usuarioId()))
                .bancoId(UUID.fromString(dto.bancoId()))
                .chavePix(dto.chavePix())
                .build();

    }

    public PixResponseDTO toPixResponseDTO(Pix pix) {

        return PixResponseDTO.builder()
                .pixId(pix.getId())
                .usuarioId(pix.getUsuarioId())
                .bancoId(pix.getBancoId())
                .chavePix(pix.getChavePix())
                .build();

    }

}
