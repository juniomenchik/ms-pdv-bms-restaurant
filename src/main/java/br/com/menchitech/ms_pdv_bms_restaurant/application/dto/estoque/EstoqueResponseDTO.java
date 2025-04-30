package br.com.menchitech.ms_pdv_bms_restaurant.application.dto.estoque;

import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.produto.ProdutoVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstoqueResponseDTO {

     private UUID id;

     private String                      nomeEstoque;

     private ProdutoVO produto;

     private Integer                     quantidadeGuardada;

     private Double                      precoSomaVenda;

     private Double                      precoSomaCusto;

}
