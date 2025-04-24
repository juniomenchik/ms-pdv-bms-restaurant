package br.com.menchitech.ms_pdv_bms_restaurant.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.menchitech.ms_pdv_bms_restaurant.persistence.entity.EstoquePersistenceEntity;

@Repository
public interface EstoquePersistenceRepository extends JpaRepository<EstoquePersistenceEntity, Long> {
    
}
