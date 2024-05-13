/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
/**
 *
 * @author Hiram
 */
@WebServlet(name = "ControladorAdjuntosServlet")
public class ControladorAdjuntosServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorAdjuntosServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorAdjuntosServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if (null == accion) {
            processRequest(request, response);
        } else switch (accion) {
            case "subir":
                subirAdjunto(request, response);
                break;
            case "descargar":
                descargarAdjunto(request, response);
                break;
            case "eliminar":
                eliminarAdjunto(request, response);
                break;
            default:
                processRequest(request, response);
                break;
        }
    }
    private void subirAdjunto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombreAdjunto = request.getParameter("nombreAdjunto");
        Part archivoPart = request.getPart("archivo");
        String tipoAdjunto = obtenerTipoAdjunto(archivoPart);

        // Guardar el archivo en el servidor
        String rutaGuardado = "files/";
        File archivoGuardado = new File(rutaGuardado + nombreAdjunto);
        try (InputStream inputStream = archivoPart.getInputStream()) {
            Files.copy(inputStream, archivoGuardado.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }

        // Obtener conexión a la base de datos
        Connection conn = null;
        try {
            // Crear una instancia de la clase de conexión
            Conexion conexion = new Conexion();
            conn = conexion.getConexion();

            // Preparar la consulta SQL para insertar los datos del archivo adjunto
            String sql = "INSERT INTO archivos_adjuntos (id_expediente, nombre_archivo, tipo_archivo, ruta_archivo) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(request.getParameter("idExpediente")));
            stmt.setString(2, nombreAdjunto);
            stmt.setString(3, tipoAdjunto);
            stmt.setString(4, rutaGuardado + nombreAdjunto);

            // Ejecutar la consulta SQL
            stmt.executeUpdate();

            // Cerrar el statement
            stmt.close();
        } catch (SQLException e) {
            // Manejar excepciones SQL
            e.printStackTrace();
        } finally {
            // Cerrar la conexión
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                // Manejar excepciones SQL
                e.printStackTrace();
            }
        }

        // Redireccionar a la página de archivos
        response.sendRedirect("archivos.jsp");
    }



    private void descargarAdjunto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lógica para descargar un archivo adjunto
    }

    private void eliminarAdjunto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lógica para eliminar un archivo adjunto
    }

    private String obtenerTipoAdjunto(Part archivoPart) {
        // Lógica para obtener el tipo de archivo adjunto
        return archivoPart.toString();
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
