/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.*;

@WebServlet("/mostrarArchivosAdjuntos")
public class MostrarArchivosAdjuntosServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener el ID del expediente médico de la solicitud
        int idExpediente = Integer.parseInt(request.getParameter("idExpediente"));

        // Crear una instancia de la clase Conexion para obtener la conexión a la base de datos
        Conexion conexion = new Conexion();
        Connection conn = conexion.getConexion();

        // Consulta SQL para recuperar los archivos adjuntos asociados al expediente médico
        String sql = "SELECT * FROM archivos_adjuntos WHERE id_expediente = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, idExpediente);
            ResultSet resultSet = statement.executeQuery();

            List<Archivo> archivos = new ArrayList<>();
            while (resultSet.next()) {
                int idArchivo = resultSet.getInt("id_archivo");
                String nombreArchivo = resultSet.getString("nombre_archivo");
                String tipoArchivo = resultSet.getString("tipo_archivo");
                String rutaArchivo = resultSet.getString("ruta_archivo");

                Archivo archivo = new Archivo(idArchivo, idExpediente, nombreArchivo, tipoArchivo, rutaArchivo);
                archivos.add(archivo);
            }

            // Agregar la lista de archivos adjuntos al request para que pueda ser accesible desde la página JSP
            request.setAttribute("archivos", archivos);

            // Redirigir a la página JSP que mostrará los archivos adjuntos
            request.getRequestDispatcher("mostrarArchivos.jsp").forward(request, response);
        } catch (SQLException e) {
            // Manejar excepciones SQL
            e.printStackTrace();
        } finally {
            // Cerrar la conexión a la base de datos
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                // Manejar excepciones SQL
                e.printStackTrace();
            }
        }
    }
}
