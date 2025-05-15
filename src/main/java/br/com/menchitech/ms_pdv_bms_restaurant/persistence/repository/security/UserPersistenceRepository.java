package br.com.menchitech.ms_pdv_bms_restaurant.persistence.repository.security;

import br.com.menchitech.ms_pdv_bms_restaurant.persistence.entity.security.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.UUID;

public interface UserPersistenceRepository extends JpaRepository<UserEntity, UUID> {

    UserEntity findByUsername(String username);
    UserEntity findByEmail(String email);
}
