package br.com.nordestech.usuario.domain.service.gasto;

import br.com.nordestech.usuario.domain.model.Cartao;
import br.com.nordestech.usuario.domain.model.Dinheiro;
import br.com.nordestech.usuario.domain.model.Gasto;
import br.com.nordestech.usuario.domain.model.Pix;
import br.com.nordestech.usuario.domain.model.abstracts.Pagamento;
import br.com.nordestech.usuario.domain.model.enums.TipoCartao;
import br.com.nordestech.usuario.domain.repository.GastoRepository;
import br.com.nordestech.usuario.domain.repository.abstracts.PagamentoRepository;
import br.com.nordestech.usuario.domain.service.banco.AtualizarBancoUseCase;
import br.com.nordestech.usuario.domain.service.cartao.AtualizarCartaoUseCase;
import br.com.nordestech.usuario.domain.service.dinheiro.AtualizarDinheiroUseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastrarGastoUseCase {

    private final GastoRepository repository;
    private final PagamentoRepository pagamentoRepository;
    private final AtualizarDinheiroUseCase atualizarDinheiroUseCase;
    private final AtualizarBancoUseCase atualizarBancoUseCase;
    private final AtualizarCartaoUseCase atualizarCartaoUseCase;

    @Transactional
    public Gasto execute(Gasto gasto) {

        Pagamento pagamento = pagamentoRepository.buscarPagamentoPorId(gasto.getPagamentoId());

        if (pagamento instanceof Dinheiro dinheiro) {
            atualizarDinheiroUseCase.debitarSaldo(gasto.getValor(), dinheiro.getId());
        }

        if (pagamento instanceof Pix pix) {
            atualizarBancoUseCase.debitarSaldo(gasto.getValor(), pix.getBancoId());
        }

        if (pagamento instanceof Cartao cartao) {
            if (cartao.getTipoCartao().equals(TipoCartao.DEBITO)) {
                atualizarBancoUseCase.debitarSaldo(gasto.getValor(), cartao.getBancoId());
            }
            if (cartao.getTipoCartao().equals(TipoCartao.CREDITO)) {
                atualizarCartaoUseCase.debitarLimiteDisponivel(gasto.getValor(), cartao.getId());
            }
        }

        return repository.salvar(gasto);
    }

}
