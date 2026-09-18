package br.com.nordestech.usuario.domain.service.despesa;

import br.com.nordestech.usuario.domain.repository.DespesaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeletarDespesaUseCase {

    private final DespesaRepository repository;

    public void execute(UUID idDespesa) {

        repository.deletarDespesaPorId(idDespesa);

    }

}
