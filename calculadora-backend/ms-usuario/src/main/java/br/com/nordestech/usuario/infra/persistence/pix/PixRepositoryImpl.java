package br.com.nordestech.usuario.infra.persistence.pix;

import br.com.nordestech.usuario.domain.model.Pix;
import br.com.nordestech.usuario.domain.repository.PixRepository;
import br.com.nordestech.usuario.infra.persistence.pix.mapper.PixMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PixRepositoryImpl implements PixRepository {

    public final PixMapper mapper;
    public final SpringDataJpaPixRepository repository;

    @Override
    public Pix salvar(Pix pix, UUID idUsuario) {
        return null;
    }

    @Override
    public Pix buscarPorId(UUID id) {
        return null;
    }

    @Override
    public Set<Pix> buscarPixPorUsuarioId(UUID id) {
        return Set.of();
    }

    @Override
    public void deletarPixPorId(UUID id) {

    }
}
