package com.heidiquinones.LiterAluraChallenge.principal;

import com.heidiquinones.LiterAluraChallenge.modelos.*;
import com.heidiquinones.LiterAluraChallenge.repository.AutorRepository;
import com.heidiquinones.LiterAluraChallenge.repository.LibroRepository;
import com.heidiquinones.LiterAluraChallenge.servicio.ConsumoAPI;
import com.heidiquinones.LiterAluraChallenge.servicio.ConvierteDatos;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books/";
    private ConvierteDatos conversor = new ConvierteDatos();
    private List<DatosLibros> datosLibros;
    private LibroRepository repositorioLibro;
    private AutorRepository repositorioAutor;
    private List<Libro> libros;
    //Optional<Libro> librosIdioma;
    //Optional<Autor> autoresYear;

    public Principal(LibroRepository l, AutorRepository a){
        this.repositorioLibro = l;
        this.repositorioAutor = a;
    }

    public void muestraMenu() {
        System.out.println("**************************************************");
        System.out.println("             BIENVENIDO A LITERALURA");
        System.out.println("**************************************************");
        var opcion = -1;
        while (opcion != 0) {
            System.out.println("\n");
            System.out.println("    SELECCIONA UNA DE LAS OPCIONES SIGUIENTES:\n");
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
                    System.out.println("\nCERRANDO LA APLICACIÓN LITERALURA");
                    System.out.println("¡VUELVE PRONTO!\n");
                    break;
                default:
                    System.out.println("\n¡OPCIÓN INVÁLIDA!");
            }
        }
    }

    private void buscarLibroWeb(){
        DatosLibros resultado = getDatosLibro();

        if (resultado.titulo()==""){
            return;
        }
        List<Autor> autores = resultado.autores().stream()
                .map(a -> new Autor(a))
                .collect(Collectors.toList());



        Libro libro = new Libro(resultado, autores);
        System.out.println(libro);

        //repositorio.save(libro);
    }

    private DatosLibros getDatosLibro() {
        System.out.println("\n");
        System.out.println("ESCRIBE EL NOMBRE DEL LIBRO BUSCADO:");
        var libroBuscado = teclado.nextLine();
        var urlConsulta = URL_BASE + "?search=" + libroBuscado.replace(" ", "+");
        var json = consumoApi.obtenerDatos(urlConsulta);
        DatosBusqueda registro = conversor.obtenerDatos(json, DatosBusqueda.class);
        if (registro.libros().isEmpty()) {
            System.out.println("\nTITULO NO ENCONTRADO EN LA BASE DE DATOS");
            DatosLibros libro = new DatosLibros("", null, (double) 0, null);
            return libro;
        }
        DatosLibros libro = registro.libros().get(0);
        return libro;
    }
}


