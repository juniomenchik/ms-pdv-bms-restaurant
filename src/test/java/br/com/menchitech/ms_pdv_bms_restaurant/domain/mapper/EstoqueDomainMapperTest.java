package br.com.menchitech.ms_pdv_bms_restaurant.domain.mapper;

import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.estoque.EstoqueVO;
import br.com.menchitech.ms_pdv_bms_restaurant.persistence.entity.EstoquePersistenceEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EstoqueDomainMapperTest {

    @Test
    void toVO() {

        EstoqueVO vo = EstoqueVO.builder()
            .nomeEstoque("Estoque de Produtos")
            .build();

        EstoquePersistenceEntity entity = EstoqueDomainMapper.INSTANCE.toEntity(vo);

        Assertions.assertEquals(vo.getNomeEstoque(), entity.getNomeEstoque());
    }

}