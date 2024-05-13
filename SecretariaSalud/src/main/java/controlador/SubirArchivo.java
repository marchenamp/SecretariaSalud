/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.DataSource;

@WebServlet("/SubirArchivo")
public class SubirArchivo extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DataSource dataSource;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Obtiene el ID del expediente y el archivo adjunto del formulario
        String idExpedienteStr = request.getParameter("idExpediente");
        Part archivoPart = request.getPart("archivo");

        if (idExpedienteStr == null || archivoPart == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Faltan parámetros en la solicitud");
            return;
        }

        int idExpediente = Integer.parseInt(idExpedienteStr);
        String nombreArchivo = archivoPart.getSubmittedFileName();
        String tipoArchivo = archivoPart.getContentType();

        try (InputStream archivoInputStream = archivoPart.getInputStream();
             Connection conn = dataSource.getConnection()) {

            // Inserta el archivo adjunto en la base de datos
            String sql = "INSERT INTO archivos_adjuntos (id_expediente, nombre_archivo, tipo_archivo, ruta_archivo) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, idExpediente);
                stmt.setString(2, nombreArchivo);
                stmt.setString(3, tipoArchivo);
                stmt.setString(4, "/ruta/donde/se/guarda/el/archivo"); // Reemplaza esto con la ruta real donde se guarda el archivo

                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected == 1) {
                    // Éxito: el archivo adjunto se agregó correctamente
                    response.getWriter().write("El archivo se ha agregado correctamente al expediente.");
                } else {
                    // Si no se pudo agregar el archivo, envía un código de error
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "No se pudo agregar el archivo.");
                }
            }
        } catch (SQLException e) {
            throw new ServletException("Error al agregar archivo adjunto", e);
        }
    }
}
