package br.com.menchitech.ms_pdv_bms_restaurant.api.controller;

import br.com.menchitech.ms_pdv_bms_restaurant.api.controller.openapi.EstoqueControllerOpenApi;
import br.com.menchitech.ms_pdv_bms_restaurant.api.dto.ResponseDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.application.dto.estoque.EstoqueRequestDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.application.facade.estoque.EstoqueFacade;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/estoque")
@AllArgsConstructor
public class EstoqueController implements EstoqueControllerOpenApi {

    private EstoqueFacade estoqueFacade;

    @Override
    public ResponseDTO listarEstoqueProdutos() {
        return this.estoqueFacade.list();
    }

    @Override
    public ResponseDTO buscarEstoquePorId(@NonNull String id) {
        return this.estoqueFacade.findById(id);
    }

}
