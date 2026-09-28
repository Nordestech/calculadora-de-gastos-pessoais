package br.com.nordestech.usuario.domain.service.type.tipoGastoFixo;

import br.com.nordestech.usuario.domain.repository.type.TipoGastoFixoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeletarTipoGastoFixoUseCase {

    private final TipoGastoFixoRepository repository;

    public void execute(UUID idTipoGastoFixo) {

        repository.deletarTipoGastoFixo(idTipoGastoFixo);

    }

}
