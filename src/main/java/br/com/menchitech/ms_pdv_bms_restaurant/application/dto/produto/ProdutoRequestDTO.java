package br.com.menchitech.ms_pdv_bms_restaurant.application.dto.produto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoRequestDTO {

    @NonNull
    private String codigoDeBarras;
    @NonNull
    private String nome;
    @NonNull
    private String categoria;
    @NonNull
    private String descricao;
    @NonNull
    private BigDecimal precoCusto;
    @NonNull
    private BigDecimal precoVenda;

}
