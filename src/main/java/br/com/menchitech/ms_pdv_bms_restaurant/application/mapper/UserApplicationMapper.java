package br.com.menchitech.ms_pdv_bms_restaurant.application.mapper;

import br.com.menchitech.ms_pdv_bms_restaurant.application.dto.user.UserRequestDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.application.dto.user.UserResponseDTO;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.user.UserResultVO;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.user.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserApplicationMapper extends MapperApplicationInterface<
    UserRequestDTO, UserResponseDTO,
    UserVO, UserResultVO> {

    UserApplicationMapper INSTANCE = Mappers.getMapper(UserApplicationMapper.class);

}
