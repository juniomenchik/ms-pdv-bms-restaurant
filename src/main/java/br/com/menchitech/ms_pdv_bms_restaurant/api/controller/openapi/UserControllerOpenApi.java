package br.com.menchitech.ms_pdv_bms_restaurant.api.controller.openapi;

import br.com.menchitech.ms_pdv_bms_restaurant.api.dto.ResponseDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.application.dto.user.UserRequestDTO;
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

@Tag(name = "Users", description = "Gerenciamento de user")
public interface UserControllerOpenApi {

    @Operation(summary = "Lista todos os users",
        responses = {
            @ApiResponse(responseCode = "200", description = "Lista de users retornada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor",
                content = @Content)
        })
    @GetMapping
    ResponseDTO listarUsers();

    @Operation(summary = "Busca um user por ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "User encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "User não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor",
                content = @Content)
        })
    @GetMapping("/{id}")
    ResponseDTO buscarUserPorId(@PathVariable @NonNull String id);

    @Operation(summary = "Cadastra um novo user",
        responses = {
            @ApiResponse(responseCode = "201", description = "User cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor",
                content = @Content)
        })
    @PostMapping
    ResponseDTO cadastrarUser(@RequestBody @Valid UserRequestDTO userRequestDTO);

    @Operation(summary = "Remove um user",
        responses = {
            @ApiResponse(responseCode = "204", description = "User removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "User não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor",
                content = @Content)
        })
    @DeleteMapping("/{id}")
    void deletarUser(@PathVariable @NonNull String id);

}
