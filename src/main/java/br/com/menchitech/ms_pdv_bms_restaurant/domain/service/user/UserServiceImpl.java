package br.com.menchitech.ms_pdv_bms_restaurant.domain.service.user;

import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.user.UserResultVO;
import br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.user.UserVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Override
    public List<UserResultVO> list() {
        return List.of();
    }

    @Override
    public UserResultVO findById(String id) {
        return null;
    }

    @Override
    public UserResultVO create(UserVO estoqueRequestDTO) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
