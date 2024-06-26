<%-- 
    Document   : menuMedico
    Created on : 6 may 2024, 14:35:24
    Author     : magda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession objSesion = request.getSession(false);
    String medico = (String) objSesion.getAttribute("nombres");
    String correo = (String) objSesion.getAttribute("correo");
    String idMedico = (String) objSesion.getAttribute("id");
%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Menú - Médico</title>
        <link rel="stylesheet" href="CSS/estilos.css">
    </head>

    <body>
        <header>
            <div class="logo-container">
                <img src="IMG/logoSS.png" alt="logo" class="logoSS">
            </div>
            <div class="title-container">
                <h1>Secretaría de Salud</h1>
            </div>

            <div class="dropdown">
                <button class="dropbtn" id="btnUsuario">
                    <i class="fa fa-user-circle" aria-hidden="true" id="icon"></i>
                    <% out.println(correo); %>
                </button>
                <div class="dropdown-content">
                    <a href="CerrarSesion"><i class="fa fa-sign-out" aria-hidden="true"></i> Cerrar Sesión</a>
                </div>
            </div>

        </header>
        <h2>¡BIENVENIDO(A) <% out.println(medico);%>!</h2>
        <br>
        <h2>MENÚ</h2>
        <div class="body-styles">

            <div class="grid-medico">
                <div class="item1-medico">
                    <button class="registrarCita-btn" onclick="window.location.href = 'citasAgendadas.jsp';"> 
                        <img src="IMG/registrarCita.png" alt="Citas Agendadas" id="registrarCita-icon"/>
                        <h3>Ver citas agendadas</h3>
                    </button>
                </div>

                <div class="item2-medico">
                    <button class="registrarCita-btn" onclick="window.location.href = 'permisosOtorgados.jsp';"> 
                        <img src="IMG/permisos.png" alt="Permisos Otorgados" id="registrarCita-icon"/>
                        <h3>Ver permisos otorgados</h3>
                    </button>
                </div>
            </div>

        </div>
        <footer>
            <img src="IMG/secretarialogo.png" alt="Logo secretaria de salud" class="logo-secretaria">
        </footer>
    </body>

</html>
