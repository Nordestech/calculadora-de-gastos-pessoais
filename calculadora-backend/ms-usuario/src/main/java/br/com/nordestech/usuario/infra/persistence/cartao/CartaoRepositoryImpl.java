package br.com.nordestech.usuario.infra.persistence.cartao;

import br.com.nordestech.usuario.domain.exceptions.ResourceNotFoundException;
import br.com.nordestech.usuario.domain.model.Cartao;
import br.com.nordestech.usuario.domain.repository.CartaoRepository;
import br.com.nordestech.usuario.infra.persistence.banco.BancoEntity;
import br.com.nordestech.usuario.infra.persistence.cartao.mapper.CartaoMapper;
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
public class CartaoRepositoryImpl implements CartaoRepository {

    private final SpringDataJpaCartaoRepository repository;
    private final CartaoMapper mapper;
    private final UsuarioBancoCheck usuarioBancoCheck;

    @Override
    public Cartao salvar(Cartao cartao) {

        UsuarioEntity usuarioEntity = usuarioBancoCheck.checkUsuario(cartao.getUsuarioId());
        BancoEntity bancoEntity = usuarioBancoCheck.checkBanco(cartao.getBancoId());

        CartaoEntity cartaoEntity = new CartaoEntity(
                cartao.getNomeCartao(),
                cartao.getTiposCartao(),
                cartao.getLimiteDisponivel(),
                cartao.getDiaVencimento(),
                bancoEntity,
                usuarioEntity
        );

        return mapper.toCartao(repository.save(cartaoEntity));
    }

    @Override
    public Cartao atualizarLimiteDisponivel(BigDecimal limiteDisponivel, UUID idCartao) {
        Optional<CartaoEntity> cartaoEntity = repository.findById(idCartao);

        if (cartaoEntity.isEmpty()) {
            throw new ResourceNotFoundException("Cartao", "id", idCartao);
        }

        CartaoEntity cartao = cartaoEntity.get();

        cartao.setLimiteDisponivel(limiteDisponivel);

        return mapper.toCartao(repository.save(cartao));
    }

    @Override
    public Cartao atualizarSaldo(BigDecimal saldo, UUID idCartao) {

        Optional<CartaoEntity> cartaoEntity = repository.findById(idCartao);

        if (cartaoEntity.isEmpty()) {
            throw new ResourceNotFoundException("Cartao", "id", idCartao);
        }

        CartaoEntity cartao = cartaoEntity.get();

        BigDecimal saldoAtual = cartao.getBancoCartoes().getSaldo();

        cartao.getBancoCartoes().setSaldo(saldoAtual.subtract(saldo));

        return mapper.toCartao(repository.save(cartao));
    }

    @Override
    public Set<Cartao> buscarCartoesPorUsuarioId(UUID idUsuario) {
        return repository.findAllByUsuarioCartoes_Id(idUsuario).stream().map(mapper::toCartao).collect(Collectors.toSet());
    }

    @Override
    public void deletarCartaoPorId(UUID idCartao) {
        Optional<CartaoEntity> cartaoEntity = repository.findById(idCartao);

        if (cartaoEntity.isEmpty()) {
            throw new ResourceNotFoundException("Cartao", "id", idCartao);
        }

        repository.delete(cartaoEntity.get());
    }
}
