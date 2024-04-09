/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import modelo.EstadoCivil;
import modelo.Genero;
import modelo.Tutor;

/**
 *
 * @author march
 */
public class ConsultasPaciente extends Conexion{

    public ConsultasPaciente() {
    }
    
    private boolean pacienteExistente(int id) {
        try {
            String consulta = "SELECT id_paciente FROM pacientes WHERE id_paciente = ?";
            PreparedStatement pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            System.err.println("Error al verificar el id del paciente existente: " + e);
        }
        return false;
    }
    
    public boolean registrarPaciente(String nombres, String apellidoPaterno, String apellidoMaterno, String correo, String password, Date fechaNacimiento, String telefono, EstadoCivil estadoCivil, Genero genero) {
        PreparedStatement pst = null;
        try {
            String consulta = "INSERT INTO pacientes (nombres, apellidopaterno, apellidomaterno, correo, password, fecha_nacimiento, telefono, estado_civil, genero) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, nombres);
            pst.setString(2, nombres);
            pst.setString(3, nombres);
            pst.setString(4, nombres);
            pst.setString(5, nombres);
            pst.setDate(6, fechaNacimiento);
            pst.setString(7, nombres);
            pst.setString(8, estadoCivil.name());
            pst.setString(9, genero.name());

            if (pst.executeUpdate() == 1) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error en: " + e);
        } finally {
//            try {
//                if (getConexion() != null) {
//                    getConexion().close();
//                }
//                if (pst != null) {
//                    pst.close();
//                }
//            } catch (Exception e) {
//                System.err.println("Error en: " + e);
//            }
        }
        return false;
    }
    
    public boolean registrarPacienteConTutor(String nombres, String apellidoPaterno, String apellidoMaterno, String correo, String password, Date fechaNacimiento, String telefono, EstadoCivil estadoCivil, Genero genero, Tutor tutor) {
        PreparedStatement pst = null;
        try {
            String consulta = "INSERT INTO pacientes (nombres, apellidopaterno, apellidomaterno, correo, password, fecha_nacimiento, telefono, estado_civil, genero, id_tutor) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, nombres);
            pst.setString(2, nombres);
            pst.setString(3, nombres);
            pst.setString(4, nombres);
            pst.setString(5, nombres);
            pst.setDate(6, fechaNacimiento);
            pst.setString(7, nombres);
            pst.setString(8, estadoCivil.name());
            pst.setString(9, genero.name());
            pst.setInt(10, tutor.getId());

            if (pst.executeUpdate() == 1) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error en: " + e);
        } finally {
//            try {
//                if (getConexion() != null) {
//                    getConexion().close();
//                }
//                if (pst != null) {
//                    pst.close();
//                }
//            } catch (Exception e) {
//                System.err.println("Error en: " + e);
//            }
        }
        return false;
    }
    
    
}
