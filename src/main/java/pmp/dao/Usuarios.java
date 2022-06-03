/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pmp.dao;

/**
 *
 * @author BrayanPeña
 */
public class Usuarios {

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the correoElectronico
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * @param correoElectronico the correoElectronico to set
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * @param avatar the avatar to set
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * @return the fechaIngreso
     */
    public String getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * @param fechaIngreso the fechaIngreso to set
     */
    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
    public Usuarios(){
        
    }
    
    public Usuarios(int id, String correoElectronico, String estado, String password, String nombre, String avatar, String fechaIngreso ){
        this.id = id;
        this.correoElectronico = correoElectronico;
        this.estado = estado;
        this.password = password;
        this.nombre = nombre;
        this.avatar = avatar;
        this.fechaIngreso = fechaIngreso;
    }
    
    public String printString(){
        return String.valueOf(id) + "\t\t" + correoElectronico + "\t\t" + estado + "\t\t" + password + "\t\t" + nombre + "\t\t" + avatar + "\t\t" + fechaIngreso;
    }
    
    private int id;
    private String correoElectronico;
    private String estado;
    private String password;
    private String nombre;
    private String avatar;
    private String fechaIngreso;
    
}
