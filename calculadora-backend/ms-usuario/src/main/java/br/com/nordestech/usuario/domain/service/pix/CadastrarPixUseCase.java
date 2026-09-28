package br.com.nordestech.usuario.domain.service.pix;

import br.com.nordestech.usuario.domain.model.Pix;
import br.com.nordestech.usuario.domain.repository.PixRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastrarPixUseCase {

    private final PixRepository repository;

    public Pix execute(Pix pix) {
        return repository.salvar(pix);
    }

}
