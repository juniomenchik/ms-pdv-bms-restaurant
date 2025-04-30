package br.com.menchitech.ms_pdv_bms_restaurant.application.facade;

import br.com.menchitech.ms_pdv_bms_restaurant.api.dto.ResponseDTO;

public interface CrudFacade<T> {

    ResponseDTO list();

    ResponseDTO findById(String id);

    ResponseDTO create(T objetoDTO);

    void deleteById(String id);
}
