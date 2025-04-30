package br.com.menchitech.ms_pdv_bms_restaurant.application.facade.produto;

import br.com.menchitech.ms_pdv_bms_restaurant.api.dto.ResponseDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.application.dto.produto.ProdutoRequestDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.application.facade.CrudFacade;
import br.com.menchitech.ms_pdv_bms_restaurant.application.mapper.ProdutoApplicationMapper;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.service.produto.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ProdutoFacadeImpl implements ProdutoFacade {

    private ProdutoService produtoService;

    @Override
    public ResponseDTO list() {
        var produtosVo = this.produtoService.list();

        var produtosDTO = ProdutoApplicationMapper.INSTANCE.toRESVOList(produtosVo);

        return ResponseDTO.builder()
            .data(produtosDTO)
            .message("Produtos listados com sucesso.")
            .status("SUCCESS")
            .build();
    }

    @Override
    public ResponseDTO findById(String id) {
        var produtoVO = this.produtoService.findById(id);

        var produtoDTO = ProdutoApplicationMapper.INSTANCE.toRES(produtoVO);

        return ResponseDTO.builder()
            .data(produtoDTO)
            .message("Produto encontrado com sucesso.")
            .status("SUCCESS")
            .build();
    }

    @Override
    public ResponseDTO create(ProdutoRequestDTO produtoRequestDTO) {
        var produtoVO = this.produtoService.create(
            ProdutoApplicationMapper.INSTANCE.toVO(produtoRequestDTO)
        );

        return ResponseDTO.builder()
            .data(ProdutoApplicationMapper.INSTANCE.toRES(produtoVO))
            .message("Produto criado com sucesso.")
            .status("SUCCESS")
            .build();
    }

    @Override
    public void deleteById(String id) {
        this.produtoService.delete(id);
    }
}
