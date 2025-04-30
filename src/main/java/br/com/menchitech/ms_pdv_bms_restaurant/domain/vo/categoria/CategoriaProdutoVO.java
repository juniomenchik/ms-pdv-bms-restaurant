package br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.categoria;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaProdutoVO {

    private UUID id;

    private String nome;
}
