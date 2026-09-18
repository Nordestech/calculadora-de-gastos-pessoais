package br.com.nordestech.usuario.domain.service.dinheiro;

import br.com.nordestech.usuario.domain.model.Dinheiro;
import br.com.nordestech.usuario.domain.repository.DinheiroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CadastrarDinheiroUseService {

    private final DinheiroRepository repository;

    public Dinheiro execute(Dinheiro dinheiro, UUID idUsuario) {
        return repository.salvar(dinheiro, idUsuario);
    }

}
