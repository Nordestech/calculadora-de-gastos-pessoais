package br.com.nordestech.usuario.domain.service.receita;

import br.com.nordestech.usuario.domain.model.Receita;
import br.com.nordestech.usuario.domain.repository.ReceitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BuscarReceitaUseCase {

    private final ReceitaRepository repository;

    public Receita buscarReceitaPorId(UUID idReceita) {
        return repository.buscarPorId(idReceita);
    }

}
