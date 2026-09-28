package br.com.nordestech.usuario.domain.service.cartao;

import br.com.nordestech.usuario.domain.model.Cartao;
import br.com.nordestech.usuario.domain.repository.CartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BuscarCartaoUseCase {

    private final CartaoRepository repository;

    public Set<Cartao> buscarCartaosPorUsuarioId(UUID idUsuario) {
        return repository.buscarCartoesPorUsuarioId(idUsuario);
    }

}
