/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import modelo.Paciente;

/**
 *
 * @author march
 */
@WebServlet(name = "CRUDExpediente", urlPatterns = {"/CRUDExpediente"})
public class CRUDExpediente extends HttpServlet {

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
        PrintWriter out = response.getWriter();

        String botonRegistrar = request.getParameter("RegistrarExpediente");

        ConsultasExpediente sqlExpediente = new ConsultasExpediente();
        ConsultasPaciente sqlPaciente = new ConsultasPaciente();

        if (botonRegistrar != null) {
            String tipoSangre = request.getParameter("tipoSangre");
            String estatura= request.getParameter("estatura");
            float peso = Float.parseFloat(request.getParameter("peso"));
            String alergias = request.getParameter("alergias");
            String frecuenciaCardiaca = request.getParameter("frecuenciaCardiaca");
            String padecimientosPersonales = request.getParameter("padecimientosPersonales");
            String antecedentesHereditarios = request.getParameter("antecedentesHereditarios");
            String nombreContactoEmergencia = request.getParameter("nombreContactoEmergencia");
            String telefonoContactoEmergencia = request.getParameter("numeroContactoEmergencia");
            String cadenaIdPaciente = request.getParameter("idPaciente");
            cadenaIdPaciente = cadenaIdPaciente.trim();
            cadenaIdPaciente = cadenaIdPaciente.replace("\n", "");
            int idPaciente = Integer.parseInt(cadenaIdPaciente);
            
            if (sqlExpediente.registrarExpediente(tipoSangre, estatura, peso, alergias, frecuenciaCardiaca, padecimientosPersonales, antecedentesHereditarios, nombreContactoEmergencia, telefonoContactoEmergencia, idPaciente)) {
                request.setAttribute("txt-exito", "Registro de expediente exitoso");
            } else {
                request.setAttribute("txt-exito", "Registro de expediente fallido");
            }
            RequestDispatcher rd = request.getRequestDispatcher("registrarExpediente.jsp");
            rd.forward(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
