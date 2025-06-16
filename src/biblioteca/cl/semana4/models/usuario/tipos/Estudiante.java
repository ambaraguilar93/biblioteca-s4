/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.cl.semana4.models.usuario.tipos;

import biblioteca.cl.semana4.exceptions.LibroNoEncontradoException;
import biblioteca.cl.semana4.exceptions.LibroYaPrestadoException;
import biblioteca.cl.semana4.models.libro.Libro;
import biblioteca.cl.semana4.models.usuario.Usuario;
import java.util.InputMismatchException;
import java.util.List;

/**
 *
 * @author ambar
 */
public class Estudiante extends Usuario {
    private String carrera;

    public Estudiante(String rut, String nombre, String apellido, int edad, String direccion, int opcion) {
        super(rut, nombre, apellido, edad, direccion, opcion);
    }

    //Getter y setter
    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
    //metodos de la clase
    
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
    public void pedirPrestadoLibro(List<Libro> libros, String titulo) throws LibroYaPrestadoException{
        if (libros == null || libros.isEmpty()) {
            throw new LibroYaPrestadoException("No hay libros en la lista");          
        }
        
        
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                if (libro.getIsPrestado()) {
                    throw new LibroYaPrestadoException("El libro '" + titulo + "' ya ha sido prestado.");
                }                     
                libro.prestarLibro();
                System.out.println("El libro '" + titulo + "' ha sido prestado con éxito.");
                return;  
            }
        }
    }

    @Override
    public void agregarLibro(List<Libro> libros, String titulo, String autor) throws InputMismatchException {
        throw new InputMismatchException("Este usuario no puede agregar libros."); 
    }
    
    
}
