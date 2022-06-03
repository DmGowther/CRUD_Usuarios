/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmp.examenusuarios;
import java.util.Scanner;


/**
 *
 * @author BrayanPeña
 */
public class PrintUtilitities {
    
    public static void printTitle(String headerText) {
        System.out.println("---------------------------");
        System.out.println(headerText);
        System.out.println("---------------------------");      
        
    }
    
     public static String readInput( Scanner keyInput, String label, String defaultValue) {
        System.out.println("");
        System.out.println(label + " < " + defaultValue + " > :");
        String inputValue = keyInput.nextLine();
        if (inputValue.isEmpty() || inputValue.isBlank()) {
            inputValue = defaultValue;
        }
        return inputValue;
    }
    
     public static void printMenu() {
        System.out.println("\n=======================================");
        System.out.println("--------------[ OPCIONES ]-------------");
        System.out.println("=======================================");        
        System.out.println("M > Mostrar Usuarios");
        System.out.println("C > Crear nuevo Usuario");
        System.out.println("U > Editar Usuarios");
        System.out.println("E > Eliminar Usuarios");
        System.out.println("S > Salir");
        System.out.println("=======================================");    

     }
     
     public static void print(String text){
        System.out.println(text);
    }
}
