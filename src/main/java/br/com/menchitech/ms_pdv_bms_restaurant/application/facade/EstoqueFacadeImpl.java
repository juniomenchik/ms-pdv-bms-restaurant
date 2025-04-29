package br.com.menchitech.ms_pdv_bms_restaurant.application.facade;

import br.com.menchitech.ms_pdv_bms_restaurant.api.dto.ResponseDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.application.dto.estoque.EstoqueRequestDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.application.mapper.EstoqueApplicationMapper;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.service.estoque.EstoqueProdutosService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EstoqueFacadeImpl implements EstoqueFacade {

    private EstoqueProdutosService estoqueProdutosService;

    @Override
    public ResponseDTO listarEstoqueProdutos() {

        var estoquesVo = this.estoqueProdutosService.listarEstoqueProdutos();

        var estoquesDTO = EstoqueApplicationMapper.INSTANCE.toRESVOList(estoquesVo);

        return ResponseDTO.builder()
            .data(estoquesDTO)
            .message("Estoque de Produtos listado com sucesso.")
            .status("SUCCESS")
            .build();
    }

    @Override
    public ResponseDTO buscarEstoquePorId(String id) {

        var estoqueVO = this.estoqueProdutosService.buscarEstoquePorId(id);

        var estoqueDTO = EstoqueApplicationMapper.INSTANCE.toRES(estoqueVO);

        return ResponseDTO.builder()
            .data(estoqueDTO)
            .message("Estoque encontrado com sucesso.")
            .status("SUCCESS")
            .build();
    }

    @Override
    public ResponseDTO cadastrarEstoque(EstoqueRequestDTO estoqueRequestDTO) {

        var estoqueVO = this.estoqueProdutosService.cadastrarEstoque(
            EstoqueApplicationMapper.INSTANCE.toVO(estoqueRequestDTO)
        );

        return ResponseDTO.builder()
            .data(EstoqueApplicationMapper.INSTANCE.toRES(estoqueVO))
            .message("Estoque criado com sucesso.")
            .status("SUCCESS")
            .build();
    }

    @Override
    public void deletarEstoque(String id) {
        this.estoqueProdutosService.deletarEstoque(id);
    }
}
