package br.com.menchitech.ms_pdv_bms_restaurant.application.exceptions;

import br.com.menchitech.ms_pdv_bms_restaurant.api.dto.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    private ResponseEntity<ResponseDTO> handleException(Exception exception) {

        ResponseDTO responseDTO = ResponseDTO.builder()
            .data(null)
            .message(exception.getMessage())
            .status("ERROR")
            .stackTrace(Arrays.toString(exception.getStackTrace()))
            .build();

        return ResponseEntity.ok(responseDTO);
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    private ResponseEntity<ResponseDTO> handleObjectNotFoundException(ObjectNotFoundException exception) {

        ResponseDTO responseDTO = ResponseDTO.builder()
            .data(exception.getEntityName())
            .message(exception.getMessage())
            .status("ERROR")
            .stackTrace(Arrays.toString(exception.getStackTrace()))
            .build();

        return ResponseEntity.ok(responseDTO);
    }

}
