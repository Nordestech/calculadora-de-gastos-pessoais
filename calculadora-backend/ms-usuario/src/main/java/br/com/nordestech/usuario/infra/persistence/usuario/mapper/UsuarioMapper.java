package br.com.nordestech.usuario.infra.persistence.usuario.mapper;

import br.com.nordestech.usuario.domain.model.Usuario;
import br.com.nordestech.usuario.infra.persistence.cartao.CartaoEntity;
import br.com.nordestech.usuario.infra.persistence.despesa.DespesaEntity;
import br.com.nordestech.usuario.infra.persistence.usuario.UsuarioEntity;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class UsuarioMapper {

    public Usuario toUsuario(UsuarioEntity usuarioEntity) {

        Set<DespesaEntity> despesasUsuario = usuarioEntity.getDespesasUsuario();
        Set<CartaoEntity> cartoesUsuario = usuarioEntity.getCartoesUsuario();
        Set<UUID> despesasId = new HashSet<>();
        Set<UUID> cartoesId = new HashSet<>();

        if (!despesasUsuario.isEmpty()) {
            despesasId = despesasUsuario.stream().map(DespesaEntity::getId).collect(Collectors.toSet());
        }
        if (!cartoesUsuario.isEmpty()) {
            cartoesId = cartoesUsuario.stream().map(CartaoEntity::getId).collect(Collectors.toSet());
        }

        return Usuario.builder()
                .id(usuarioEntity.getId())
                .email(usuarioEntity.getEmail())
                .senha(usuarioEntity.getSenha())
                .nomeCompleto(usuarioEntity.getNomeCompleto())
                .dataNascimento(usuarioEntity.getDataNascimento())
                .receitaId(usuarioEntity.getReceitaUsuario().getId())
                .despesasId(despesasId)
                .cartoesId(cartoesId)
                .perfis(usuarioEntity.getPerfis())
                .build();
    }

}
