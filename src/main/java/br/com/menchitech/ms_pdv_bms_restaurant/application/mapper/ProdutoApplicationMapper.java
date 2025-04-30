package br.com.menchitech.ms_pdv_bms_restaurant.application.mapper;

import br.com.menchitech.ms_pdv_bms_restaurant.application.dto.produto.ProdutoRequestDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.application.dto.produto.ProdutoResponseDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.produto.ProdutoResultVO;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.produto.ProdutoVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProdutoApplicationMapper extends MapperApplicationInterface<
    ProdutoRequestDTO, ProdutoResponseDTO,
    ProdutoVO, ProdutoResultVO> {

    ProdutoApplicationMapper INSTANCE = Mappers.getMapper(ProdutoApplicationMapper.class);

}
