package br.com.nordestech.usuario.domain.service.gasto;

import br.com.nordestech.usuario.domain.repository.GastoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeletarGastoUseCase {

    private final GastoRepository repository;

    public void execute(UUID idGasto) {

        repository.deletarGastoPorId(idGasto);

    }

}
