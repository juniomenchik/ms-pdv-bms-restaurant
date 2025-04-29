package br.com.menchitech.ms_pdv_bms_restaurant.domain.mapper;

import java.util.List;

public interface MapperDomainInterface<VO, ENTITY, RESVO> {
    
    ENTITY toEntity(VO vo);
    
    RESVO toRESVO(ENTITY entity);

    List<ENTITY> toEntityList(List<VO> voList);

    List<RESVO> toRESVOList(List<ENTITY> entityList);

}
