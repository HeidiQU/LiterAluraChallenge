package com.heidiquinones.LiterAluraChallenge.modelos;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(unique = true)
    private String nombre;
    private Integer nacimiento;
    private Integer fallecimiento;
    @ManyToMany(mappedBy = "autores", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Libro> libros;

    public Autor(){}

    public Autor(DatosAutor a){
        this.nombre = a.nombre();
        this.nacimiento = a.nacimiento();
        this.fallecimiento = a.fallecimiento();
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Integer nacimiento) {
        this.nacimiento = nacimiento;
    }

    public Integer getFallecimiento() {
        return fallecimiento;
    }

    public void setFallecimiento(Integer fallecimiento) {
        this.fallecimiento = fallecimiento;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        if (libros==null){
            return "Autor: \n" +
                    "Nombre: " + nombre + "\n" +
                    "Nacido el: " + nacimiento +
                    ", Falleció el: " + fallecimiento + '\n';
        }
        String susLibros = libros.stream()
                .map(Libro::getTitulo)
                .collect(Collectors.joining(" - "));
        return "Autor: \n" +
                "Nombre: " + nombre + "\n" +
                "Nacido el: " + nacimiento +
                ", Falleció el: " + fallecimiento + '\n'+
                "Libros Registrados: " + susLibros;
    }
}
