package br.com.menchitech.ms_pdv_bms_restaurant.api.controller.openapi;

import br.com.menchitech.ms_pdv_bms_restaurant.api.dto.ResponseDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.application.dto.estoque.EstoqueRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

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

    @Operation(summary = "Cadastra um novo estoque",
        responses = {
            @ApiResponse(responseCode = "201", description = "Estoque cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor",
                content = @Content)
        })
    @PostMapping
    ResponseDTO cadastrarEstoque(@RequestBody @Valid EstoqueRequestDTO estoqueRequestDTO);

    @Operation(summary = "Remove um estoque",
        responses = {
            @ApiResponse(responseCode = "204", description = "Produto removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor",
                content = @Content)
        })
    @DeleteMapping("/{id}")
    void deletarEstoque(@PathVariable @NonNull String id);

}
