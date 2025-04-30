package br.com.menchitech.ms_pdv_bms_restaurant.domain.mapper;

import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.categoria.CategoriaProdutoResultVO;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.categoria.CategoriaProdutoVO;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.estoque.EstoqueResultVO;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.estoque.EstoqueVO;
import br.com.menchitech.ms_pdv_bms_restaurant.persistence.entity.CategoriaProdutoPersistenceEntity;
import br.com.menchitech.ms_pdv_bms_restaurant.persistence.entity.EstoquePersistenceEntity;
import br.com.menchitech.ms_pdv_bms_restaurant.persistence.entity.ProdutoPersistenceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoriaDomainMapper extends MapperDomainInterface<
    CategoriaProdutoVO,
    CategoriaProdutoPersistenceEntity,
    CategoriaProdutoResultVO> {

    CategoriaDomainMapper INSTANCE = Mappers.getMapper(CategoriaDomainMapper.class);

}
