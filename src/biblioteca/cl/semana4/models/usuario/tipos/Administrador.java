/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.cl.semana4.models.usuario.tipos;

import java.util.InputMismatchException;
import biblioteca.cl.semana4.exceptions.LibroYaPrestadoException;
import biblioteca.cl.semana4.models.libro.Libro;
import biblioteca.cl.semana4.models.usuario.Usuario;
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
            return;
        }
        
        System.out.println("Error: libro no fue agregado.");
  
    }
    
    
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
    public void mostrarInformacionUsuario() {
        System.out.println("========== INFORMACION DEL USUARIO ==========");
        System.out.println("Nombre completo: " + this.getNombre() + " " + this.getApellido());
        System.out.println("Edad: " + this.getEdad());
        System.out.println("Direccion: " + this.getDireccion() );
        System.out.println("Tipo Usuario: " + this.getTipoUsuario());
    }

    @Override
    public void pedirPrestadoLibro(List<Libro> libros, String titulo) throws LibroYaPrestadoException {
        throw new LibroYaPrestadoException("Este usuario no puede pedir prestado libros."); 
    }
}
