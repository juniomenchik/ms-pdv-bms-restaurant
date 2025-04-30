package br.com.menchitech.ms_pdv_bms_restaurant.domain.service;

import java.util.List;

public interface CrudServiceInterface <R, V> {
    List<V> list();

    V findById(String id);

    V create(R estoqueRequestDTO);

    void delete(String id);
}
