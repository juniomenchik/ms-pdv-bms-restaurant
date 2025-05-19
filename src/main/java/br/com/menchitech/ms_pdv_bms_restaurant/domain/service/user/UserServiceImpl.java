package br.com.menchitech.ms_pdv_bms_restaurant.domain.service.user;

import br.com.menchitech.ms_pdv_bms_restaurant.application.exceptions.ObjectNotFoundCustomException;
import br.com.menchitech.ms_pdv_bms_restaurant.configuration.utils.ValidationGlobalUtils;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.mapper.ProdutoDomainMapper;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.mapper.UserDomainMapper;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.user.UserResultVO;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.user.UserVO;
import br.com.menchitech.ms_pdv_bms_restaurant.persistence.entity.ProdutoPersistenceEntity;
import br.com.menchitech.ms_pdv_bms_restaurant.persistence.entity.security.UserPersistenceEntity;
import br.com.menchitech.ms_pdv_bms_restaurant.persistence.repository.security.UserCustomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserCustomRepository userCustomRepository;

    @Override
    public List<UserResultVO> list() {
        var users = userCustomRepository.list();

        return UserDomainMapper.INSTANCE.toRESVOList(users);
    }

    @Override
    public UserResultVO findById(String id) {

        var user = userCustomRepository.findById(ValidationGlobalUtils.toUUID(id));

        if (user.isPresent()) {
            return UserDomainMapper.INSTANCE.toRESVO(user.get());
        } else {
            throw new ObjectNotFoundCustomException(
                id, UserPersistenceEntity.class.getName());
        }
    }

    @Override
    public UserResultVO create(UserVO userVO) {
        var entity = UserDomainMapper.INSTANCE.toEntity(userVO);

        var resp = userCustomRepository.save(entity);

        return UserDomainMapper.INSTANCE.toRESVO(resp);
    }

    @Override
    public void delete(String id) {

    }
}
