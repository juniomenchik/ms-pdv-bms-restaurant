package br.com.menchitech.ms_pdv_bms_restaurant.configuration.utils;

import java.util.UUID;

public class ValidationGlobalUtils {

    public static UUID toUUID(String id) {
        try {
            var objId = UUID.fromString(id);

            return objId;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid UUID format: " + id);
        }
    }
}
