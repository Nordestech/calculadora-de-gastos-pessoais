package br.com.nordestech.usuario.infra.persistence.receita.mapper;

import br.com.nordestech.usuario.domain.model.Receita;
import br.com.nordestech.usuario.infra.persistence.banco.BancoEntity;
import br.com.nordestech.usuario.infra.persistence.receita.ReceitaEntity;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ReceitaMapper {

    public Receita toReceita(ReceitaEntity receitaEntity) {

        Set<BancoEntity> bancos = receitaEntity.getBancosReceita();
        Set<UUID> bancosId = new HashSet<>();

        if (!bancos.isEmpty()) {
            bancosId = bancos.stream().map(BancoEntity::getId).collect(Collectors.toSet());
        }

        return Receita.builder()
                .id(receitaEntity.getId())
                .usuarioId(receitaEntity.getUsuarioReceita().getId())
                .dinheiroId(receitaEntity.getDinheiroReceita().getId())
                .bancoId(bancosId)
                .build();
    }

}
