package br.com.menchitech.ms_pdv_bms_restaurant.domain.mapper;

import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.estoque.EstoqueVO;
import br.com.menchitech.ms_pdv_bms_restaurant.persistence.entity.EstoquePersistenceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EstoqueDomainMapper extends MapperInterfaceVOtoEntity<EstoqueVO, EstoquePersistenceEntity> {

    EstoqueDomainMapper INSTANCE = Mappers.getMapper(EstoqueDomainMapper.class);

}
