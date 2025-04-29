package br.com.menchitech.ms_pdv_bms_restaurant.domain.vo;

import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.estoque.EstoqueResultVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoVO {

    private UUID id;

    private String codigoDeBarras;

    private String nome;

    private CategoriaProdutoVO categoria;

    private String descricao;

    private BigDecimal precoCusto;

    private BigDecimal precoVenda;

    private EstoqueResultVO estoque;

}
