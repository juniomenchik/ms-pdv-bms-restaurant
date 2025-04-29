 package br.com.menchitech.ms_pdv_bms_restaurant.persistence.repository.categoria;

 import br.com.menchitech.ms_pdv_bms_restaurant.persistence.entity.CategoriaProdutoPersistenceEntity;
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.stereotype.Repository;

 import java.util.UUID;

 @Repository
 public interface CategoriaPersistenceRepository extends JpaRepository<CategoriaProdutoPersistenceEntity, UUID> {
    
 }
