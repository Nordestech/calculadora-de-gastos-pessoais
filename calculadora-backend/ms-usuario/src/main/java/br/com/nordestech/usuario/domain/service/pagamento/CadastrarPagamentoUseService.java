package br.com.nordestech.usuario.domain.service.pagamento;

import br.com.nordestech.usuario.domain.model.Pagamento;
import br.com.nordestech.usuario.domain.repository.PagamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CadastrarPagamentoUseService {

    private final PagamentoRepository repository;

    public Pagamento execute(Pagamento pagamento, UUID idUsuario) {
        return repository.salvar(pagamento, idUsuario);
    }

}
