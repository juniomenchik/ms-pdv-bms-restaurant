package br.com.menchitech.ms_pdv_bms_restaurant.persistence.repository.security;

import br.com.menchitech.ms_pdv_bms_restaurant.persistence.entity.security.UserPersistenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.UUID;

public interface UserPersistenceRepository extends JpaRepository<UserPersistenceEntity, UUID> {

    UserPersistenceEntity findByUsername(String username);
    UserPersistenceEntity findByEmail(String email);
}
