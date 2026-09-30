package br.com.nordestech.usuario.domain.service.gastoFixo;

import br.com.nordestech.usuario.domain.model.Cartao;
import br.com.nordestech.usuario.domain.model.Dinheiro;
import br.com.nordestech.usuario.domain.model.GastoFixo;
import br.com.nordestech.usuario.domain.model.Pix;
import br.com.nordestech.usuario.domain.model.abstracts.Pagamento;
import br.com.nordestech.usuario.domain.model.enums.TipoCartao;
import br.com.nordestech.usuario.domain.repository.GastoFixoRepository;
import br.com.nordestech.usuario.domain.repository.abstracts.PagamentoRepository;
import br.com.nordestech.usuario.domain.service.banco.AtualizarBancoUseCase;
import br.com.nordestech.usuario.domain.service.cartao.AtualizarCartaoUseCase;
import br.com.nordestech.usuario.domain.service.dinheiro.AtualizarDinheiroUseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeletarGastoFixoUseCase {

    private final GastoFixoRepository repository;
    private final PagamentoRepository pagamentoRepository;
    private final AtualizarDinheiroUseCase atualizarDinheiroUseCase;
    private final AtualizarBancoUseCase atualizarBancoUseCase;
    private final AtualizarCartaoUseCase atualizarCartaoUseCase;

    @Transactional
    public void execute(UUID idGastoFixo) {

        GastoFixo gastoFixo = repository.buscarGastoFixoPorId(idGastoFixo);

        Pagamento pagamento = pagamentoRepository.buscarPagamentoPorId(gastoFixo.getPagamentoId());

        if (pagamento instanceof Dinheiro dinheiro) {
            atualizarDinheiroUseCase.creditarSaldo(gastoFixo.getValor(), dinheiro.getId());
        }

        if (pagamento instanceof Pix pix) {
            atualizarBancoUseCase.creditarSaldo(gastoFixo.getValor(), pix.getBancoId());
        }

        if (pagamento instanceof Cartao cartao) {
            if (cartao.getTipoCartao().equals(TipoCartao.DEBITO)) {
                atualizarBancoUseCase.creditarSaldo(gastoFixo.getValor(), cartao.getBancoId());
            }
            if (cartao.getTipoCartao().equals(TipoCartao.CREDITO)) {
                atualizarCartaoUseCase.creditarLimiteDisponivel(gastoFixo.getValor(), cartao.getId());
            }
        }

        repository.deletarGastoFixoPorId(idGastoFixo);
    }

}
