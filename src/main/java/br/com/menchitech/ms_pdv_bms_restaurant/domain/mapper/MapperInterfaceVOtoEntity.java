package br.com.menchitech.ms_pdv_bms_restaurant.domain.mapper;

public interface MapperInterfaceVOtoEntity<VO, ENTITY> {

    MapperInterfaceVOtoEntity INSTANCE = null;

    ENTITY toEntity (VO vo);
    VO toVO (ENTITY entity);

}
