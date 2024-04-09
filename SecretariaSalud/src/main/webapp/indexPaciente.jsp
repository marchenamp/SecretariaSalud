<%-- 
    Document   : indexPaciente
    Created on : 8 abr 2024, 22:51:36
    Author     : march
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Expediente clinico electronico</title>
        <link rel="stylesheet" href="CSS/estilos.css">
    </head>

    <body>
        <header>
            <div class="logo-container">
                <img src="IMG/2622355.png" alt="logo" class="logo">
            </div>
            <div class="title-container">
                <h1>Expediente Clínico</h1>
            </div>
        </header>
        <div class="body-styles">
            <!-- Formulario de inicio de sesión -->
            <div class="login-form">
                <h2>INICIO DE SESIÓN</h2>
                <form action="menuMedico.html" method="POST">
                    <label for="correo">Correo:</label>
                    <input type="text" id="cedula" name="cedula" placeholder="Ingrese su cédula profesional">

                    <label for="clave">Clave:</label>
                    <input type="password" id="clave" name="clave" placeholder="Ingrese su clave" required>

                    <button type="submit">Ingresar</button>
                </form>
                <br>
                <div style="text-align: center;">
                    <a  style="color: white;" href="registrarPaciente.jsp">¿No estas registrado? Registrate aquí!</a>
                </div>
                <br>
                <div style="text-align: center;">
                    <a  style="color: white;" href="index.jsp">Soy médico</a>
                </div>
            </div>
        </div> 
        <footer>
            <img src="IMG/secretarialogo.png" alt="Logo secretaria de salud" class="logo-secretaria">
        </footer>
    </body>

</html>
