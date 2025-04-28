package br.com.menchitech.ms_pdv_bms_restaurant.domain.service.estoque;

import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.estoque.EstoqueVO;

import java.util.List;

public interface EstoqueProdutosService {
    List<EstoqueVO> listarEstoqueProdutos();
}
