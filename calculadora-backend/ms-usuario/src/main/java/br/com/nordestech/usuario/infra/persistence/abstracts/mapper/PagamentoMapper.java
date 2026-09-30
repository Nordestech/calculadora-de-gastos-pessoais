package br.com.nordestech.usuario.infra.persistence.abstracts.mapper;

import br.com.nordestech.usuario.domain.exceptions.ResourceBadRequestException;
import br.com.nordestech.usuario.domain.model.abstracts.Pagamento;
import br.com.nordestech.usuario.infra.persistence.abstracts.PagamentoEntity;
import br.com.nordestech.usuario.infra.persistence.cartao.CartaoEntity;
import br.com.nordestech.usuario.infra.persistence.cartao.mapper.CartaoMapper;
import br.com.nordestech.usuario.infra.persistence.dinheiro.DinheiroEntity;
import br.com.nordestech.usuario.infra.persistence.dinheiro.mapper.DinheiroMapper;
import br.com.nordestech.usuario.infra.persistence.pix.PixEntity;
import br.com.nordestech.usuario.infra.persistence.pix.mapper.PixMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PagamentoMapper {

    private final PixMapper pixMapper;
    private final CartaoMapper cartaoMapper;
    private final DinheiroMapper dinheiroMapper;

    public Pagamento toPagamento(PagamentoEntity entity) {

        if (entity instanceof PixEntity pixEntity) {
            return pixMapper.toPix(pixEntity);
        }

        if (entity instanceof CartaoEntity cartaoEntity) {
            return cartaoMapper.toCartao(cartaoEntity);
        }

        if (entity instanceof DinheiroEntity dinheiroEntity) {
            return dinheiroMapper.toDinheiro(dinheiroEntity);
        }

        throw new ResourceBadRequestException("Pagamento", "pagamento", entity);
    }
}
