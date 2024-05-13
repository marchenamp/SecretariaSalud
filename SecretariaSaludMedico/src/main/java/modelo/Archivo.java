/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author march
 */
public class Archivo {

    private int id;
    private String nombre;
    private String tipo;
    private byte[] contenido; // Para almacenar el contenido binario del archivo
    private int idExpediente;

    public Archivo() {
    }

    public Archivo(String nombre, String tipo, byte[] contenido, int idExpediente) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.contenido = contenido;
        this.idExpediente = idExpediente;
    }

    public Archivo(int id, String nombre, String tipo, byte[] contenido, int idExpediente) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.contenido = contenido;
        this.idExpediente = idExpediente;
    }

    public Archivo(int idArchivo, int idExpediente, String nombreArchivo, String tipoArchivo, String rutaArchivo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdExpediente() {
        return idExpediente;
    }

    public void setIdExpediente(int idExpediente) {
        this.idExpediente = idExpediente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public byte[] getContenido() {
        return contenido;
    }

    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }
}
