<%-- 
    Document   : registrarMedico
    Created on : 30 abr 2024, 23:48:26
    Author     : march
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Registro de Paciente</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
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
            <div class="register-form">
                <form action="ServletMedico" method="post">
                    <div class="heading">
                        <h2>REGISTRO DE MÉDICO</h2>
                    </div>

                    <div class="container">
                        <div class="row">
                            <div class="col">
                                <label for="nombre">Nombre(s):</label>
                                <input type="text" name="nombreMedico" placeholder="Ingrese su(s) nombre(s)" onkeypress="return soloLetras(event)" title="Ingrese únicamente letras" maxlength="255" required>
                            </div>
                            <div class="col">
                                <label for="apellidoPaterno">Apellido Paterno:</label>
                                <input type="text" name="apellidoPaternoMedico" placeholder="Ingrese su apellido paterno" onkeypress="return soloLetras(event)" maxlength="255" required>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col">
                                <label for="apellidoMaterno">Apellido Materno:</label>
                                <input type="text" name="apellidoMaternoMedico" placeholder="Ingrese su apellido materno" onkeypress="return soloLetras(event)" maxlength="255" required>
                            </div>
                            <div class="col">
                                <label for="fechaNacimiento">Fecha de Nacimiento:</label>
                                <input name="fechaNacimientoMedico" type="date" id="fecha" class="form-control" id="fecha" required onchange="mostrarTutor()">
                            </div>
                        </div>

                        <div class="row">
                            <div class="col">
                                <label for="genero">Género:</label>
                                <select id="genero" name="generoMedico">
                                    <option value="seleccione">Seleccione su género</option>
                                    <option value="FEMENINO">Femenino</option>
                                    <option value="MASCULINO">Masculino</option>
                                    <option value="NO_BINARIO">No binario</option>
                                </select>
                            </div>
                            <div class="col">
                                <label for="telefono">Teléfono:</label>
                                <input type="tel" name="telefonoMedico" placeholder="Ingrese su número telefónico" maxlength="10" oninput="this.value = this.value.replace(/[^0-9]/g, '').slice(0, 10);" title="Ingrese solo números (máximo 10 dígitos)" required>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col">
                                <label for="email">Correo Electrónico:</label>
                                <input type="email" name="emailMedico" placeholder="Ingrese su correo electrónico" maxlength="255" pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}" title="Debe coincidir con el formato de un correo electrónico." required>
                            </div>
                            <div class="col">
                                <label for="cedulaProfesional">Cédula Profesional:</label>
                                <input type="text" name="cedulaProfesionalMedico" placeholder="Ingrese su cédula profesional"  maxlength="8" oninput="this.value = this.value.replace(/[^0-9]/g, '').slice(0, 8);" title="Ingrese solo números (máximo 8 dígitos)" required>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="col">
                                <label for="especialidadMedica">Especialidad Médica:</label>
                                <input type="text" name="especialidadMedica" placeholder="Ingrese su especialidad médica" maxlength="255" required>
                            </div>
                            <div class="col">
                                <label for="lugarTrabajoActual">Lugar de Trabajo Actual:</label>
                                <input type="text" name="lugarTrabajoActual" placeholder="Ingrese su lugar de trabajo actual"  maxlength="255" required>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col">
                                <label for="password">Contraseña:</label>
                                <input name="passwordMedico" type="password" id="txtPassword" placeholder="Ingrese su contraseña" pattern="(?=.*\d)(?=.*[a-záéíóúüñ]).*[A-ZÁÉÍÓÚÜÑ].*" title="Debe tener al menos una mayúscula, una minúscula y un dígito" minlength="8" maxlength="20" required> 
                                <br>
                                <input name="repass" type="password" id="txtRepassword" placeholder="Ingrese nuevamente su contraseña" pattern="(?=.*\d)(?=.*[a-záéíóúüñ]).*[A-ZÁÉÍÓÚÜÑ].*" title="Debe tener al menos una mayúscula, una minúscula y un dígito" minlength="8" maxlength="20" required>
                            </div>
                        </div>

                        <div class="row">
                            <button type="submit" id="form-submit" name="RegistrarMedico" onclick="alerta()" class="btn">Registrar</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <footer>
            <img src="IMG/secretarialogo.png" alt="Logo secretaria de salud" class="logo-secretaria">
        </footer>

        <script type="text/javascript">
            $(document).ready(function () {
                // navigation click actions 
                $('.scroll-link').on('click', function (event) {
                    event.preventDefault();
                    var sectionID = $(this).attr("data-id");
                    scrollToID('#' + sectionID, 750);
                });
                // scroll to top action
                $('.scroll-top').on('click', function (event) {
                    event.preventDefault();
                    $('html, body').animate({scrollTop: 0}, 'slow');
                });
                // mobile nav toggle
                $('#nav-toggle').on('click', function (event) {
                    event.preventDefault();
                    $('#main-nav').toggleClass("open");
                });
            });
            // scroll function
            function scrollToID(id, speed) {
                var offSet = 0;
                var targetOffset = $(id).offset().top - offSet;
                var mainNav = $('#main-nav');
                $('html,body').animate({scrollTop: targetOffset}, speed);
                if (mainNav.hasClass("open")) {
                    mainNav.css("height", "1px").removeClass("in").addClass("collapse");
                    mainNav.removeClass("open");
                }
            }
            if (typeof console === "undefined") {
                console = {
                    log: function () { }
                };
            }

            function soloLetras(event) {
                let tecla = event.keyCode || event.which;

                // Tecla de retroceso para borrar, siempre la permite
                if (tecla === 8) {
                    return true;
                }

                // Obtener el carácter ingresado
                let tecla_final = String.fromCharCode(tecla);

                // Patrón de entrada, en este caso solo acepta letras y espacios
                let patron = /^[a-zA-Z\s]*$/;

                if (!patron.test(tecla_final)) {
                    // Alertar al usuario si la tecla ingresada no cumple el patrón
                    alert("Ingrese únicamente letras y espacios. Evite el uso de caracteres especiales.");
                    return false;
                }

                return true;
            }
            function alerta() {
                var pass = document.getElementById("txtPassword").value;
                var repass = document.getElementById("txtRepassword").value;
                if (pass !== repass)
                {
                    alert("Las contraseñas no coinciden");
                    document.getElementById("txtPassword").value = "";
                    document.getElementById("txtRepassword").value = "";
                } else {
                    confirm("Su registro se ha realizado correctamente.");
                    document.getElementById("form-submit").submit();
                }
            }
            ;
        </script>
    </body>
</html>
