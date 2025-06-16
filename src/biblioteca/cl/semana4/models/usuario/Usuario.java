/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.cl.semana4.models.usuario;

import biblioteca.cl.semana4.exceptions.LibroNoEncontradoException;
import biblioteca.cl.semana4.models.libro.Libro;
import java.util.List;

/**
 *
 * @author ambar
 */
public abstract class Usuario {
    private String rut;
    private String nombre;
    private String apellido;
    private int edad;
    private String direccion;
    private String tipoUsuario; // "ESTUDIANTE" o "ADMINISTRADOR"
    private Libro libro;

    public Usuario(String rut, String nombre, String apellido, int edad, String direccion, int opcion) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.direccion = direccion;
        this.tipoUsuario = crearTipoUsuario(opcion);
    }
    
    public Usuario (String nombre, String tipoUsuario) {
        this.nombre = nombre;
        this.tipoUsuario = tipoUsuario;
    }

    //Getter y setter
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
      public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    

    
    //metodos de la clase
    
    public String crearTipoUsuario(int opcion){
        
        if (opcion == 1) {
            return "Administrador";
        }
        
        if (opcion == 2) {
            return "Estudiante";
        }
        
        return "No valido.";
    }
    
    public abstract boolean registrarUsuario();
    
    public abstract Libro buscarLibroPorTitulo(List<Libro> libros, String titulo) throws LibroNoEncontradoException;
    
    public abstract void mostrarInformacionUsuario();
}
