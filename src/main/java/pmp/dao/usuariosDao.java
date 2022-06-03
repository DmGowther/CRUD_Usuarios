/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pmp.dao;

import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
/**
 *
 * @author BrayanPeña
 */
public class usuariosDao {
    
    public static void setup() {
        String sqlCrearTabla = "CREATE TABLE IF NOT EXISTS USUARIOS (ID INTEGER PRIMARY KEY AUTOINCREMENT, EMAIL TEXT, ESTADO TEXT, PASSWORD TEXT, NOMBRE TEXT, AVATAR TEXT, F_INGRESO TEXT)";
        try {
            Statement cmd = Conexion.getConexion().createStatement();
            int  result = cmd.executeUpdate(sqlCrearTabla);
            cmd.close();
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
    //fin de la funcion setup
    
    public static ArrayList<Usuarios> VerTodos(){
        String sqlVerTodo = "SELECT * FROM USUARIOS;";
        ArrayList<Usuarios> usuarios = new ArrayList<>();
        try{
            Statement cmd = Conexion.getConexion().createStatement();
            ResultSet usuariosRows = cmd.executeQuery(sqlVerTodo);
            while (usuariosRows.next()){
                Usuarios usuario = new Usuarios();
                usuario.setId(usuariosRows.getInt("ID"));
                usuario.setCorreoElectronico(usuariosRows.getString("EMAIL"));
                usuario.setEstado(usuariosRows.getString("ESTADO"));
                usuario.setPassword(usuariosRows.getString("PASSWORD"));
                usuario.setNombre(usuariosRows.getString("NOMBRE"));
                usuario.setAvatar(usuariosRows.getString("AVATAR"));
                usuario.setFechaIngreso(usuariosRows.getString("F_INGRESO"));
                usuarios.add(usuario);
            }
            cmd.close();
            return usuarios;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
            return null;
        }
    }
    //fin de la funcion Mostrar todos
    
    public static Usuarios crearNuevoU(Usuarios nuevoUser){
        String sqlNuevoUsuario = "INSERT INTO USUARIOS (EMAIL, ESTADO, PASSWORD, NOMBRE, AVATAR, F_INGRESO) VALUES (?, ? , ?, ?, ?, ?);";
        try {
            PreparedStatement cmd = Conexion.getConexion().prepareStatement(sqlNuevoUsuario);
            cmd.setString(1, nuevoUser.getCorreoElectronico());
            cmd.setString(2, nuevoUser.getEstado());
            cmd.setString(3, nuevoUser.getPassword());
            cmd.setString(4, nuevoUser.getNombre());
            cmd.setString(5, nuevoUser.getAvatar());
            cmd.setString(6, nuevoUser.getFechaIngreso());
            
            int rIngresado = cmd.executeUpdate();
            cmd.close();
            return nuevoUser;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
            return null;
        } 
    }
    //fin de la funcion crear usuario
    
    public static Usuarios updateUser(Usuarios actUser) {
        String sqlAtualizar = "UPDATE USUARIOS set EMAIL=? , ESTADO=? , PASSWORD=? , NOMBRE=? , AVATAR=? ,F_INGRESO=? where ID=?;";
        try {
            PreparedStatement cmd = Conexion.getConexion().prepareStatement(sqlAtualizar);
            cmd.setString(1, actUser.getCorreoElectronico());
            cmd.setString(2, actUser.getEstado());
            cmd.setString(3, actUser.getPassword());
            cmd.setString(4, actUser.getNombre());
            cmd.setString(5, actUser.getAvatar());
            cmd.setString(6, actUser.getFechaIngreso());
            cmd.setInt(7, actUser.getId());
            int rActualizado = cmd.executeUpdate();
            cmd.close();
            return actUser;
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
            return null;
        }
    }
    //fin de la funcion actualizar
    
    public static int deleteUser(int EliminarUser) {
        String sqlEliminar = "DELETE FROM USUARIOS WHERE ID=?;";
        try {
            PreparedStatement cmd = Conexion.getConexion().prepareStatement(sqlEliminar);
            cmd.setInt(1, EliminarUser);
            int rEliminados = cmd.executeUpdate();
            cmd.close();
            return rEliminados; 
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
            return 0;
        }
    }
    //fin de la funcion eliminar
}
