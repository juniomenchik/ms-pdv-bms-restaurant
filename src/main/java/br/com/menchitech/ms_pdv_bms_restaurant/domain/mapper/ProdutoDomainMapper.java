package br.com.menchitech.ms_pdv_bms_restaurant.domain.mapper;

import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.produto.ProdutoResultVO;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.produto.ProdutoVO;
import br.com.menchitech.ms_pdv_bms_restaurant.persistence.entity.CategoriaProdutoPersistenceEntity;
import br.com.menchitech.ms_pdv_bms_restaurant.persistence.entity.ProdutoPersistenceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProdutoDomainMapper extends MapperDomainInterface<
    ProdutoVO,
    ProdutoPersistenceEntity,
    ProdutoResultVO> {

    ProdutoDomainMapper INSTANCE = Mappers.getMapper(ProdutoDomainMapper.class);

    @Override
    @Mapping(target = "categoria", ignore = true)
    ProdutoPersistenceEntity toEntity(ProdutoVO produtoVO);

    @Override
    @Mapping(target = "categoria", source = "produtoPersistenceEntity.categoria", qualifiedByName = "categoriaToName")
    ProdutoResultVO toRESVO(ProdutoPersistenceEntity produtoPersistenceEntity);

    @Mapping(target = "categoria", source = "categoriaProdutoPersistenceEntity")
    @Mapping(target = "nome", source = "produtoVO.nome")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "estoque" , ignore = true)
    ProdutoPersistenceEntity toEntity(ProdutoVO produtoVO, CategoriaProdutoPersistenceEntity categoriaProdutoPersistenceEntity);

    @Named( "categoriaToName")
    default String categoriaToName(CategoriaProdutoPersistenceEntity categoria) {
        return categoria != null ? categoria.getNome() : null;
    }
}
