<%-- 
    Document   : expedientes
    Created on : 6 may 2024, 12:16:14
    Author     : magda
--%>

<%@page import="modelo.Archivo"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession objSesion=request.getSession(false);
    String paciente=(String)objSesion.getAttribute("nombres");
    if(paciente == null){
        paciente = "";
    }
%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Expedientes Clínicos</title>
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
    </header>

    <%
        if (paciente != ""){
    %>

    <h2>¡BIENVENIDO(A) <% out.println(paciente);%>!</h2>

    <%
        }
    %>

    <%
        if (paciente == ""){
    %>

    <h2>¡BIENVENIDO(A)!</h2>

    <%
        }
    %>
    <div class="body-styles">
        <div class="tabla-container">
            <table>
                <caption><h3>Expedientes:</h3></caption>
                <thead>
                    <tr>
                        <th>ID - Expediente</th>
                        <th>Nombre</th>
                        <th>Tipo</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <%-- Aquí agregamos una sección para mostrar los archivos adjuntos --%>
                    <%
                        // Suponiendo que la lista de archivos adjuntos asociados al expediente no esta vacia
                        List<Archivo> archivos = (List<Archivo>) request.getAttribute("archivos");
                        if (archivos != null) {
                            for (Archivo archivo : archivos) {
                    %>
                    <tr>
                        <td><%= archivo.getIdExpediente() %></td>
                        <td><%= archivo.getNombre()%></td>
                        <td><%= archivo.getTipo()%></td>
                    </tr>
                    <%
                            }
                        }
                    %>
                </tbody>

            </table>
        </div>

        <div class="botones">
            <button id="regresar-btn" onclick="window.location.href = 'menuPaciente.jsp';">Regresar</button>
            <!-- Botón de agregar -->
            <form id="agregarForm" enctype="multipart/form-data" action="SubirArchivo" method="post">
                <input type="hidden" name="idExpediente" value="<%= paciente %>">
                <input type="file" name="archivo" id="archivo">
                <button type="submit" id="agregar-btn">Agregar</button>
            </form>
        </div>
    </div>
    <footer>
        <img src="IMG/secretarialogo.png" alt="Logo secretaria de salud" class="logo-secretaria">
    </footer>

    </body>

</html>