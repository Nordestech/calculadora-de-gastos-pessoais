package br.com.nordestech.usuario.infra.persistence.cartao.mapper;

import br.com.nordestech.usuario.domain.model.Cartao;
import br.com.nordestech.usuario.infra.persistence.cartao.CartaoEntity;
import org.springframework.stereotype.Component;

@Component
public class CartaoMapper {

    public Cartao toCartao(CartaoEntity entity) {

        return Cartao.builder()
                .id(entity.getId())
                .usuarioId(entity.getUsuarioCartoes().getId())
                .nomeCartao(entity.getNomeCartao())
                .bancoId(entity.getBancoCartoes().getId())
                .tipoCartao(entity.getTipoCartao())
                .limiteDisponivel(entity.getLimiteDisponivel())
                .diaVencimento(entity.getDiaVencimento())
                .build();
    }

}
