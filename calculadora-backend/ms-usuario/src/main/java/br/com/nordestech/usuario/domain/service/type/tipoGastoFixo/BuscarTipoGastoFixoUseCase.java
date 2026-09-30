package br.com.nordestech.usuario.domain.service.type.tipoGastoFixo;

import br.com.nordestech.usuario.domain.model.type.TipoGastoFixo;
import br.com.nordestech.usuario.domain.repository.type.TipoGastoFixoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BuscarTipoGastoFixoUseCase {

    private final TipoGastoFixoRepository repository;

    public TipoGastoFixo buscarTipoGastoFixoPorUsuarioId(UUID idUsuario) {
        return repository.buscarTipoGastoFixoPorUsuarioId(idUsuario);
    }

}
