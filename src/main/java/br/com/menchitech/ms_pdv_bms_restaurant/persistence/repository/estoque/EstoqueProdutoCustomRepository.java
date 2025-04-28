package br.com.menchitech.ms_pdv_bms_restaurant.persistence.repository.estoque;

import br.com.menchitech.ms_pdv_bms_restaurant.persistence.entity.EstoquePersistenceEntity;
import br.com.menchitech.ms_pdv_bms_restaurant.persistence.repository.BaseRepositoryInterface;
import lombok.AllArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EstoqueProdutoCustomRepository implements BaseRepositoryInterface<EstoquePersistenceEntity> {

    private EstoquePersistenceRepository estoquePersistenceRepository;

    @Override
    public List<EstoquePersistenceEntity> list() {
        return this.estoquePersistenceRepository.findAll();
    }

    @Override
    public void save(EstoquePersistenceEntity object) {

        this.estoquePersistenceRepository.save(object);
    }

    @Override
    public void update(EstoquePersistenceEntity object) {

        this.estoquePersistenceRepository.save(object);
    }

    @Override
    public void delete(EstoquePersistenceEntity object) {

        this.estoquePersistenceRepository.delete(object);
    }

    @Override
    public Optional<EstoquePersistenceEntity> findById(Long id) {

        Optional<EstoquePersistenceEntity> estoque = this.estoquePersistenceRepository.findById(id);

        if (estoque.isPresent()) {
            return estoque;
        } else {
            throw new ObjectNotFoundException(id, EstoquePersistenceEntity.class.getName());
        }
    }
}
