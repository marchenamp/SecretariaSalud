<%-- 
    Document   : registrarExpediente
    Created on : 8 abr 2024, 22:23:09
    Author     : magda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Registro de Expediente</title>
        <!-- Incluir Bootstrap CSS -->
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
            <!-- Formulario de Registro de Paciente -->
            <div class="register-form">
                <form action="RegistrarExpediente" method="post">
                    <div class="heading">
                        <h2>REGISTRO DE EXPEDIENTE</h2>
                    </div>

                    <div class="container">
                        <div class="row">
                            <div class="col">
                                <label for="nombre">Nombre(s):</label>
                                <input type="text" name="nombre" placeholder="Ingrese lo(s) nombre(s)"  onkeypress="return soloLetras(event)"  title="Ingrese únicamente letras" maxlength="255" required>
                            </div>
                            <div class="col">
                                <label for="apellidoPaterno">Apellido Paterno:</label>
                                <input type="text" name="apellidoPaterno" placeholder="Ingrese el apellido paterno" onkeypress="return soloLetras(event)" maxlength="255" required>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col">
                                <label for="apellidoMaterno">Apellido Materno:</label>
                                <input type="text" name="apellidoMaterno" placeholder="Ingrese el apellido materno" onkeypress="return soloLetras(event)" maxlength="255" required>
                            </div>
                            <div class="col">
                                <label for="fechaNacimiento">Fecha de Nacimiento:</label>
                                <input name="fecha" type="date" id="fecha" class="form-control" id="fecha" required>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col">
                                <label for="genero">Género:</label>
                                <select id="genero" name="genero">
                                    <option value="seleccione">Seleccione el género</option>
                                    <option value="femenino">Femenino</option>
                                    <option value="masculino">Masculino</option>
                                    <option value="noBinario">No binario</option>
                                </select>
                            </div>
                            <div class="col">
                                <label for="estadoCivil">Estado Civil:</label>
                                <select id="estadoCivil" name="estadoCivil">
                                    <option value="seleccione">Seleccione el estado civil</option>
                                    <option value="soltero">Soltero</option>
                                    <option value="casado">Casado</option>
                                </select>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col">
                                <label for="antecedentesHereditarios">Antecedentes Hereditarios:</label>
                                <textarea id="antecedentesHereditarios" placeholder="Ingrese los antecedentes hereditarios del paciente..." name="antecedentesHereditarios" rows="4" cols="50"></textarea>
                            </div>
                            <div class="col">
                                <label for="padecimientosPersonales">Padecimientos Personales:</label>
                                <textarea id="padecimientosPersonales" placeholder="Ingrese los padecimientos personales del paciente..." name="padecimientosPersonales" rows="4" cols="50"></textarea>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col">
                                <label for="tipoSangre">Tipo de Sangre:</label>
                                <select id="tipoSangre" name="tipoSangre">
                                    <option value="seleccione">Seleccione el tipo de sangre</option>
                                    <option value="O-">O-</option>
                                    <option value="O+">O+</option>
                                    <option value="A-">A-</option>
                                    <option value="A+">A+</option>
                                    <option value="B-">B-</option>
                                    <option value="B+">B+</option>
                                    <option value="AB-">AB-</option>
                                    <option value="AB+">AB+</option>
                                </select>
                            </div>
                            <div class="col">
                                <label for="alergias">Alergias:</label>
                                <select id="alergias" name="alergias">
                                    <option value="seleccione">Seleccione</option>
                                    <option value="si">Sí</option>
                                    <option value="no">No</option>
                                </select>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col">
                                <label for="estatura">Estatura (metros):</label>
                                <input type="text" id="estatura" name="estatura" pattern="[0-9]+(\.[0-9]{1,2})?" placeholder="0.00" required>
                            </div>
                            <div class="col">
                                <label for="peso">Peso (kilos):</label>
                                <input type="text" id="peso" name="peso" pattern="[0-9]{1,3}(\.[0-9]{1,2})?" placeholder="00.0" required>
                            </div>
                            <div class="col">
                                <label for="frecuenciaCardiaca">Frecuencia Cardiaca (bpm):</label>
                                <input type="text" id="frecuenciaCardiaca" name="frecuenciaCardiaca" pattern="[0-9]{1,3}" placeholder="00" required>
                            </div>
                        </div>

                        <div class="row" style="margin-bottom: 20px;">
                            <h2 style="font-size: x-large; margin-top: 20px;">Contacto de Emergencia:</h2>
                            <div class="col">
                                <label for="nombreContactoEmergencia">Nombre Completo:</label>
                                <input type="text" id="nombreContactoEmergencia" name="nombreContactoEmergencia" placeholder="Ingrese el nombre completo del contacto de emergencia" required>

                                <label for="numeroContactoEmergencia">Teléfono:</label>
                                <input type="tel" id="numeroContactoEmergencia" name="numeroContactoEmergencia" pattern="[0-9]{10}" placeholder="Ingrese el número telefónico del contacto de emergencia" required>
                                <br><br>
                                <button type="submit" id="form-submit" onclick="alerta()" class="btn">Registrar</button>
                            </div>
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
