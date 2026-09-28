package br.com.nordestech.usuario.domain.service.gasto;

import br.com.nordestech.usuario.domain.model.Gasto;
import br.com.nordestech.usuario.domain.repository.GastoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BuscarGastoUseCase {

    private final GastoRepository repository;
    
    public Page<Gasto> buscarGastosPorUsuarioId(Pageable pageable, UUID idUsuario) {
        return repository.buscarTodosGastosPorUsuarioId(pageable, idUsuario);
    }

}
