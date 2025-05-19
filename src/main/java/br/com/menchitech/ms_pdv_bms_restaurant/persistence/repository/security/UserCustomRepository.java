package br.com.menchitech.ms_pdv_bms_restaurant.persistence.repository.security;

import br.com.menchitech.ms_pdv_bms_restaurant.persistence.entity.security.UserPersistenceEntity;
import br.com.menchitech.ms_pdv_bms_restaurant.persistence.repository.BaseRepositoryInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserCustomRepository implements BaseRepositoryInterface<UserPersistenceEntity, UUID> {

    private UserPersistenceRepository userPersistenceRepository;

    @Override
    public List<UserPersistenceEntity> list() {
        return this.userPersistenceRepository.findAll();
    }

    @Override
    public UserPersistenceEntity save(UserPersistenceEntity object) {
        return this.userPersistenceRepository.saveAndFlush(object);
    }

    @Override
    public UserPersistenceEntity update(UserPersistenceEntity object) {
        return null;
    }

    @Override
    public void delete(UUID object) {

    }

    @Override
    public Optional<UserPersistenceEntity> findById(UUID id) {
        return this.userPersistenceRepository.findById(id);
    }
}
