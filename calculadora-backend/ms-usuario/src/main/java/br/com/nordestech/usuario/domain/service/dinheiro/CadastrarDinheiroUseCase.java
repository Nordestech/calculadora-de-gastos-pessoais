package br.com.nordestech.usuario.domain.service.dinheiro;

import br.com.nordestech.usuario.domain.model.Dinheiro;
import br.com.nordestech.usuario.domain.repository.DinheiroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastrarDinheiroUseCase {

    private final DinheiroRepository repository;

    public Dinheiro execute(Dinheiro dinheiro) {
        return repository.salvar(dinheiro);
    }

}
