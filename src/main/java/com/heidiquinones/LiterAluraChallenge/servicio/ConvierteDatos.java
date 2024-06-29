package com.heidiquinones.LiterAluraChallenge.servicio;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos implements IConvierteDatos{
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        if (json.isEmpty()){
            System.out.println("no se encontró nanais");
        }else{
            try {
                return objectMapper.readValue(json, clase);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        } return null;
    }
}
