package br.com.menchitech.ms_pdv_bms_restaurant.application.mapper;

import java.util.List;

public interface MapperInterfaceDTOtoVO<VO, DTO> {

    DTO toDTO(VO vo);
    VO toVO (DTO entity);

    List<DTO> toDTOList(List<VO> vo);
    List<VO> toVOList (List<DTO> entity);
}
