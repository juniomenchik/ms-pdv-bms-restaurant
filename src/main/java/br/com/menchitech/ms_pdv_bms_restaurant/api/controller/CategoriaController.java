package br.com.menchitech.ms_pdv_bms_restaurant.api.controller;

import br.com.menchitech.ms_pdv_bms_restaurant.api.controller.openapi.CategoriaControllerOpenApi;
import br.com.menchitech.ms_pdv_bms_restaurant.api.dto.ResponseDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.application.dto.categoria.CategoriaProdutoRequestDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.application.facade.categoria.CategoriaFacade;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categoria")
@AllArgsConstructor
public class CategoriaController implements CategoriaControllerOpenApi {

    private CategoriaFacade categoriaFacade;

    @Override
    public ResponseDTO listarCategorias() {
        return categoriaFacade.list();
    }

    @Override
    public ResponseDTO buscarCategoriaPorId(@NonNull String id) {
        return categoriaFacade.findById(id);
    }

    @Override
    public ResponseDTO cadastrarCategoria(CategoriaProdutoRequestDTO categoriaRequestDTO) {
        return categoriaFacade.create(categoriaRequestDTO);
    }

    @Override
    public void deletarCategoria(@NonNull String id) {
        categoriaFacade.deleteById(id);
    }
}
