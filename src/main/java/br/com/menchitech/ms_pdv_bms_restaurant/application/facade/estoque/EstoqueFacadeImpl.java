package br.com.menchitech.ms_pdv_bms_restaurant.application.facade.estoque;

import br.com.menchitech.ms_pdv_bms_restaurant.api.dto.ResponseDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.application.dto.estoque.EstoqueRequestDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.application.mapper.EstoqueApplicationMapper;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.service.estoque.EstoqueProdutosService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EstoqueFacadeImpl implements EstoqueFacade {
    @Override
    public ResponseDTO create(EstoqueRequestDTO objetoDTO) {
        //nao disponivel
        return null;
    }

    @Override
    public void deleteById(String id) {
        //nao disponivel
    }

    private EstoqueProdutosService estoqueProdutosService;

    @Override
    public ResponseDTO list() {

        var estoquesVo = this.estoqueProdutosService.list();

        var estoquesDTO = EstoqueApplicationMapper.INSTANCE.toRESVOList(estoquesVo);

        return ResponseDTO.builder()
            .data(estoquesDTO)
            .message("Estoque de Produtos listado com sucesso.")
            .status("SUCCESS")
            .build();
    }

    @Override
    public ResponseDTO findById(String id) {

        var estoqueVO = this.estoqueProdutosService.findById(id);

        var estoqueDTO = EstoqueApplicationMapper.INSTANCE.toRES(estoqueVO);

        return ResponseDTO.builder()
            .data(estoqueDTO)
            .message("Estoque encontrado com sucesso.")
            .status("SUCCESS")
            .build();
    }

}
