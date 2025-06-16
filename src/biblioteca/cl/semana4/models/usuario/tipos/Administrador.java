/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.cl.semana4.models.usuario.tipos;

import java.util.InputMismatchException;
import biblioteca.cl.semana4.exceptions.LibroNoEncontradoException;
import biblioteca.cl.semana4.models.libro.Libro;
import biblioteca.cl.semana4.models.usuario.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ambar
 */
public class Administrador extends Usuario {
    
    public Administrador(String rut, String nombre, String apellido, int edad, String direccion, int opcion) {
        super(rut, nombre, apellido, edad, direccion, opcion);
    }
    
    //metodos de la clase
    public boolean validarLibro(String titulo, String autor) {
        if (titulo == null || titulo.isEmpty() ) {
            return false;
        }
        
        if (autor == null || autor.isEmpty()) {
            return false;
        }
        
        return true;
    }
    
    
    public void agregarLibro(List<Libro> libros, String titulo, String autor) throws InputMismatchException{
        
        if (validarLibro(titulo, autor)) {  
            
            Libro nuevoLibro = new Libro(titulo, autor);
            libros.add(nuevoLibro);
            System.out.println("Libro agregado correctamente.");
        }
        
        System.out.println("Error: libro no fue agregado.");
  
    }
    
//    public void verInformeLibros(List<Libro> libros){
//        if (libros.isEmpty()) {
//            System.out.println("No hay libros en la biblioteca.");
//            return;
//        } 
//        
//        System.out.println("Informe de libros:");
//        
//        for (Libro libro : libros) {
//            System.out.println(libro);
//        }
//        
//    }
    
    private boolean validarRut(String rut) {      
        if (rut == null || rut.isEmpty()) {
            return false;
        }
        if (rut.length() != 11 && rut.length() != 12) {
            return false;
        }
        if (!rut.matches("\\d{1,2}\\.\\d{3}\\.\\d{3}[-][0-9kK]{1}")) {
            return false;
        }      
        return true;
    }
    
    @Override
    public boolean registrarUsuario(){
              if (validarRut(this.getRut())) {
                  System.out.println("Cliente registrado correctamente: "+this.getNombre()+" "+this.getApellido());
                  return true;
             }
              return false;
    }

    @Override
    public Libro buscarLibroPorTitulo(List<Libro> libros, String titulo) throws LibroNoEncontradoException{
        
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
    

    @Override
    public void mostrarInformacionUsuario() {
        System.out.println("========== INFORMACION DEL USUARIO ==========");
        System.out.println("Nombre completo: " + this.getNombre() + " " + this.getApellido());
        System.out.println("Edad: " + this.getEdad());
        System.out.println("Direccion: " + this.getDireccion() );
        System.out.println("Tipo Usuario: " + this.getTipoUsuario());
    }
}
