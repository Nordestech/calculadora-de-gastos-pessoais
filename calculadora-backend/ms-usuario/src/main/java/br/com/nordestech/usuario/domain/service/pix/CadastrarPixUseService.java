package br.com.nordestech.usuario.domain.service.pix;

import br.com.nordestech.usuario.domain.model.Pix;
import br.com.nordestech.usuario.domain.repository.PixRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CadastrarPixUseService {

    private final PixRepository repository;

    public Pix execute(Pix pix, UUID idUsuario) {
        return repository.salvar(pix, idUsuario);
    }

}
