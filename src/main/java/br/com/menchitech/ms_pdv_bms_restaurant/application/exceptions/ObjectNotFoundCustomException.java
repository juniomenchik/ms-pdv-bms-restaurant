package br.com.menchitech.ms_pdv_bms_restaurant.application.exceptions;

import lombok.Data;

@Data
public class ObjectNotFoundCustomException extends RuntimeException {

    private Object objData;
    private String objStatus;
    private String objMessage;

    public ObjectNotFoundCustomException(String id, String name) {
        this.objData = id;
        this.objStatus = "Nao foi Encontrado nenhum Objeto.";
        this.objMessage = String.format("Object %s with id %s not found", name, id);
    }
}
