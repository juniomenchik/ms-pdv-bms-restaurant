package br.com.menchitech.ms_pdv_bms_restaurant.application.mapper;

import br.com.menchitech.ms_pdv_bms_restaurant.application.dto.estoque.EstoqueResponseDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.estoque.EstoqueVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EstoqueApplicationMapper extends MapperInterfaceDTOtoVO<EstoqueVO,EstoqueResponseDTO> {

    EstoqueApplicationMapper INSTANCE = Mappers.getMapper(EstoqueApplicationMapper.class);

}
