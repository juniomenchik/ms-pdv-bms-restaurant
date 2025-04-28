package br.com.menchitech.ms_pdv_bms_restaurant.domain.mapper;

import java.util.List;

public interface MapperInterfaceVOtoEntity<VO, ENTITY> {

    MapperInterfaceVOtoEntity INSTANCE = null;

    ENTITY toEntity (VO vo);
    VO toVO (ENTITY entity);

    List<ENTITY> toEntityList (List<VO> vo);
    List<VO> toVOList (List<ENTITY> entity);

}
