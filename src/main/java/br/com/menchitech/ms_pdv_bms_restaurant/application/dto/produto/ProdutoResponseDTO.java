package br.com.menchitech.ms_pdv_bms_restaurant.application.dto.produto;

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
public class ProdutoResponseDTO {

    private UUID id;

    private String codigoDeBarras;

    private String nome;

    private String categoria;

    private String descricao;

    private BigDecimal precoCusto;

    private BigDecimal precoVenda;

}
