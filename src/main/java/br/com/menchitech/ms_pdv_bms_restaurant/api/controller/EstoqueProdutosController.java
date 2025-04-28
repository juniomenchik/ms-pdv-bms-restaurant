package br.com.menchitech.ms_pdv_bms_restaurant.api.controller;

import br.com.menchitech.ms_pdv_bms_restaurant.api.controller.openapi.EstoqueProdutosControllerOpenApi;
import br.com.menchitech.ms_pdv_bms_restaurant.application.facade.EstoqueProdutosFacade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/estoque")
@AllArgsConstructor
public class EstoqueProdutosController implements EstoqueProdutosControllerOpenApi {

    private EstoqueProdutosFacade estoqueProdutosFacade;

    @GetMapping
    public void listarEstoqueProdutos() throws Exception {
        throw new Exception();
    }

}
