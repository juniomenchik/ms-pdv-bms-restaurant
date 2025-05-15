package br.com.menchitech.ms_pdv_bms_restaurant.api.controller;

import br.com.menchitech.ms_pdv_bms_restaurant.api.controller.openapi.UserControllerOpenApi;
import br.com.menchitech.ms_pdv_bms_restaurant.api.dto.ResponseDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.application.dto.user.UserRequestDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.application.facade.user.UserFacade;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController implements UserControllerOpenApi {

    private UserFacade userFacade;

    @Override
    public ResponseDTO listarUsers() {
        return null;
    }

    @Override
    public ResponseDTO buscarUserPorId(@NonNull String id) {
        return null;
    }

    @Override
    public ResponseDTO cadastrarUser(UserRequestDTO userRequestDTO) {
        return null;
    }

    @Override
    public void deletarUser(@NonNull String id) {

    }
}
