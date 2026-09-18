package br.com.nordestech.usuario.domain.service.cartao;

import br.com.nordestech.usuario.domain.repository.CartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeletarCartaoUseCase {

    private final CartaoRepository repository;

    public void execute(UUID idCartao) {

        repository.deletarCartaoPorId(idCartao);

    }

}
