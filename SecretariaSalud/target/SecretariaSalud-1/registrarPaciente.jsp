<%-- 
    Document   : registrarPaciente
    Created on : 8 abr 2024, 22:22:29
    Author     : magda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Registro de Paciente</title>
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
                <form action="RegistrarPaciente" method="post">
                    <div class="heading">
                        <h2>REGISTRO DE PACIENTE</h2>
                    </div>

                    <div class="container">
                        <div class="row">
                            <div class="col">
                                <label for="nombre">Nombre(s):</label>
                                <input type="text" name="nombre" placeholder="Ingrese su(s) nombre(s)"  onkeypress="return soloLetras(event)"  title="Ingrese únicamente letras" maxlength="255" required>
                            </div>
                            <div class="col">
                                <label for="apellidoPaterno">Apellido Paterno:</label>
                                <input type="text" name="apellidoPaterno" placeholder="Ingrese su apellido paterno" onkeypress="return soloLetras(event)" maxlength="255" required>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col">
                                <label for="apellidoMaterno">Apellido Materno:</label>
                                <input type="text" name="apellidoMaterno" placeholder="Ingrese su apellido materno" onkeypress="return soloLetras(event)" maxlength="255" required>
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
                                    <option value="seleccione">Seleccione su género</option>
                                    <option value="femenino">Femenino</option>
                                    <option value="masculino">Masculino</option>
                                    <option value="noBinario">No binario</option>
                                </select>
                            </div>
                            <div class="col">
                                <label for="estadoCivil">Estado Civil:</label>
                                <select id="estadoCivil" name="estadoCivil">
                                    <option value="seleccione">Seleccione su estado civil</option>
                                    <option value="soltero">Soltero</option>
                                    <option value="casado">Casado</option>
                                </select>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col">
                                <label for="email">Correo Electrónico:</label>
                                <input type="email" name="email" placeholder="Ingrese su correo electrónico" maxlength="255" pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}" title="Debe coincidir con el formato de un correo electrónico." required>
                            </div>
                            <div class="col">
                                <label for="telefono">Teléfono:</label>
                                <input type="tel" name="telefono" placeholder="Ingrese su número telefónico" maxlength="10" pattern="^\+?\d{1,3}[-\s]?\d{3,4}[-\s]?\d{3,4}$" required>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col">
                                <label for="password">Contraseña:</label>
                                <input name="pass" type="password" id="txtPassword" placeholder="Ingrese su contraseña"  pattern="(?=.*\d)(?=.*[a-záéíóúüñ]).*[A-ZÁÉÍÓÚÜÑ].*" title="Debe tener al menos una mayúscula, una minúscula y un dígito" minlength="8" maxlength="20" required> 
                                <br>
                                <input name="repass" type="password" id="txtRepassword" placeholder="Ingrese nuevamente su contraseña" pattern="(?=.*\d)(?=.*[a-záéíóúüñ]).*[A-ZÁÉÍÓÚÜÑ].*" title="Debe tener al menos una mayúscula, una minúscula y un dígito" minlength="8" maxlength="20" required>
                                <br>
                                <button type="submit" id="form-submit" onclick="alerta()" class="btn">Registrar</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div> 

            <div class="register-form">
                <form action="RegistrarTutor" method="post">
                    <div class="heading">
                        <h2>DATOS DEL TUTOR</h2>
                    </div>

                    <div class="container">
                        <div class="row">
                            <div class="col">
                                <label for="nombreTutor">Nombre(s):</label>
                                <input type="text" name="nombreTutor" placeholder="Ingrese lo(s) nombre(s) del tutor"  onkeypress="return soloLetras(event)"  title="Ingrese únicamente letras" maxlength="255" required>
                            </div>
                            <div class="col">
                                <label for="apellidoPaternoTutor">Apellido Paterno:</label>
                                <input type="text" name="apellidoPaternoTutor" placeholder="Ingrese el apellido paterno del tutor" onkeypress="return soloLetras(event)" maxlength="255" required>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col">
                                <label for="apellidoMaternoTutor">Apellido Materno:</label>
                                <input type="text" name="apellidoMaternoTutor" placeholder="Ingrese el apellido materno del tutor" onkeypress="return soloLetras(event)" maxlength="255" required>
                            </div>
                            <div class="col">
                                <label for="fechaNacimientoTutor">Fecha de Nacimiento:</label>
                                <input name="fecha" type="date" id="fechaTutor" class="form-control" id="fecha" required>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col">
                                <label for="telefono">Teléfono:</label>
                                <input type="tel" name="telefono" placeholder="Ingrese el número telefónico de su tutor" maxlength="10" pattern="^\+?\d{1,3}[-\s]?\d{3,4}[-\s]?\d{3,4}$" required>
                            </div>
                            <div class="col">
                                <label for="genero">Género:</label>
                                <select id="genero" name="genero">
                                    <option value="seleccione">Seleccione el género de su tutor</option>
                                    <option value="femenino">Femenino</option>
                                    <option value="masculino">Masculino</option>
                                    <option value="noBinario">No binario</option>
                                </select>
                            </div>
                        </div>

                        <div class="row">
                            <label for="parentezco">Parentesco:</label>
                            <select id="estadoCivil" name="estadoCivil">
                                <option value="seleccione">Seleccione el parentesco con el tutor</option>
                                <option value="madre">Madre</option>
                                <option value="padre">Padre</option>
                                <option value="hermano">Hermano(a)</option>
                                <option value="abuelo">Abuelo(a)</option>
                                <option value="otro">Otro</option>
                            </select>
                            <button type="submit" id="form-submit" onclick="alerta()" class="btn">Registrar</button>
                        </div>
                    </div>
            </div>
        </form>
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
