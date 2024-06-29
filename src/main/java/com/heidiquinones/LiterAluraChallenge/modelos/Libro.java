package com.heidiquinones.LiterAluraChallenge.modelos;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(unique = true)
    private String titulo;
    private String idioma;
    private Double descargas;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "libros_y_autores", joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id"))
    private List<Autor> autores;

    @Override
    public String toString() {
        return  titulo + '\n' +
                "Idioma: " + idioma + '\n' +
                "Número de Descargas: " + descargas + "\n" +
                "Autores=" + autores;
    }

    public Libro(){}

    public Libro(DatosLibros datosLibro, List<Autor> autores){
        this.titulo = datosLibro.titulo();
        this.autores = autores;
        this.idioma = getUnIdioma(datosLibro);
        this.descargas = datosLibro.descargas();

    }

    private String getUnIdioma(DatosLibros datosLibro) {
        String idioma = datosLibro.idiomas().toString();
        return idioma;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma(String idioma) {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Double getDescargas() {
        return descargas;
    }

    public void setDescargas(Double descargas) {
        this.descargas = descargas;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }
}
