package br.com.menchitech.ms_pdv_bms_restaurant.persistence.repository;

import java.util.List;
import java.util.Optional;

public interface BaseRepositoryInterface<TOBJECT, TID> {
    //crud operations

    List <TOBJECT> list();
    TOBJECT save(TOBJECT object);
    TOBJECT update(TOBJECT object);
    void delete(TID object);
    Optional<TOBJECT> findById(TID id);

}
