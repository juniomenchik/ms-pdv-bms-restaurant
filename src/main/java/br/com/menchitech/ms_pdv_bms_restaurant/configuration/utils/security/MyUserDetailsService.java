package br.com.menchitech.ms_pdv_bms_restaurant.configuration.utils.security;

import br.com.menchitech.ms_pdv_bms_restaurant.persistence.entity.security.UserPersistenceEntity;
import br.com.menchitech.ms_pdv_bms_restaurant.persistence.repository.security.UserPersistenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserPersistenceRepository userPersistenceRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserPersistenceEntity userByUsername   = userPersistenceRepository.findByUsername(username);
        UserPersistenceEntity userEmail        = userPersistenceRepository.findByEmail(username);

        if (userByUsername != null){
            return UserPrincipal.builder()
                .user(userByUsername)
                .build();
        }else if (userEmail != null){
            return UserPrincipal.builder()
                .user(userEmail)
                .build();
        }else
            throw new UsernameNotFoundException("User not found with username or email: " + username);
    }
}
