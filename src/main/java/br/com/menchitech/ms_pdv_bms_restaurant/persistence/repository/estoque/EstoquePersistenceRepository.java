package br.com.menchitech.ms_pdv_bms_restaurant.persistence.repository.estoque;

import br.com.menchitech.ms_pdv_bms_restaurant.persistence.entity.EstoquePersistenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EstoquePersistenceRepository extends JpaRepository<EstoquePersistenceEntity, UUID> {
    
}
