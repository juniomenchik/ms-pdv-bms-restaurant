package br.com.menchitech.ms_pdv_bms_restaurant.application.facade;

import br.com.menchitech.ms_pdv_bms_restaurant.api.dto.ResponseDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.application.dto.estoque.EstoqueRequestDTO;

public interface EstoqueFacade {


    ResponseDTO listarEstoqueProdutos();

    ResponseDTO buscarEstoquePorId(String id);

    ResponseDTO cadastrarEstoque(EstoqueRequestDTO estoqueRequestDTO);

    void deletarEstoque(String id);
}
