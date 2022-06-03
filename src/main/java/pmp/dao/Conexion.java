/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pmp.dao;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author BrayanPeña
 */
public class Conexion {
        private static Connection conexion = null;
    
    private Conexion() {}
    
    public static Connection getConexion(){
        try {
            if(conexion == null) {
                Class.forName("org.sqlite.JDBC");
                conexion = DriverManager.getConnection("jdbc:sqlite:UsuarioExam.db");
            }
            return conexion;
        } catch(Exception e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
            return null;
        }
    } 
}
