package br.com.menchitech.ms_pdv_bms_restaurant.application.dto.categoria;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaProdutoRequestDTO {

    @NonNull
    private String nome;
}
