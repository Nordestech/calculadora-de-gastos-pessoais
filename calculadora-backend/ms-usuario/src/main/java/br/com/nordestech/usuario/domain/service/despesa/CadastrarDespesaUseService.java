package br.com.nordestech.usuario.domain.service.despesa;

import br.com.nordestech.usuario.domain.model.Despesa;
import br.com.nordestech.usuario.domain.repository.DespesaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CadastrarDespesaUseService {

    private final DespesaRepository repository;

    public Despesa execute(Despesa despesa, UUID idUsuario) {
        return repository.salvar(despesa, idUsuario);
    }

}
