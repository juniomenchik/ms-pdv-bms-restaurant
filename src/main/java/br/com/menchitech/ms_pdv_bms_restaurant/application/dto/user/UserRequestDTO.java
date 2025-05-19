package br.com.menchitech.ms_pdv_bms_restaurant.application.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {

    @NonNull
    private String username;
    @NonNull
    private String email;
    @NonNull
    private String password;

}
