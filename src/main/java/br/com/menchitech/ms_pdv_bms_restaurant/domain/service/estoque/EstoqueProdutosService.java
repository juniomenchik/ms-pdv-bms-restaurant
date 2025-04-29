package br.com.menchitech.ms_pdv_bms_restaurant.domain.service.estoque;

import br.com.menchitech.ms_pdv_bms_restaurant.application.dto.estoque.EstoqueRequestDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.estoque.EstoqueResultVO;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.estoque.EstoqueVO;

import java.util.List;

public interface EstoqueProdutosService {
    List<EstoqueResultVO> listarEstoqueProdutos();

    EstoqueResultVO buscarEstoquePorId(String id);

    EstoqueResultVO cadastrarEstoque(EstoqueVO estoqueRequestDTO);

    void deletarEstoque(String id);
}
