package br.com.nordestech.usuario.infra.persistence.receita;

import br.com.nordestech.usuario.domain.exceptions.dinheiro.DinheiroNotFoundException;
import br.com.nordestech.usuario.domain.exceptions.receita.ReceitaNotFoundException;
import br.com.nordestech.usuario.domain.model.Receita;
import br.com.nordestech.usuario.domain.repository.ReceitaRepository;
import br.com.nordestech.usuario.infra.persistence.dinheiro.DinheiroEntity;
import br.com.nordestech.usuario.infra.persistence.dinheiro.SpringDataJpaDinheiroRepository;
import br.com.nordestech.usuario.infra.persistence.receita.mapper.ReceitaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ReceitaRepositoryImpl implements ReceitaRepository {

    public ReceitaMapper mapper;
    public SpringDataJpaReceitaRepository repository;
    public SpringDataJpaDinheiroRepository dinheiroRepository;

    @Override
    public Receita salvar(Receita receita, UUID idUsuario) {
        Optional<ReceitaEntity> receitaEntity = repository.findReceitaEntityByUsuarioReceita_Id(idUsuario);

        if (receitaEntity.isEmpty()) {
            throw new ReceitaNotFoundException("Nenhuma receita encontrada para o idUsuario: " + idUsuario);
        }

        ReceitaEntity foundReceitaEntity = receitaEntity.get();

        Optional<DinheiroEntity> dinheiroEntity = dinheiroRepository.findById(receita.getDinheiroId());

        if (dinheiroEntity.isEmpty()) {
            throw new DinheiroNotFoundException("Nenhum dinheiro encontrada para o idDinheiro: " + receita.getDinheiroId());
        }

        foundReceitaEntity.getDinheiroReceita().setValor(dinheiroEntity.get().getValor());

        return mapper.toReceita(savedReceitaEntity);
    }

    @Override
    public Receita buscarPorId(UUID id) {
        Optional<ReceitaEntity> receitaEntity = repository.findById(id);

        if (receitaEntity.isEmpty()) {
            throw new ReceitaNotFoundException("Nenhuma receita encontrada para o id: " + id);
        }

        return mapper.toReceita(receitaEntity.get());
    }

    @Override
    public void deletarReceitaPorId(UUID id) {
        Optional<ReceitaEntity> receitaEntity = repository.findById(id);

        if (receitaEntity.isEmpty()) {
            throw new ReceitaNotFoundException("Nenhuma receita encontrada para o id: " + id);
        }

        repository.deleteById(id);
    }
}
