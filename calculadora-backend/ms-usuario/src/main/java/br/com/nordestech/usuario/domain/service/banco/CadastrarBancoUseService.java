package br.com.nordestech.usuario.domain.service.banco;

import br.com.nordestech.usuario.domain.model.Banco;
import br.com.nordestech.usuario.domain.repository.BancoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CadastrarBancoUseService {

    private final BancoRepository repository;

    public Banco execute(Banco banco, UUID idUsuario) {
        return repository.salvar(banco, idUsuario);
    }

}
