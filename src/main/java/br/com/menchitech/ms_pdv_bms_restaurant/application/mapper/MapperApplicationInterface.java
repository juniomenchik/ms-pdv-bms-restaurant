package br.com.menchitech.ms_pdv_bms_restaurant.application.mapper;

import java.util.List;

public interface MapperApplicationInterface<REQ,RES,VO,RESVO> {

    VO toVO(REQ req);

    RES toRES(RESVO resVO);

    List<VO> toVOList(List<RESVO> resVOList);

    List<RESVO> toRESVOList(List<RESVO> voList);


}
