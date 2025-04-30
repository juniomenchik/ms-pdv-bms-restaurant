package br.com.menchitech.ms_pdv_bms_restaurant.application.mapper;

import br.com.menchitech.ms_pdv_bms_restaurant.application.dto.categoria.CategoriaProdutoRequestDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.application.dto.categoria.CategoriaProdutoResponseDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.application.dto.estoque.EstoqueRequestDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.application.dto.estoque.EstoqueResponseDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.categoria.CategoriaProdutoResultVO;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.categoria.CategoriaProdutoVO;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.estoque.EstoqueResultVO;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.estoque.EstoqueVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoriaApplicationMapper extends MapperApplicationInterface<
    CategoriaProdutoRequestDTO, CategoriaProdutoResponseDTO,
    CategoriaProdutoVO, CategoriaProdutoResultVO> {

    CategoriaApplicationMapper INSTANCE = Mappers.getMapper(CategoriaApplicationMapper.class);

}
