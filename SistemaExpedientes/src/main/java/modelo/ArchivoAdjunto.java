/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.File;

/**
 *
 * @author Hiram
 */
class ArchivoAdjunto {
    
    private int id;
    private int id_Expediente;
    private String nombreArchivo;
    private File tipoArchivo;
    private byte[] datos; // Datos binarios del archivo
    
    public ArchivoAdjunto(int id, int id_Expediente, String nombreArchivo, File tipoArchivo, byte[] datos) {
            this.id = id;
            this.id_Expediente = id_Expediente;
            this.nombreArchivo = nombreArchivo;
            this.tipoArchivo = tipoArchivo;
            this.datos = datos;
    }
    public ArchivoAdjunto(int id, String nombreArchivo, File tipoArchivo, byte[] datos) {
        this.id = id;
        this.nombreArchivo = nombreArchivo;
        this.tipoArchivo = tipoArchivo;
        this.datos = datos;
    }
    
    public int getId_Expediente() {
        return id_Expediente;
    }

    // Otros constructores y getters/setters
    public void setId_Expediente(int id_Expediente) {    
        this.id_Expediente = id_Expediente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public File getTipoArchivo() {
        return tipoArchivo;
    }

    public void setTipoArchivo(File tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }

    public byte[] getDatos() {
        return datos;
    }

    public void setDatos(byte[] datos) {
        this.datos = datos;
    }
    
}
