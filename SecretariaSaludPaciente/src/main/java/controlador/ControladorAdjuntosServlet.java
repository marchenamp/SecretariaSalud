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

        if ("subir".equals(accion)) {
            subirAdjunto(request, response);
        } else if ("descargar".equals(accion)) {
            descargarAdjunto(request, response);
        } else if ("eliminar".equals(accion)) {
            eliminarAdjunto(request, response);
        } else {
            // Manejar acción desconocida
        }
    }
    private void subirAdjunto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombreAdjunto = request.getParameter("nombreAdjunto");
        Part archivoPart = request.getPart("archivo");
        String tipoAdjunto = obtenerTipoAdjunto(archivoPart);

        // Guardar el archivo en el servidor
        String rutaGuardado = "/ruta/donde/guardar/adjuntos/";
        File archivoGuardado = new File(rutaGuardado + nombreAdjunto);
        try (InputStream inputStream = archivoPart.getInputStream()) {
            Files.copy(inputStream, archivoGuardado.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }

        // Aquí deberías almacenar el nombre del archivo, su tipo, la ruta de guardado y el ID del expediente en tu base de datos

        // Redireccionar a la página de origen
        response.sendRedirect("pagina-de-origen.jsp");
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
