package br.com.nordestech.usuario.domain.service.receita;

import br.com.nordestech.usuario.domain.model.Receita;
import br.com.nordestech.usuario.domain.repository.ReceitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CadastrarReceitaUseService {

    private final ReceitaRepository repository;

    public Receita execute(Receita receita, UUID idUsuario) {
        return repository.salvar(receita, idUsuario);
    }

}
