package br.com.nordestech.usuario.domain.service.type.tipoGasto;

import br.com.nordestech.usuario.domain.repository.type.TipoGastoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeletarTipoGastoUseCase {

    private final TipoGastoRepository repository;

    public void execute(UUID idTipoGasto) {

        repository.deletarTipoGasto(idTipoGasto);

    }

}
