package br.com.menchitech.ms_pdv_bms_restaurant.api.controller.openapi;

import br.com.menchitech.ms_pdv_bms_restaurant.api.dto.ResponseDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.application.dto.categoria.CategoriaProdutoRequestDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.application.dto.estoque.EstoqueRequestDTO;
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

@Tag(name = "Categorias de Produtos", description = "Gerenciamento de categorias de produtos")
public interface CategoriaControllerOpenApi {

    @Operation(summary = "Lista todas as categorias de produtos",
        responses = {
            @ApiResponse(responseCode = "200", description = "Lista de categorias retornada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor",
                content = @Content)
        })
    @GetMapping
    ResponseDTO listarCategorias();

    @Operation(summary = "Busca uma categoria por ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "Categoria encontrada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Categoria não encontrada"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor",
                content = @Content)
        })
    @GetMapping("/{id}")
    ResponseDTO buscarCategoriaPorId(@PathVariable @NonNull String id);

    @Operation(summary = "Cadastra uma nova categoria",
        responses = {
            @ApiResponse(responseCode = "201", description = "Categoria cadastrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor",
                content = @Content)
        })
    @PostMapping
    ResponseDTO cadastrarCategoria(@RequestBody @Valid CategoriaProdutoRequestDTO categoriaRequestDTO);

    @Operation(summary = "Remove uma categoria",
        responses = {
            @ApiResponse(responseCode = "204", description = "Categoria removida com sucesso"),
            @ApiResponse(responseCode = "404", description = "Categoria não encontrada"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor",
                content = @Content)
        })
    @DeleteMapping("/{id}")
    void deletarCategoria(@PathVariable @NonNull String id);

}
