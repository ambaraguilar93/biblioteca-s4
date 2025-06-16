/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.cl.semana4.utils;

import biblioteca.cl.semana4.manager.BibliotecaManager;
import biblioteca.cl.semana4.models.usuario.Usuario;
import biblioteca.cl.semana4.models.usuario.tipos.Administrador;
import biblioteca.cl.semana4.models.usuario.tipos.Estudiante;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author ambar
 */
public class Menu {
    private Scanner scanner;
    private BibliotecaManager bibliotecaManager;
    private Usuario usuarioActivo;
    
    
    public Menu(){
        scanner = new Scanner(System.in);
        bibliotecaManager = bibliotecaManager.getInstancia();
        usuarioActivo = null;
    }
    
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n===== BIBLIOTECA DUOC UC =====");
//            System.out.println("   Usuarios registrados: " + bankManager.getCantidadClientes());
            System.out.println("\n===== OPCIONES GENERALES =====");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Ver lista libros");
            System.out.println("3. Buscar libro");
            System.out.println("4. Pedir prestado libro");
            System.out.println("5. Ver informacion usuario");
            System.out.println("\n===== OPCIONES ADMINISTRADOR =====");
            System.out.println("6. Agregar libro");    
            System.out.println("\n=======================================");     
            System.out.println("Seleccione una opcion: ");
            
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcion = 0;
            }
            
            switch (opcion) {
                case 1:
                    registrarUsuario();
                    break;
                case 2:
                    //listarLibros();
                    break;
                case 3:
                    //buscarLibro();
                    break;
                case 4:
                    //pedirLibro();
                    break;
                case 5:
                    mostrarInformacionUsuario();
                    break;
                case 6:
                    //agregarLibro();
                    break;
                case 7:
                    System.out.println("Gracias por utilizar la app de biblioteca DUOC UC.");
                    break;
                default:
                    System.out.println("La opcion seleccionada no es valida.");
                    break;
            }
            
        } while (opcion != 7);
    }
    
    private void registrarUsuario(){
        System.out.println("\n ===== REGISTRO DE USUARIO =====");
        
        String rut;
        while (true) {
            System.out.print("Ingrese RUT (12.345.678-9, o deje vacío para cancelar: ");
            rut = scanner.nextLine();
            
            if (rut.isEmpty()) {
                System.out.println("Registro de cliente cancelado");
                return;
            }
            
            // Validar RUT y su formato
            if (!rut.matches("\\d{1,2}\\.\\d{3}\\.\\d{3}[-][0-9kK]{1}")) {
                System.out.println("Error: Formato de RUT no válido, debe ser 11.111.111-1");
                continue;
            }
        
            // Verificar si el cliente ya existe
            if (bibliotecaManager.buscarUsuario(rut) != null) {
                System.out.println("Error: Ya existe un cliente con ese RUT");
                continue;
            } else {
                break;
            }
        }
        
        String nombre;
        System.out.println("Ingrese su nombre: ");
        nombre = scanner.nextLine();
        
        String apellido;
        System.out.println("Ingrese su apellido: ");
        apellido = scanner.nextLine();
        
        int edad;
        
        while(true){
            try{
                System.out.println("Ingrese su edad: ");
                edad = Integer.parseInt(scanner.nextLine());
            
                if (edad > 0) {
                    break;
                }
                
                if (edad <= 0) {
                    System.out.println("La edad ingresada no es valida.");
                    continue;
                }
            } catch (InputMismatchException e){
                System.out.println("Ingrese una edad valida.");               
            }
            
        }
        
        String direccion;
        System.out.println("Ingrese su direccion: ");
        direccion = scanner.nextLine();
        
        int opcion;
        
        while(true){
            System.out.println("Seleccione su rol");
            System.out.println("1. Administrador | 2. Estudiante");
            
            try{               
                opcion = Integer.parseInt(scanner.nextLine());
                
                if (opcion == 1 || opcion == 2 ) {
                    break;
                }
                System.out.println("La opcion no es valida.");
                continue;
      
            } catch(NumberFormatException e){
                System.out.println("Entrada invalida. Ingrese un numero.");              
            }
            
        }
        
        try{
            if (opcion == 1) {
                Usuario nuevoUsuario = new Administrador(rut, nombre, apellido, edad, direccion, opcion );
                bibliotecaManager.agregarUsuario(nuevoUsuario);
                usuarioActivo = nuevoUsuario;
                System.out.println("Registro exitoso.");
            }
            
            if (opcion == 2) {
                Usuario nuevoUsuario = new Estudiante(rut, nombre, apellido, edad, direccion, opcion );
                bibliotecaManager.agregarUsuario(nuevoUsuario);
                usuarioActivo = nuevoUsuario;
                System.out.println("Registro exitoso.");
            }
        } catch(IllegalArgumentException  e){
            System.out.println("Error: "+e.getMessage());
        } 
    }
    
    private void mostrarInformacionUsuario(){
        
        if (usuarioActivo == null) {
            System.out.println("Error: registrese o identifiquese.");
            return;
        }
        
        bibliotecaManager.mostrarInformacionUsuario(usuarioActivo.getRut());
    }
}
