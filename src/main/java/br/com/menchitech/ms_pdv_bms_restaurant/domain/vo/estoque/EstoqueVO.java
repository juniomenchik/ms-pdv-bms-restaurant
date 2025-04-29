package br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.estoque;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstoqueVO {

     private String nomeEstoque;

     private String produtoId;

     private Double precoSomaVenda;

     private Double precoSomaCusto;
}
