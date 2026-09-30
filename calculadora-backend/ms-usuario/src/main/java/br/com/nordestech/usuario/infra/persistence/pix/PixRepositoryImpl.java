package br.com.nordestech.usuario.infra.persistence.pix;

import br.com.nordestech.usuario.domain.exceptions.ResourceNotFoundException;
import br.com.nordestech.usuario.domain.model.Pix;
import br.com.nordestech.usuario.domain.repository.PixRepository;
import br.com.nordestech.usuario.infra.persistence.banco.BancoEntity;
import br.com.nordestech.usuario.infra.persistence.pix.mapper.PixMapper;
import br.com.nordestech.usuario.infra.persistence.usuario.UsuarioEntity;
import br.com.nordestech.usuario.infra.utils.UsuarioBancoCheck;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PixRepositoryImpl implements PixRepository {

    private final SpringDataJpaPixRepository repository;
    private final UsuarioBancoCheck usuarioBancoCheck;
    private final PixMapper mapper;

    @Override
    public Pix salvar(Pix pix) {

        UsuarioEntity usuarioEntity = usuarioBancoCheck.checkUsuario(pix.getUsuarioId());
        BancoEntity bancoEntity = usuarioBancoCheck.checkBanco(pix.getBancoId());

        PixEntity pixEntity = new PixEntity(
                usuarioEntity,
                bancoEntity,
                pix.getChavePix()
        );

        return mapper.toPix(repository.save(pixEntity));
    }

    @Override
    public Pix atualizarSaldo(BigDecimal saldo, UUID idPix) {

        Optional<PixEntity> pixEntity = repository.findById(idPix);

        if (pixEntity.isEmpty()) {
            throw new ResourceNotFoundException("Pix", "id", idPix);
        }

        PixEntity pix = pixEntity.get();

        BigDecimal saldoAtual = pix.getBanco().getSaldo();

        pix.getBanco().setSaldo(saldoAtual.subtract(saldo));

        return mapper.toPix(repository.save(pix));
    }

    @Override
    public Set<Pix> buscarPixPorUsuarioId(UUID idUsuario) {
        return repository.findAllByUsuarioPix_Id(idUsuario).stream().map(mapper::toPix).collect(Collectors.toSet());
    }

    @Override
    public void deletarPixPorId(UUID idPix) {
        Optional<PixEntity> pixEntity = repository.findById(idPix);

        if (pixEntity.isEmpty()) {
            throw new ResourceNotFoundException("Pix", "id", idPix);
        }

        repository.delete(pixEntity.get());
    }
}
