package br.com.nordestech.usuario.infra.persistence.usuario.mapper;

import br.com.nordestech.usuario.domain.model.Usuario;
import br.com.nordestech.usuario.infra.persistence.usuario.UsuarioEntity;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario toUsuario(UsuarioEntity entity) {

        return Usuario.builder()
                .idUsuario(entity.getId())
                .email(entity.getEmail())
                .senha(entity.getSenha())
                .nomeCompleto(entity.getNomeCompleto())
                .cpf(entity.getCpf())
                .dataNascimento(entity.getDataNascimento())
                .perfis(entity.getPerfis())
                .build();
    }

}
