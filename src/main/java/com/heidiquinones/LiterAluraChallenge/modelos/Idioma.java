package com.heidiquinones.LiterAluraChallenge.modelos;

public enum Idioma {
    IN("en","Inglés"),
    ES("es", "Español"),
    FR("fr","Francés"),
    IT("it", "Italiano");

    private String idiomaGutendex;
    private String idiomaBD;

    Idioma (String idiomaGutendex, String idiomaBD){
        this.idiomaGutendex = idiomaGutendex;
        this.idiomaBD = idiomaBD;
    }

    public static Idioma fromString(String text){
        for (Idioma idioma : Idioma.values()){
            if (idioma.idiomaGutendex.equalsIgnoreCase(text)){
                return idioma;
            }
        }
        throw new IllegalArgumentException("Idioma " + text + " NO Encontado");
    }
    public static Idioma fromEsp(String text){
        for (Idioma idioma : Idioma.values()){
            if (idioma.idiomaBD.equalsIgnoreCase(text)){
                return idioma;
            }
        }
        throw new IllegalArgumentException("Idioma " + text + " NO Encontado");
    }
}
