package com.heidiquinones.LiterAluraChallenge.modelos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibros(
        @JsonAlias("title") String titulo,
        @JsonAlias("languages") List<String> idiomas,
        @JsonAlias("download_count") Double descargas,
        @JsonAlias("authors") List<DatosAutor> autores)  {

    public String getUnIdioma(){
        if (idiomas == null && idiomas.isEmpty()){
            return "N_E";
        }else {
            return idiomas.get(0);
        }
    }


}
