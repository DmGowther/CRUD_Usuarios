/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.pmp.examenusuarios;
import java.util.Scanner;
import java.util.ArrayList;
import pmp.dao.Usuarios;
import pmp.dao.usuariosDao;
/**
 *
 * @author BrayanPeña
 */
public class ExamenUsuarios {
    
    private static Scanner keyInput;
    private static String opcion = "M";
    private static ArrayList<Usuarios> usuarios;
    
    private static void init(){
        keyInput = new Scanner(System.in);
        usuariosDao.setup();
        usuarios = new ArrayList<>();        
    }
    //fin de la funcion init
    
    public static void main(String[] args) {
        init();
        while (!opcion.equalsIgnoreCase("S")) {            
            PrintUtilitities.printMenu();
            opcion = PrintUtilitities.readInput(keyInput, "Escriba la opcion a ejecutar: ", "M");
            
            switch (opcion.toUpperCase()) {
                case "C":
                    crearUser();
                    break;
                case "U":
                    mostrarUsuarios();
                    updateUsuarios();
                    break;
                case "E":
                    mostrarUsuarios();
                    deleteUser();
                    break;
                case "M":
                    mostrarUsuarios();
                    break;
                case "S":
                    PrintUtilitities.print("Sistema cerrado, Adios.");
                    break;
            }
        }
    }
    
   // fin del main
    
    private static void mostrarUsuarios(){
        usuarios = usuariosDao.VerTodos();
        PrintUtilitities.print("\n--------------------------------------------------------------------------------------------------------------------------------------------");
            PrintUtilitities.print("\t\t\t\t\t\t\t >>>>USUARIOS EXISTENTES<<<<");
            PrintUtilitities.print("--------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < usuarios.size(); i++) {
            Usuarios punteroUsuario = usuarios.get(i);            
            System.out.println(punteroUsuario.printString());
        }
    }
    //fin de la funcion mostrar usuarios
    
    private static void crearUser(){
        PrintUtilitities.print("\n--------------------------------------------------------------------------------------------------------------------------------------------");
            PrintUtilitities.print("\t\t\t\t\t\t\t >>>>>>>CREAR USUARIO<<<<<<<");
            PrintUtilitities.print("--------------------------------------------------------------------------------------------------------------------------------------------");
        String email = PrintUtilitities.readInput(keyInput, "Email", "Email usuario");
        String estado = PrintUtilitities.readInput(keyInput, "Estado", "Activo");
        String password = PrintUtilitities.readInput(keyInput, "Contraseña", "password");
        String nombre = PrintUtilitities.readInput(keyInput, "Nombre", "Nuevo usuario");
        String avatar = PrintUtilitities.readInput(keyInput, "Avatar", "Si");
        String fIngreso = PrintUtilitities.readInput(keyInput, "Fecha de ingreso", "01/06/22");
        
        Usuarios newUser = new Usuarios();
        newUser.setCorreoElectronico(email);
        newUser.setEstado(estado);
        newUser.setPassword(password);
        newUser.setNombre(nombre);
        newUser.setAvatar(avatar);
        newUser.setFechaIngreso(fIngreso);
        
        usuariosDao.crearNuevoU(newUser);
        usuarios = usuariosDao.VerTodos();
    }
    //fin de la funcion crear usuarios
    
    private static void updateUsuarios(){
        int idActualizacion = Integer.parseInt(PrintUtilitities.readInput(keyInput, "Id del usuario a modificar", ""));
        if (idActualizacion == 0) {
            PrintUtilitities.print("Error, el codigo ingresado no existe y/o no se encuentra.");            
        } else {
            Usuarios userToUpdate = null;
            for (int i = 0; i < usuarios.size(); i++) {
                if (usuarios.get(i).getId() == idActualizacion) {
                    userToUpdate = usuarios.get(i);
                    break;
                }
            }
            if (userToUpdate == null) {                
                PrintUtilitities.print("Error, el codigo ingresado no existe y/o no se encuentra.");  
            } else {
                 PrintUtilitities.print("\n--------------------------------------------------------------------------------------------------------------------------------------------");
            PrintUtilitities.print("\t\t\t\t\t\t\t >>>>USUARIO A MODIFICAR<<<<");
            PrintUtilitities.print("--------------------------------------------------------------------------------------------------------------------------------------------");
                PrintUtilitities.print(userToUpdate.printString());
                PrintUtilitities.print("--------------------------------------------------------------------------------------------------------------------------------------------");
                userToUpdate.setCorreoElectronico(PrintUtilitities.readInput(keyInput, "Email", userToUpdate.getCorreoElectronico()));
                userToUpdate.setEstado(PrintUtilitities.readInput(keyInput, "Estado", userToUpdate.getEstado()));
                userToUpdate.setPassword(PrintUtilitities.readInput(keyInput, "Contraseña", userToUpdate.getPassword()));
                userToUpdate.setNombre(PrintUtilitities.readInput(keyInput, "Nombre", userToUpdate.getNombre()));
                userToUpdate.setAvatar(PrintUtilitities.readInput(keyInput, "Avatar", userToUpdate.getAvatar()));
                userToUpdate.setFechaIngreso(PrintUtilitities.readInput(keyInput, "Fecha de ingreso", userToUpdate.getFechaIngreso()));
                PrintUtilitities.print("--------------------------------------------------------------------------------------------------------------------------------------------");
                usuariosDao.updateUser(userToUpdate);
                usuarios = usuariosDao.VerTodos();
            }
        }
    }
    // fin de la funcion de actulizacion de usuario
    
    private static void deleteUser(){
        int idDelete = Integer.parseInt(PrintUtilitities.readInput(keyInput, "Id del usuario a eliminar", ""));
        if (idDelete == 0) {
            PrintUtilitities.print("Error, el codigo ingresado no existe y/o no se encuentra.");            
        } else {
            Usuarios userToDelete = null;
            for (int i = 0; i < usuarios.size(); i++) {
                if (usuarios.get(i).getId() == idDelete) {
                    userToDelete = usuarios.get(i);
                    break;
                }
            }
            if (userToDelete == null) {                
                PrintUtilitities.print("Error, el codigo ingresado no existe y/o no se encuentra.");  
            } else {
                PrintUtilitities.print("\n--------------------------------------------------------------------------------------------------------------------------------------------");
            PrintUtilitities.print("\t\t\t\t\t\t\t >>>>USUARIO A ELIMINAR<<<<");
            PrintUtilitities.print("--------------------------------------------------------------------------------------------------------------------------------------------");
                PrintUtilitities.print(userToDelete.printString());
                PrintUtilitities.print("--------------------------------------------------------------------------------------------------------------------------------------------");
                String Confirmacion = PrintUtilitities.readInput(keyInput, "¿Desea eliminar este usuario? (S/N)", "N");
                if (Confirmacion.equalsIgnoreCase("S")) {
                    usuariosDao.deleteUser(userToDelete.getId());
                    PrintUtilitities.print("El usuario fue eliminado con exito.\n");
                    usuarios = usuariosDao.VerTodos();
                } else {
                    PrintUtilitities.print("La eliminacion del usuario fue cancelada.\n");
                }                
                System.out.println("----------------------------------------");
            }
        }
    } 
    //fin de la funcion de eliminacion de un usuario
                
}
