package br.com.menchitech.ms_pdv_bms_restaurant.persistence.repository.categoria;

import br.com.menchitech.ms_pdv_bms_restaurant.persistence.entity.CategoriaProdutoPersistenceEntity;
import br.com.menchitech.ms_pdv_bms_restaurant.persistence.repository.BaseRepositoryInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoriaCustomRepository implements BaseRepositoryInterface<CategoriaProdutoPersistenceEntity, UUID> {

    private final CategoriaPersistenceRepository categoriaPersistenceRepository;

    @Override
    public List<CategoriaProdutoPersistenceEntity> list() {
        return this.categoriaPersistenceRepository.findAll();
    }

    @Override
    public CategoriaProdutoPersistenceEntity save(CategoriaProdutoPersistenceEntity object) {
        return this.categoriaPersistenceRepository.saveAndFlush(object);
    }

    @Override
    public CategoriaProdutoPersistenceEntity update(CategoriaProdutoPersistenceEntity object) {
        return this.categoriaPersistenceRepository.saveAndFlush(object);
    }

    @Override
    public void delete(UUID object) {
        this.categoriaPersistenceRepository.deleteById(object);
    }

    @Override
    public Optional<CategoriaProdutoPersistenceEntity> findById(UUID id) {
        return this.categoriaPersistenceRepository.findById(id);
    }

    public Optional<CategoriaProdutoPersistenceEntity> findByCategoriaName(String categoria) {
        return this.categoriaPersistenceRepository.findByName(categoria);
    }
}
