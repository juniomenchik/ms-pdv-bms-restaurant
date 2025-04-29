package br.com.menchitech.ms_pdv_bms_restaurant.application.mapper;

import br.com.menchitech.ms_pdv_bms_restaurant.application.dto.estoque.EstoqueRequestDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.application.dto.estoque.EstoqueResponseDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.estoque.EstoqueResultVO;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.estoque.EstoqueVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EstoqueApplicationMapper extends MapperApplicationInterface<
    EstoqueRequestDTO, EstoqueResponseDTO,
    EstoqueVO, EstoqueResultVO> {

    EstoqueApplicationMapper INSTANCE = Mappers.getMapper(EstoqueApplicationMapper.class);

}
