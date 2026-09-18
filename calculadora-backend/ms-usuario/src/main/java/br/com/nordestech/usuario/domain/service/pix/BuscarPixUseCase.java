package br.com.nordestech.usuario.domain.service.pix;

import br.com.nordestech.usuario.domain.model.Pix;
import br.com.nordestech.usuario.domain.repository.PixRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BuscarPixUseCase {

    private final PixRepository repository;

    public Pix buscarPixPorId(UUID idPix) {
        return repository.buscarPorId(idPix);
    }

    public Set<Pix> buscarPixsPorUsuarioId(UUID idUsuario) {
        return repository.buscarPixPorUsuarioId(idUsuario);
    }

}
