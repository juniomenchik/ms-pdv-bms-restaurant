package br.com.menchitech.ms_pdv_bms_restaurant.domain.mapper;


import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.user.UserResultVO;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.user.UserVO;
import br.com.menchitech.ms_pdv_bms_restaurant.persistence.entity.security.UserPersistenceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserDomainMapper extends MapperDomainInterface<
    UserVO,
    UserPersistenceEntity,
    UserResultVO> {

    UserDomainMapper INSTANCE = Mappers.getMapper(UserDomainMapper.class);
}
