package br.com.menchitech.ms_pdv_bms_restaurant.application.facade;

import br.com.menchitech.ms_pdv_bms_restaurant.api.dto.ResponseDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.application.mapper.EstoqueApplicationMapper;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.service.estoque.EstoqueProdutosService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EstoqueProdutosFacadeImpl implements EstoqueProdutosFacade {

    private EstoqueProdutosService estoqueProdutosService;

    @Override
    public ResponseDTO listarEstoqueProdutos() {

        var estoquesVo = this.estoqueProdutosService.listarEstoqueProdutos();

        var estoquesDTO = EstoqueApplicationMapper.INSTANCE.toDTOList(estoquesVo);

        return ResponseDTO.builder()
            .data(estoquesDTO)
            .message("Estoque de Produtos listado com sucesso.")
            .status("SUCCESS")
            .build();
    }
}
