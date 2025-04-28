 package br.com.menchitech.ms_pdv_bms_restaurant.persistence.repository;

 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.stereotype.Repository;

 import br.com.menchitech.ms_pdv_bms_restaurant.persistence.entity.ProdutoPersistenceEntity;

 @Repository
 public interface ProdutoPersistenceRepository extends JpaRepository<ProdutoPersistenceEntity, Long> {
    
 }
