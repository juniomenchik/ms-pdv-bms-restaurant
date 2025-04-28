package br.com.menchitech.ms_pdv_bms_restaurant.persistence.repository;

import java.util.List;
import java.util.Optional;

public interface BaseRepositoryInterface<TOBJECT> {
    //crud operations

    List <TOBJECT> list();
    void save(TOBJECT object);
    void update(TOBJECT object);
    void delete(TOBJECT object);
    Optional<TOBJECT> findById(Long id);

}
