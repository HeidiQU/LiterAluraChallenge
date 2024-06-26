package com.heidiquinones.LiterAluraChallenge.modelos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RecordLibros(
        @JsonAlias("title") String titulo,
        @JsonAlias("languages") String idioma,
        @JsonAlias("download_count") Double descargas) {
}
