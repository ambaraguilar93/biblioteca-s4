/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.cl.semana4.models.libro;

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
        return titulo + " | " + autor + " | " + isPrestado;
    }
    
    
    
}
