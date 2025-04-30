package br.com.menchitech.ms_pdv_bms_restaurant.domain.service.categoria;

import br.com.menchitech.ms_pdv_bms_restaurant.application.exceptions.ObjectNotFoundCustomException;
import br.com.menchitech.ms_pdv_bms_restaurant.configuration.utils.ValidationGlobalUtils;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.mapper.CategoriaDomainMapper;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.mapper.EstoqueDomainMapper;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.categoria.CategoriaProdutoResultVO;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.categoria.CategoriaProdutoVO;
import br.com.menchitech.ms_pdv_bms_restaurant.persistence.entity.EstoquePersistenceEntity;
import br.com.menchitech.ms_pdv_bms_restaurant.persistence.entity.ProdutoPersistenceEntity;
import br.com.menchitech.ms_pdv_bms_restaurant.persistence.repository.categoria.CategoriaCustomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoriasServiceImpl implements CategoriasService {

    private CategoriaCustomRepository categoriasCustomRepository;

    @Override
    public List<CategoriaProdutoResultVO> list() {
        return CategoriaDomainMapper.INSTANCE.toRESVOList(this.categoriasCustomRepository.list());
    }

    @Override
    public CategoriaProdutoResultVO findById(String id) {
        UUID objId = ValidationGlobalUtils.toUUID(id);

        var categoria = this.categoriasCustomRepository.findById(objId);

        if (categoria.isPresent()) {
            return CategoriaDomainMapper.INSTANCE.toRESVO(categoria.get());
        } else {
            throw new ObjectNotFoundCustomException(
                id, EstoquePersistenceEntity.class.getName());
        }
    }

    @Override
    public CategoriaProdutoResultVO create(CategoriaProdutoVO categoriaVO) {

        var savedObj = this.categoriasCustomRepository.save(
            CategoriaDomainMapper.INSTANCE.toEntity(categoriaVO)
        );

        return CategoriaDomainMapper.INSTANCE.toRESVO(savedObj);
    }

    @Override
    public void delete(String id) {

        var categoria = this.categoriasCustomRepository.findById(ValidationGlobalUtils.toUUID(id));

        if (!categoria.isPresent()) {
            throw new ObjectNotFoundCustomException(id, CategoriaProdutoResultVO.class.getName());
        }

        this.categoriasCustomRepository.delete(ValidationGlobalUtils.toUUID(id));
    }
}
