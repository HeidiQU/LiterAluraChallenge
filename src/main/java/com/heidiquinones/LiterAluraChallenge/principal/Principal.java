package com.heidiquinones.LiterAluraChallenge.principal;

import com.heidiquinones.LiterAluraChallenge.modelos.Autor;
import com.heidiquinones.LiterAluraChallenge.modelos.Libro;
import com.heidiquinones.LiterAluraChallenge.modelos.RecordLibros;
import com.heidiquinones.LiterAluraChallenge.repository.LibrosRepository;
import com.heidiquinones.LiterAluraChallenge.servicio.ConsumoAPI;
import com.heidiquinones.LiterAluraChallenge.servicio.ConvierteDatos;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books";
    private ConvierteDatos conversor = new ConvierteDatos();
    private List<RecordLibros> registros;
    private LibrosRepository repositorio;
    private List<Libro> libros;
    Optional<Libro> librosIdioma;
    Optional<Autor> autoresYear;


    public void muestraMenu() {
        var opcion = -1;
        while (opcion != 0) {
            System.out.println("/n");
            var menu = """
                    1. Búsqueda de Libro por Título en Internet.
                    2. Mostrar Libros Registrados en mi Base de Datos.
                    3. Mostrar Autores Registrados en mi Base de Datos.
                    4. Mostrar Autores que vivieron en un año.
                    5. Mostrar Libros Registrados por idioma.
                                           \s
                    0. Salir.
                   \s""";
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibroWeb();
                    break;
                case 2:
                   // mostrarLibrosBD();
                    break;
                case 3:
                   // mostrarAutoresBD();
                    break;
                case 4:
                    //mostrarAutoresYear();
                    break;
                case 5:
                   //mostrarLibrosIdioma();
                    break;
                case 0:
                    System.out.println("Cerrando Aplicación LiterAlura");
                    System.out.println("¡Vuelve Pronto!");
                    break;
                default:
                    System.out.println("¡Opción Inválida!");
                    System.out.println("Selecciona una opción del menú:");
            }
        }
    }

    private void buscarLibroWeb(){
        RecordLibros registro = getDatosLibro();
        Libro libro = new Libro(registro);
        //repositorio.save(libro);
        System.out.println(libro);

    }

    private RecordLibros getDatosLibro() {
        System.out.println("/n");
        System.out.println("Escribe el Nombre del Libro que Buscas:");
        var libroBuscado = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + "search=" + libroBuscado);
        System.out.println(json);
        RecordLibros registro = conversor.obtenerDatos(json, RecordLibros.class);
        return registro;
    }
}


