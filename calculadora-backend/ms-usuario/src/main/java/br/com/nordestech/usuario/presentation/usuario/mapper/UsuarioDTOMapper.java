package br.com.nordestech.usuario.presentation.usuario.mapper;

import br.com.nordestech.usuario.domain.model.Usuario;
import br.com.nordestech.usuario.presentation.usuario.rest.request.UsuarioRequestDTO;
import br.com.nordestech.usuario.presentation.usuario.rest.request.UsuarioUpdateRequestDTO;
import br.com.nordestech.usuario.presentation.usuario.rest.response.UsuarioResponseDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class UsuarioDTOMapper {

    public Usuario toUsuario(UsuarioRequestDTO dto) {

        String dataNascimento = dto.dataNascimento();

        DateTimeFormatter formatadorEntrada = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate dataLocalDate = LocalDate.parse(dataNascimento, formatadorEntrada);

        return Usuario.builder()
                .email(dto.email())
                .senha(dto.senha())
                .nomeCompleto(dto.nomeCompleto())
                .cpf(dto.cpf())
                .dataNascimento(dataLocalDate)
                .build();
    }

    public Usuario toUsuario(UsuarioUpdateRequestDTO dto) {

        return Usuario.builder()
                .email(dto.email())
                .nomeCompleto(dto.nomeCompleto())
                .build();
    }

    public UsuarioResponseDTO toUsuarioResponseDTO(Usuario usuario) {

        return UsuarioResponseDTO.builder()
                .idUsuario(usuario.getIdUsuario())
                .email(usuario.getEmail())
                .nomeCompleto(usuario.getNomeCompleto())
                .cpf(usuario.getCpf())
                .dataNascimento(usuario.getDataNascimento())
                .perfis(usuario.getPerfis())
                .build();
    }

}
