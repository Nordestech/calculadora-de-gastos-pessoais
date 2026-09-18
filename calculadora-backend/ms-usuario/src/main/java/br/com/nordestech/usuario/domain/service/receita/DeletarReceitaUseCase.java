package br.com.nordestech.usuario.domain.service.receita;

import br.com.nordestech.usuario.domain.repository.ReceitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeletarReceitaUseCase {

    private final ReceitaRepository repository;

    public void execute(UUID idReceita) {

        repository.deletarReceitaPorId(idReceita);

    }

}
