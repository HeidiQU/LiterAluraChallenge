package com.heidiquinones.LiterAluraChallenge.servicio;

public interface IConvierteDatos {
    //CREA UN TIPO DE DATOS GENÉRICO
    <T> T obtenerDatos(String json, Class<T> clase);
}
