package br.com.menchitech.ms_pdv_bms_restaurant.domain.mapper;

import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.estoque.EstoqueResultVO;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.estoque.EstoqueVO;
import br.com.menchitech.ms_pdv_bms_restaurant.persistence.entity.EstoquePersistenceEntity;
import br.com.menchitech.ms_pdv_bms_restaurant.persistence.entity.ProdutoPersistenceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EstoqueDomainMapper extends MapperDomainInterface<EstoqueVO, EstoquePersistenceEntity, EstoqueResultVO> {

    EstoqueDomainMapper INSTANCE = Mappers.getMapper(EstoqueDomainMapper.class);

    @Mapping(target = "produto", source = "savedProduct")
    EstoquePersistenceEntity toEntity(EstoqueVO estoqueVO, ProdutoPersistenceEntity savedProduct);

}
