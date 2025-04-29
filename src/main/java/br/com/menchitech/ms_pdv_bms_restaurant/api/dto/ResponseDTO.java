package br.com.menchitech.ms_pdv_bms_restaurant.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO {

    private Object data;
    private String status;
    private String message;
    private String stackTrace;

}
