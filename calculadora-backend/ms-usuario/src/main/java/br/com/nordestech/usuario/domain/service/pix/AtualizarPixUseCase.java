package br.com.nordestech.usuario.domain.service.pix;

import br.com.nordestech.usuario.domain.model.Pix;
import br.com.nordestech.usuario.domain.repository.PixRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AtualizarPixUseCase {

    private final PixRepository repository;

    public Pix atualizarSaldo(BigDecimal saldo, UUID idPix){
        return repository.atualizarSaldo(saldo, idPix);
    }

}
