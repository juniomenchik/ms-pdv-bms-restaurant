package br.com.menchitech.ms_pdv_bms_restaurant.persistence.repository.estoque;

import br.com.menchitech.ms_pdv_bms_restaurant.persistence.entity.EstoquePersistenceEntity;
import br.com.menchitech.ms_pdv_bms_restaurant.persistence.repository.BaseRepositoryInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EstoqueCustomRepository implements BaseRepositoryInterface<EstoquePersistenceEntity, UUID> {

    private EstoquePersistenceRepository estoquePersistenceRepository;

    @Override
    public List<EstoquePersistenceEntity> list() {
        return this.estoquePersistenceRepository.findAll();
    }

    @Override
    public EstoquePersistenceEntity save(EstoquePersistenceEntity object) {

        return this.estoquePersistenceRepository.saveAndFlush(object);
    }

    @Override
    public EstoquePersistenceEntity update(EstoquePersistenceEntity object) {

        return this.estoquePersistenceRepository.saveAndFlush(object);
    }

    @Override
    public void delete(UUID uuid) {

        this.estoquePersistenceRepository.deleteById(uuid);
    }

    @Override
    public Optional<EstoquePersistenceEntity> findById(UUID id) {

        return this.estoquePersistenceRepository.findById(id);
    }
}
