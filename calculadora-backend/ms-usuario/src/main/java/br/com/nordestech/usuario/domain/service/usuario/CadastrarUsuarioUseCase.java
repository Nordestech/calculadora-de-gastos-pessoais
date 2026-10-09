package br.com.nordestech.usuario.domain.service.usuario;

import br.com.nordestech.usuario.domain.model.Usuario;
import br.com.nordestech.usuario.domain.model.enums.PerfilEnum;
import br.com.nordestech.usuario.domain.repository.UsuarioRepository;
import br.com.nordestech.usuario.port.output.dto.EmailHtmlRequest;
import br.com.nordestech.usuario.port.output.publisher.WelcomeEmailEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CadastrarUsuarioUseCase {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final WelcomeEmailEventPublisher eventPublisher;

    public Usuario execute(Usuario usuario) {

        String senhaHash = passwordEncoder.encode(usuario.getSenha());

        usuario.setSenha(senhaHash);

        Set<PerfilEnum> perfis = new HashSet<>();

        perfis.add(PerfilEnum.FREE_ACCOUNT);

        usuario.setPerfis(perfis);

        Usuario usuarioSalvo = repository.salvar(usuario);

        EmailHtmlRequest emailHtmlRequest = EmailHtmlRequest.builder()
                .to(usuario.getEmail())
                .nomeCompleto(usuario.getNomeCompleto())
                .subject(String.format("Seja bem-vindo, %s!", usuario.getNomeCompleto()))
                .build();

        eventPublisher.publishPaymentApprovedEvent(emailHtmlRequest);

        return usuarioSalvo;
    }

}
