package br.com.nordestech.usuario.domain.service.banco;

import br.com.nordestech.usuario.domain.repository.BancoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeletarBancoUseCase {

    private final BancoRepository repository;

    public void execute(UUID idBanco) {

        repository.deletarBancoPorId(idBanco);

    }

}
