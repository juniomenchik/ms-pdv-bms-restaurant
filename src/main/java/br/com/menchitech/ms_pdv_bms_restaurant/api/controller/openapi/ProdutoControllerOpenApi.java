package br.com.menchitech.ms_pdv_bms_restaurant.api.controller.openapi;

import br.com.menchitech.ms_pdv_bms_restaurant.api.dto.ResponseDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.application.dto.estoque.EstoqueRequestDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.application.dto.produto.ProdutoRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Produtos", description = "Gerenciamento de produtos")
public interface ProdutoControllerOpenApi {

    @Operation(summary = "Lista todos os produtos",
        responses = {
            @ApiResponse(responseCode = "200", description = "Lista de produtos retornada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor",
                content = @Content)
        })
    @GetMapping
    ResponseDTO listarProdutos();

    @Operation(summary = "Busca um produto por ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "Produto encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor",
                content = @Content)
        })
    @GetMapping("/{id}")
    ResponseDTO buscarProdutoPorId(@PathVariable @NonNull String id);

    @Operation(summary = "Cadastra um novo produto",
        responses = {
            @ApiResponse(responseCode = "201", description = "Produto cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor",
                content = @Content)
        })
    @PostMapping
    ResponseDTO cadastrarProduto(@RequestBody @Valid ProdutoRequestDTO produtoRequestDTO);

    @Operation(summary = "Remove um produto",
        responses = {
            @ApiResponse(responseCode = "204", description = "Produto removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor",
                content = @Content)
        })
    @DeleteMapping("/{id}")
    void deletarProduto(@PathVariable @NonNull String id);

}
