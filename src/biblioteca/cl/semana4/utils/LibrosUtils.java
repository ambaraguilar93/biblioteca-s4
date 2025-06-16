/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.cl.semana4.utils;

import biblioteca.cl.semana4.models.libro.Libro;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ambar
 */
public class LibrosUtils {
    
    public static List<Libro> obtenerLibro(){
        List<Libro> libros = new ArrayList<>();
        libros.add(new Libro("Harry Potter y la Piedra Filosofal", "J.K. Rowling"));
        libros.add(new Libro("El Señor de los Anillos: La Comunidad del Anillo", "J.R.R. Tolkien"));
        libros.add(new Libro("Papelucho", "Marcela Paz"));
        libros.add(new Libro("Cien Años de Soledad", "Gabriel García Márquez"));
        libros.add(new Libro("1984", "George Orwell"));
        libros.add(new Libro("Orgullo y Prejuicio", "Jane Austen"));
        libros.add(new Libro("El Principito", "Antoine de Saint-Exupéry"));
        libros.add(new Libro("Matar a un Ruiseñor", "Harper Lee"));
        libros.add(new Libro("La Odisea", "Homero"));
        return libros;
    }
}
