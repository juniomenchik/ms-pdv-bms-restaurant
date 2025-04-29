package br.com.menchitech.ms_pdv_bms_restaurant.application.dto.estoque;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstoqueRequestDTO {

     @NonNull
     private String                      nomeEstoque;
     @NonNull
     private String                      produtoId;
     @NonNull
     private Double                      precoSomaVenda;
     @NonNull
     private Double                      precoSomaCusto;
}
