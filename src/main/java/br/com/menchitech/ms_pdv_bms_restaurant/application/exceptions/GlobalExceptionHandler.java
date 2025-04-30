package br.com.menchitech.ms_pdv_bms_restaurant.application.exceptions;

import br.com.menchitech.ms_pdv_bms_restaurant.api.dto.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    private ResponseEntity<ResponseDTO> handleException(Exception exception) {

        ResponseDTO responseDTO = ResponseDTO.builder()
            .data(null)
            .message(exception.getMessage())
            .status("ERROR")
            .build();

        return ResponseEntity.status(500).body(responseDTO);
    }

    @ExceptionHandler(ObjectNotFoundCustomException.class)
    private ResponseEntity<ResponseDTO> handleObjectNotFoundException(ObjectNotFoundCustomException exception) {

        ResponseDTO responseDTO = ResponseDTO.builder()
            .data(exception.getObjData())
            .message(exception.getObjMessage())
            .status(exception.getObjStatus())
            .build();

        return ResponseEntity.status(404).body(responseDTO);
    }

}
