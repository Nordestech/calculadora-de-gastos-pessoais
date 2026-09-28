package br.com.nordestech.usuario.domain.service.gastoFixo;

import br.com.nordestech.usuario.domain.repository.GastoFixoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeletarGastoFixoUseCase {

    private final GastoFixoRepository repository;

    public void execute(UUID idGastoFixo) {

        repository.deletarGastoFixoPorId(idGastoFixo);

    }

}
