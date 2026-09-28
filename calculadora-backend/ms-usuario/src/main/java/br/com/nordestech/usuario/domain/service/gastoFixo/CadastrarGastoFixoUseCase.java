package br.com.nordestech.usuario.domain.service.gastoFixo;

import br.com.nordestech.usuario.domain.model.GastoFixo;
import br.com.nordestech.usuario.domain.repository.GastoFixoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastrarGastoFixoUseCase {

    private final GastoFixoRepository repository;

    public GastoFixo execute(GastoFixo gastoFixo) {
        return repository.salvar(gastoFixo);
    }

}
