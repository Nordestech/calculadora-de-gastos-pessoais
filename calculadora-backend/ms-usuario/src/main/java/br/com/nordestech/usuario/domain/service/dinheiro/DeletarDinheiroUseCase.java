package br.com.nordestech.usuario.domain.service.dinheiro;

import br.com.nordestech.usuario.domain.repository.DinheiroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeletarDinheiroUseCase {

    private final DinheiroRepository repository;

    public void execute(UUID idDinheiro) {

        repository.deletarDinheiroPorId(idDinheiro);

    }

}
