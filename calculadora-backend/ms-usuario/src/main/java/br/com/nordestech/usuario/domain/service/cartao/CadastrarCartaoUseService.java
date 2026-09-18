package br.com.nordestech.usuario.domain.service.cartao;

import br.com.nordestech.usuario.domain.model.Cartao;
import br.com.nordestech.usuario.domain.repository.CartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CadastrarCartaoUseService {

    private final CartaoRepository repository;

    public Cartao execute(Cartao cartao, UUID idUsuario) {
        return repository.salvar(cartao, idUsuario);
    }

}
