package br.com.menchitech.ms_pdv_bms_restaurant.domain.service.estoque;

import br.com.menchitech.ms_pdv_bms_restaurant.persistence.repository.estoque.EstoqueProdutoCustomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class EstoqueProdutosServiceImpl implements EstoqueProdutosService {

    private EstoqueProdutoCustomRepository estoqueProdutoCustomRepository;


}
