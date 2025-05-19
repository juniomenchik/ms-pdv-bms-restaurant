package br.com.menchitech.ms_pdv_bms_restaurant.domain.vo.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {

    private UUID id;

    private String username;

    private String email;

    private String password;

}
