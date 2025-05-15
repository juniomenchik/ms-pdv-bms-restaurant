package br.com.menchitech.ms_pdv_bms_restaurant.application.facade.user;

import br.com.menchitech.ms_pdv_bms_restaurant.api.dto.ResponseDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.application.dto.user.UserRequestDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserFacadeImpl implements UserFacade {

    UserService userService;

    @Override
    public ResponseDTO list() {
        return null;
    }

    @Override
    public ResponseDTO findById(String id) {
        return null;
    }

    @Override
    public ResponseDTO create(UserRequestDTO objetoDTO) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }
}
