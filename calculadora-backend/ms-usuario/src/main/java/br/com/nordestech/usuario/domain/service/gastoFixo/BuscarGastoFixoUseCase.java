package br.com.nordestech.usuario.domain.service.gastoFixo;

import br.com.nordestech.usuario.domain.model.GastoFixo;
import br.com.nordestech.usuario.domain.repository.GastoFixoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BuscarGastoFixoUseCase {

    private final GastoFixoRepository repository;

    public Set<GastoFixo> buscarGastoFixosPorUsuarioId(UUID idUsuario) {
        return repository.buscarTodosGastoFixosPorUsuarioId(idUsuario);
    }

}
