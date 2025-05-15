package br.com.menchitech.ms_pdv_bms_restaurant.persistence.repository.security;

import br.com.menchitech.ms_pdv_bms_restaurant.persistence.entity.security.UserEntity;
import br.com.menchitech.ms_pdv_bms_restaurant.persistence.repository.BaseRepositoryInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserCustomRepository implements BaseRepositoryInterface<UserEntity, UUID> {

    private UserPersistenceRepository userPersistenceRepository;

    @Override
    public List<UserEntity> list() {
        return List.of();
    }

    @Override
    public UserEntity save(UserEntity object) {
        return null;
    }

    @Override
    public UserEntity update(UserEntity object) {
        return null;
    }

    @Override
    public void delete(UUID object) {

    }

    @Override
    public Optional<UserEntity> findById(UUID id) {
        return Optional.empty();
    }
}
