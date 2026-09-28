package br.com.nordestech.usuario.domain.service.type.tipoGastoFixo;

import br.com.nordestech.usuario.domain.model.type.TipoGastoFixo;
import br.com.nordestech.usuario.domain.repository.type.TipoGastoFixoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AtualizarTipoGastoFixoUseCase {
    
    private final TipoGastoFixoRepository repository;
    
    public TipoGastoFixo atualizarSaldo(TipoGastoFixo tipoGastoFixo, UUID idTipoGastoFixo){
        return repository.atualizarTipoGastoFixo(tipoGastoFixo, idTipoGastoFixo);
    }
    
}
