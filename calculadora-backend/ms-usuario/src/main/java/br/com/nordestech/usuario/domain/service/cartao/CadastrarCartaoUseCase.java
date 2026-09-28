package br.com.nordestech.usuario.domain.service.cartao;

import br.com.nordestech.usuario.domain.model.Cartao;
import br.com.nordestech.usuario.domain.repository.CartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastrarCartaoUseCase {

    private final CartaoRepository repository;

    public Cartao execute(Cartao cartao) {

        return repository.salvar(cartao);

    }

}
