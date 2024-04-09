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
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.EstadoCivil;
import modelo.Genero;
import modelo.Tutor;

/**
 *
 * @author march
 */
@WebServlet(name = "CRUDPaciente", urlPatterns = {"/CRUDPaciente"})
public class CRUDPaciente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.text.ParseException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String botonRegistrar = request.getParameter("RegistrarPaciente");

        ConsultasPaciente sqlPaciente = new ConsultasPaciente();
        ConsultasTutor sqlTutor = new ConsultasTutor();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

        if (botonRegistrar != null) {
            String nombresTutor = request.getParameter("nombreTutor");
            String apellidoPaternoTutor = request.getParameter("apellidoPaternoTutor");
            String apellidoMaternoTutor = request.getParameter("apellidoMaternoTutor");

            String fechaNacimientoTutorString = request.getParameter("fechaNacimientoTutor");
            java.util.Date fechaUtilTutor = formatoFecha.parse(fechaNacimientoTutorString);
            Date fechaNacimientoTutor = new Date(fechaUtilTutor.getTime());

            String telefonoTutor = request.getParameter("telefonoTutor");
            Genero generoTutor = Genero.valueOf(request.getParameter("generoTutor"));
            String parentescoTutor = request.getParameter("parentescoTutor");
            if (nombresTutor == null) {
                String nombresPaciente = request.getParameter("nombresPaciente");
                String apellidoPaternoPaciente = request.getParameter("apellidoPaternoPaciente");
                String apellidoMaternoPaciente = request.getParameter("apellidoMaternoPaciente");
                String correoPaciente = request.getParameter("correoPaciente");
                String passwordPaciente = request.getParameter("passwordPaciente");

                String fechaNacimientoPacienteString = request.getParameter("fechaNacimientoPaciente");
                java.util.Date fechaUtilPaciente = formatoFecha.parse(fechaNacimientoPacienteString);
                Date fechaNacimientoPaciente = new Date(fechaUtilPaciente.getTime());

                String telefonoPaciente = request.getParameter("nombreCliente");
                EstadoCivil estadoCivilPaciente = EstadoCivil.valueOf(request.getParameter("nombreCliente"));
                Genero generoPaciente = Genero.valueOf(request.getParameter("nombreCliente"));
                int idTutorPaciente = Integer.parseInt(request.getParameter("nombreCliente"));
                Tutor tutorPaciente = sqlTutor.buscarTutor(idTutorPaciente);

                if (sqlPaciente.registrarPacienteConTutor(nombresPaciente, apellidoPaternoPaciente, apellidoMaternoPaciente, correoPaciente, passwordPaciente, fechaNacimientoPaciente, telefonoPaciente, estadoCivilPaciente, generoPaciente, tutorPaciente)) {
                    request.setAttribute("txt-exito", "Registro de paciente exitoso");
                } else {
                    request.setAttribute("txt-exito", "Registro de paciente fallido");
                }
            } else {
                if (sqlTutor.registrarTutor(nombresTutor, apellidoPaternoTutor, apellidoMaternoTutor, fechaNacimientoTutor, telefonoTutor, generoTutor, parentescoTutor)) {
                    String nombresPaciente = request.getParameter("nombresPaciente");
                    String apellidoPaternoPaciente = request.getParameter("apellidoPaternoPaciente");
                    String apellidoMaternoPaciente = request.getParameter("apellidoMaternoPaciente");
                    String correoPaciente = request.getParameter("correoPaciente");
                    String passwordPaciente = request.getParameter("passwordPaciente");

                    String fechaNacimientoPacienteString = request.getParameter("fechaNacimientoPaciente");
                    java.util.Date fechaUtilPaciente = formatoFecha.parse(fechaNacimientoPacienteString);
                    Date fechaNacimientoPaciente = new Date(fechaUtilPaciente.getTime());

                    String telefonoPaciente = request.getParameter("telefonoPaciente");
                    EstadoCivil estadoCivilPaciente = EstadoCivil.valueOf(request.getParameter("estadoCivilPaciente"));
                    Genero generoPaciente = Genero.valueOf(request.getParameter("generoPaciente"));
                    Tutor tutorPaciente = sqlTutor.buscarUltimoTutorRegistrado();

                    if (sqlPaciente.registrarPacienteConTutor(nombresPaciente, apellidoPaternoPaciente, apellidoMaternoPaciente, correoPaciente, passwordPaciente, fechaNacimientoPaciente, telefonoPaciente, estadoCivilPaciente, generoPaciente, tutorPaciente)) {
                        request.setAttribute("txt-exito", "Registro de paciente exitoso");
                    } else {
                        request.setAttribute("txt-exito", "Registro de paciente fallido");
                    }
                } else {
                    request.setAttribute("txt-exito", "Registro de paciente fallido");
                }
            }
            RequestDispatcher rd = request.getRequestDispatcher("indexPaciente.jsp");
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(CRUDPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(CRUDPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
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
