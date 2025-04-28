package br.com.menchitech.ms_pdv_bms_restaurant.application.facade;

import br.com.menchitech.ms_pdv_bms_restaurant.domain.service.estoque.EstoqueProdutosService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EstoqueProdutosFacadeImpl implements EstoqueProdutosFacade {

    private EstoqueProdutosService estoqueProdutosService;

}
