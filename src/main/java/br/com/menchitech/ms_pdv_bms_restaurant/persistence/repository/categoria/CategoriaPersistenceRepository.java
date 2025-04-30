 package br.com.menchitech.ms_pdv_bms_restaurant.persistence.repository.categoria;

 import br.com.menchitech.ms_pdv_bms_restaurant.persistence.entity.CategoriaProdutoPersistenceEntity;
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.data.jpa.repository.Query;
 import org.springframework.stereotype.Repository;

 import java.util.Optional;
 import java.util.UUID;

 @Repository
 public interface CategoriaPersistenceRepository extends JpaRepository<CategoriaProdutoPersistenceEntity, UUID> {

   @Query("SELECT c FROM CategoriaProdutoPersistenceEntity c WHERE c.nome = ?1")
   Optional<CategoriaProdutoPersistenceEntity> findByName(String categoria);

 }
