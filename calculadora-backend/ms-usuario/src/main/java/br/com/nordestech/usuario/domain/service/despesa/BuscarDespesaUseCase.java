package br.com.nordestech.usuario.domain.service.despesa;

import br.com.nordestech.usuario.domain.model.Despesa;
import br.com.nordestech.usuario.domain.repository.DespesaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BuscarDespesaUseCase {

    private final DespesaRepository repository;

    public Despesa buscarDespesaPorId(UUID idDespesa) {
        return repository.buscarPorId(idDespesa);
    }

    public Page<Despesa> buscarTodasDespesasPorUsuarioId(Pageable pageable, UUID idUsuario) {
        return repository.buscarTodasDespesasPorUsuarioId(pageable, idUsuario);
    }

}
