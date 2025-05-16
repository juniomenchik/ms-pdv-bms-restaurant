package br.com.menchitech.ms_pdv_bms_restaurant.domain.mapper;

import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.estoque.EstoqueResultVO;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.estoque.EstoqueVO;
import br.com.menchitech.ms_pdv_bms_restaurant.persistence.entity.CategoriaProdutoPersistenceEntity;
import br.com.menchitech.ms_pdv_bms_restaurant.persistence.entity.EstoquePersistenceEntity;
import br.com.menchitech.ms_pdv_bms_restaurant.persistence.entity.ProdutoPersistenceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EstoqueDomainMapper extends MapperDomainInterface<EstoqueVO, EstoquePersistenceEntity, EstoqueResultVO> {

    EstoqueDomainMapper INSTANCE = Mappers.getMapper(EstoqueDomainMapper.class);

    @Mapping(target = "produto", source = "savedProduct")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "quantidadeGuardada" , ignore = true)
    EstoquePersistenceEntity toEntity(EstoqueVO estoqueVO, ProdutoPersistenceEntity savedProduct);

    @Override
    @Mapping(target = "produto.categoria", source = "produto.categoria", qualifiedByName = "categoriaToName")
    EstoqueResultVO toRESVO(EstoquePersistenceEntity estoquePersistenceEntity);


    @Named( "categoriaToName")
    default String categoriaToName(CategoriaProdutoPersistenceEntity categoria) {
        return categoria != null ? categoria.getNome() : null;
    }

    default EstoquePersistenceEntity toEntityFromProduct(ProdutoPersistenceEntity prodEntity) {
        return EstoquePersistenceEntity.builder()
            .nomeEstoque(prodEntity.getNome())
            .produto(prodEntity)
            .quantidadeGuardada(0)
            .precoSomaVenda(prodEntity.getPrecoVenda())
            .precoSomaCusto(prodEntity.getPrecoCusto())
            .build();
    }

}
