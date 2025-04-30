package br.com.menchitech.ms_pdv_bms_restaurant.api.controller;

import br.com.menchitech.ms_pdv_bms_restaurant.api.controller.openapi.ProdutoControllerOpenApi;
import br.com.menchitech.ms_pdv_bms_restaurant.api.dto.ResponseDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.application.dto.estoque.EstoqueRequestDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.application.dto.produto.ProdutoRequestDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.application.facade.produto.ProdutoFacade;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/produto")
@AllArgsConstructor
public class ProdutoController implements ProdutoControllerOpenApi {

    private ProdutoFacade produtoFacade;

    @Override
    public ResponseDTO listarProdutos() {
        return produtoFacade.list();
    }

    @Override
    public ResponseDTO buscarProdutoPorId(@NonNull String id) {
        return produtoFacade.findById(id);
    }

    @Override
    public ResponseDTO cadastrarProduto(ProdutoRequestDTO produtoRequestDTO) {
        return produtoFacade.create(produtoRequestDTO);
    }

    @Override
    public void deletarProduto(@NonNull String id) {
        this.produtoFacade.deleteById(id);
    }
}
