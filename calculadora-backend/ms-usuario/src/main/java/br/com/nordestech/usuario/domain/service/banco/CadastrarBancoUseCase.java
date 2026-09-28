package br.com.nordestech.usuario.domain.service.banco;

import br.com.nordestech.usuario.domain.model.Banco;
import br.com.nordestech.usuario.domain.repository.BancoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastrarBancoUseCase {

    private final BancoRepository repository;

    public Banco execute(Banco banco) {
        return repository.salvar(banco);
    }

}
