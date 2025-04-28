package br.com.menchitech.ms_pdv_bms_restaurant.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDTO {

    private Object data;
    private String status;
    private String message;
    private String stackTrace;

}
