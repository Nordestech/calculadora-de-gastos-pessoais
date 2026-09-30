package br.com.nordestech.usuario.domain.service.type.tipoGasto;

import br.com.nordestech.usuario.domain.model.type.TipoGasto;
import br.com.nordestech.usuario.domain.repository.type.TipoGastoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BuscarTipoGastoUseCase {

    private final TipoGastoRepository repository;

    public TipoGasto buscarTipoGastosPorUsuarioId(UUID idUsuario) {
        return repository.buscarTipoGastoPorUsuarioId(idUsuario);
    }

}
