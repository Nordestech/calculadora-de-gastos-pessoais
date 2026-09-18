package br.com.nordestech.usuario.domain.service.pix;

import br.com.nordestech.usuario.domain.repository.PixRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeletarPixUseCase {

    private final PixRepository repository;

    public void execute(UUID idPix) {

        repository.deletarPixPorId(idPix);

    }

}
