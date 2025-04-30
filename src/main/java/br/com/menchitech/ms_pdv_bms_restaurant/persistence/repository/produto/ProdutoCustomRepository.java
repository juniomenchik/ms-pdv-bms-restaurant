package br.com.menchitech.ms_pdv_bms_restaurant.persistence.repository.produto;

import br.com.menchitech.ms_pdv_bms_restaurant.application.exceptions.ObjectNotFoundCustomException;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.categoria.CategoriaProdutoResultVO;
import br.com.menchitech.ms_pdv_bms_restaurant.persistence.entity.ProdutoPersistenceEntity;
import br.com.menchitech.ms_pdv_bms_restaurant.persistence.repository.BaseRepositoryInterface;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProdutoCustomRepository implements BaseRepositoryInterface<ProdutoPersistenceEntity, UUID> {

    private ProdutoPersistenceRepository produtoPersistenceRepository;

    @Override
    public List<ProdutoPersistenceEntity> list() {
        return this.produtoPersistenceRepository.findAll();
    }

    @Override
    public ProdutoPersistenceEntity save(ProdutoPersistenceEntity object) {
        return this.produtoPersistenceRepository.saveAndFlush(object);
    }

    @Override
    public ProdutoPersistenceEntity update(ProdutoPersistenceEntity object) {
        return this.produtoPersistenceRepository.saveAndFlush(object);
    }

    @Override
    public void delete(UUID object) {

        var objToBeDeleted = this.findById(object);

        if (objToBeDeleted.isEmpty()) {
            throw new ObjectNotFoundCustomException(String.valueOf(object), ProdutoPersistenceEntity.class.getName());
        }
        this.produtoPersistenceRepository.delete(objToBeDeleted.get());
    }

    @Override
    public Optional<ProdutoPersistenceEntity> findById(UUID id) {
        return this.produtoPersistenceRepository.findById(id);
    }
}
