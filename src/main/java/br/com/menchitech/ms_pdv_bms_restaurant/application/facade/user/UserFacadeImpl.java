package br.com.menchitech.ms_pdv_bms_restaurant.application.facade.user;

import br.com.menchitech.ms_pdv_bms_restaurant.api.dto.ResponseDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.application.dto.user.UserRequestDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.application.mapper.UserApplicationMapper;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserFacadeImpl implements UserFacade {

    UserService userService;

    @Override
    public ResponseDTO list() {
        var usersVo = this.userService.list();

        var usersDTO = UserApplicationMapper.INSTANCE.toRESVOList(usersVo);

        return ResponseDTO.builder()
            .data(usersDTO)
            .message("Usuarios listados com sucesso.")
            .status("SUCCESS")
            .build();
    }

    @Override
    public ResponseDTO findById(String id) {
        var usersVo = this.userService.findById(id);

        var usersDTO = UserApplicationMapper.INSTANCE.toRES(usersVo);

        return ResponseDTO.builder()
            .data(usersDTO)
            .message("Usuario encontrado com sucesso.")
            .status("SUCCESS")
            .build();
    }

    @Override
    public ResponseDTO create(UserRequestDTO objetoDTO) {

        var userVO = UserApplicationMapper.INSTANCE.toVO(objetoDTO);

        var userResultVO = this.userService.create(userVO);

        return ResponseDTO.builder()
            .data(UserApplicationMapper.INSTANCE.toRES(userResultVO))
            .message("Usuario criado com sucesso.")
            .status("SUCCESS")
            .build();
    }

    @Override
    public void deleteById(String id) {

    }
}
