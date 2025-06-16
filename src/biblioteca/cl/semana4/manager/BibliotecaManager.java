/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.cl.semana4.manager;

import biblioteca.cl.semana4.models.libro.Libro;
import biblioteca.cl.semana4.models.usuario.Usuario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ambar
 */
public class BibliotecaManager {
    private Map<String, Usuario> usuarios;
    private ArrayList<Libro> libros;
    private static BibliotecaManager instancia;
    
    private BibliotecaManager() {
        this.usuarios = new HashMap<>();
    }
    
    public static BibliotecaManager getInstancia(){
        if (instancia == null) {
            instancia = new BibliotecaManager();
        }
        return instancia;
    }
    
    public boolean validarCliente(Usuario usuario){
        if (usuarios.containsKey(usuario.getRut())) {
            return false;
        }
        return true;
    }
    
    public void agregarUsuario(Usuario usuario){
        usuarios.put(usuario.getRut(), usuario);
    }
    
    public Usuario buscarUsuario(String rut){
        return usuarios.get(rut);
    }
    
    public void mostrarInformacionUsuario(String rut){
        Usuario usuarioActivo = usuarios.get(rut);
        usuarioActivo.mostrarInformacionUsuario();
    }
    
}
