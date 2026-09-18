package br.com.nordestech.usuario.domain.service.banco;

import br.com.nordestech.usuario.domain.model.Banco;
import br.com.nordestech.usuario.domain.repository.BancoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BuscarBancoUseCase {

    private final BancoRepository repository;

    public Banco buscarBancoPorId(UUID idBanco) {
        return repository.buscarPorId(idBanco);
    }

    public Set<Banco> buscarBancosPorUsuarioId(UUID idUsuario) {
        return repository.buscarBancosPorUsuarioId(idUsuario);
    }

}
