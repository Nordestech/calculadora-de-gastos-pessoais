package br.com.nordestech.usuario.domain.service.gasto;

import br.com.nordestech.usuario.domain.model.Gasto;
import br.com.nordestech.usuario.domain.repository.GastoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastrarGastoUseCase {

    private final GastoRepository repository;

    public Gasto execute(Gasto gasto) {
        return repository.salvar(gasto);
    }

}
