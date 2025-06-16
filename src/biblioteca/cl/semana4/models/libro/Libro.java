/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.cl.semana4.models.libro;

import biblioteca.cl.semana4.exceptions.LibroNoEncontradoException;
import java.util.List;

/**
 *
 * @author ambar
 */
public class Libro {
    private String titulo;
    private String autor;
    private boolean isPrestado;
    
    public Libro(String titulo, String autor){
        this.titulo = titulo;
        this.autor = autor;
        this.isPrestado = false;
    }
    
    //Getter y setter

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean getIsPrestado() {
        return isPrestado;
    }

    public void setEstado(boolean isPrestado) {
        this.isPrestado = isPrestado;
    }
    
    //metodos de la clase
    public void prestarLibro(){
        this.isPrestado = true;
    }
    
    public String mostrarInformacionLibro(){
        return titulo + " | " + autor + " | " + "Prestado: "+ isPrestado;
    }
    
    public static Libro buscarLibroPorTitulo(List<Libro> libros, String titulo) throws LibroNoEncontradoException{
        if (libros == null || libros.isEmpty()) {
            throw new LibroNoEncontradoException("No hay libros en la lista");
        }
        
        if (titulo == null || titulo.isEmpty()) {
            throw new LibroNoEncontradoException("El nombre del libro a buscar no puede estar vacío.");
        }
        
        if (titulo.length() < 3) {
            throw new LibroNoEncontradoException("La condición de búsqueda debe tener al menos 3 caracteres.");
        }
        
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        throw new LibroNoEncontradoException("Libro llamado " + titulo + " no encontrado.");
    }
    
}
