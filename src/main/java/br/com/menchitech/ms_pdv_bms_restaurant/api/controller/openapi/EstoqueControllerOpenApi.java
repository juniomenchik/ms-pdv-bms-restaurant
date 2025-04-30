package br.com.menchitech.ms_pdv_bms_restaurant.api.controller.openapi;

import br.com.menchitech.ms_pdv_bms_restaurant.api.dto.ResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "Estoque de Produtos", description = "Gerenciamento de estoque de produtos")
public interface EstoqueControllerOpenApi {

    @Operation(summary = "Lista todos os produtos em estoque",
        responses = {
            @ApiResponse(responseCode = "200", description = "Lista de produtos retornada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor",
                content = @Content)
        })
    @GetMapping
    ResponseDTO listarEstoqueProdutos();

    @Operation(summary = "Busca um estoque por ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "Produto encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor",
                content = @Content)
        })
    @GetMapping("/{id}")
    ResponseDTO buscarEstoquePorId(@PathVariable @NonNull String id);

}
