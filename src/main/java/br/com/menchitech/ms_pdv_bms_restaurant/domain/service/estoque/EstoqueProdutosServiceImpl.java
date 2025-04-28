package br.com.menchitech.ms_pdv_bms_restaurant.domain.service.estoque;

import br.com.menchitech.ms_pdv_bms_restaurant.domain.mapper.EstoqueDomainMapper;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.estoque.EstoqueVO;
import br.com.menchitech.ms_pdv_bms_restaurant.persistence.repository.estoque.EstoqueProdutoCustomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class EstoqueProdutosServiceImpl implements EstoqueProdutosService {

    private EstoqueProdutoCustomRepository estoqueProdutoCustomRepository;

    @Override
    public List<EstoqueVO> listarEstoqueProdutos() {

        var estoques = estoqueProdutoCustomRepository.list();

        return EstoqueDomainMapper.INSTANCE.toVOList(estoques);
    }
}
