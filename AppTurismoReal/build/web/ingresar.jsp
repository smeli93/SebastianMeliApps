<%@page import="dto.UsuarioDto"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zxx">

    <head>
        <title>Ingresar</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta charset="utf-8">

        <!--CSS-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css"><!-- css alert toast-->
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/prettyPhoto.css" rel="stylesheet" type="text/css">
        <link href="css/style.css" rel='stylesheet' type='text/css'/>
        <link href="css/button.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

        <!--/FONTS-->
        <link href="https://fonts.googleapis.com/css?family=Ubuntu&display=swap" rel="stylesheet">
        <script src="https://kit.fontawesome.com/662e51b710.js" crossorigin="anonymous"></script>

        <!--/JS-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script> 
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script> 

        <style>
            body,h1,h2,h3,h4,h5,h6 {font-family: "Ubuntu", Arial, Helvetica, sans-serif}
            .mySlides {display:none}


            div#error2{
                height: 20px;
                width: 20px;
                display: inline-block;
                position: relative;
                top: 5 px;
            }
        </style>
    </head>


    <body>
        <!--/banner-w3layouts-sec-->
        <div class="banner-w3layouts two">
            <header>
                <nav class="navbar navbar-expand-lg navbar-light bg-light">

                    <!--Logo-->
                    &nbsp; &nbsp; &nbsp; &nbsp;<a class="navbar-brand" href="home.jsp">
                        <img src="images/logo2.png" style="width: 180px; height: 60px;"/></a>

                    <!--Menu-->
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">

                        <ul class="navbar-nav ml-auto">
                            <li class="nav-item active">
                                <a class="nav-link" href="home.jsp">Home</a>
                            </li>
                            <li class="nav-item ml-xl-2">
                                <a class="nav-link" href="#">Quienes Somos</a>
                            </li>
                            <li class="nav-item ml-xl-2">
                                <a class="nav-link" href="#">Departamentos</a>
                            </li>
                            <li class="nav-item ml-xl-2">
                                <a class="nav-link" href="#">Servicios</a>
                            </li>
                            <li class="nav-item ml-xl-2">
                                <a class="nav-link" href="">Contacto</a>
                            </li>

                        </ul>
                        <%
                            if (session.getAttribute("dto") != null) {
                        %>
                        <ul class="navbar-nav ml-auto">
                            <li class="nav-item ml-xl-2">
                                <button type="button" onclick="location.href = 'miPerfil.jsp'" class="btn btn-info btn-block">Mi Perfil</button>
                            </li>
                            <li class="nav-item ml-xl-2">
                                <a class="nav-link" href="">Cerrar Sesion</a>
                            </li>
                        </ul> 
                        <%
                        } else if (session.getAttribute("dto") == null) {
                        %>  
                        <ul class="navbar-nav ml-auto">
                            <li class="nav-item ml-xl-2">
                                <a class="nav-link" href="ingresar.jsp">Ingresar</a>
                            </li>
                        </ul> 
                        <%
                            }
                        %>
                    </div>
                </nav>
            </header>


        </div>
        <section class="banner-w3layouts-bottom py-lg-5 py-3">
            <div class="container py-lg-4 py-3">
                <div id="contenedor">
                    <div id="fila">
                        <div id="columna1">  
                            <div class="card" >
                                <div class="card-body" style="width: 560px;">
                                    <h2 style="text-align: center;"><b>Registrarse</b></h2>
                                    <br>
                                    <form id="agregarCliente" action="AgregarCliente" method="POST" onsubmit="return validarCampos(email.value);">

                                        <table border="0">
                                            <tbody>
                                                <tr>
                                                    <td style="width: 250px;">
                                                        <div class="form-group">
                                                            <input type="text" class="form-control" id="rut" name="rut" maxlength="10" required oninput="checkRut(this)" placeholder="Rut" >                                                           
                                                            <input type="hidden" id="testeo" value="">
                                                        </div>

                                                    </td>

                                                    <td>
                                                        &nbsp; &nbsp;&nbsp;<div id="error2"></div>
                                                        <span id="comprobar"></span>
                                                    </td>
                                                </tr>
                                                <tr>

                                                    <td>
                                                        <div class="form-group">
                                                            <input type="date" class="form-control" id="fechaNacimiento" name="fechaNacimiento" placeholder="Fecha Nacimiento" required>
                                                        </div>
                                                    </td>



                                                    <td style="width: 270px;"><div class="w3-main w3-white" style="margin-left:20px">
                                                            <div class="form-group">
                                                                <input type="text" class="form-control" id="direccion" name="direccion" maxlength="45" placeholder="Dirección" required>
                                                            </div>
                                                        </div>
                                                    </td>
                                                </tr>

                                                <tr>
                                                    <td>
                                                        <div class="form-group">
                                                            <input type="text" class="form-control" id="primerNom" name="primerNombre" maxlength="45" placeholder="Primer Nombre" required>
                                                        </div>
                                                    </td>

                                                    <td>
                                                        <div class="form-group" class="w3-main w3-white" style="margin-left: 20px">
                                                            <input type="text" class="form-control" id="segundoNom" name="segundoNombre" maxlength="45" placeholder="Segundo Nombre" required>
                                                        </div>
                                                    </td>

                                                </tr>
                                                <tr>
                                                    <td>
                                                        <div class="form-group">
                                                            <input type="text" class="form-control" id="apPaterno" name="apellidoPaterno" placeholder="Apellido Paterno" required>
                                                        </div>
                                                    </td>

                                                    <td>
                                                        <div class="form-group" class="w3-main w3-white" style="margin-left:20px" >
                                                            <input type="text" class="form-control" id="apMaterno" name="apellidoMaterno" placeholder="Apellido Materno" required>
                                                        </div>
                                                    </td>
                                                </tr>
                                                <tr>

                                                    <td>
                                                        <div class="form-group">
                                                            <input type="text" class="form-control" id="email" name="email" placeholder="Correo Electronico" required>
                                                        </div>
                                                    </td>


                                                    <td><div class="w3-main w3-white" style="margin-left:20px">
                                                            <div class="form-group">
                                                                <input type="text" class="form-control" maxlength="9" id="telefono" name="fono" placeholder="Telefono" required onKeyPress="return soloNumeros(event)">
                                                            </div>
                                                        </div>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td><div div>
                                                            <div class="form-group">
                                                                <input type="password" class="form-control check-seguridad" id="passUno" name="pass" placeholder="Contraseña" required>
                                                            </div>
                                                        </div>
                                                    </td>

                                                    <td><div class="w3-main w3-white" style="margin-left:20px">
                                                            <div class="form-group">
                                                                <input type="password" class="form-control" id="passDos" placeholder="Repetir Contraseña" required>
                                                            </div>
                                                        </div>
                                                    </td>
                                                </tr>

                                            </tbody>
                                        </table>
                                        <br>
                                        <div class="w3-main w3-white" style="margin-left:20px">
                                            <div class="form-check">
                                                <input type="checkbox" class="form-check-input" id="chkTyC">
                                                <label class="form-check-label" for="exampleCheck1">Acepta los terminos y condiciones propuestos.</label>
                                            </div>
                                        </div>
                                        <br>
                                        <button type="submit" class="btn btn-info btn-block">Confirmar</button>
                                    </form>

                                </div>
                            </div>
                        </div>

                        <div id="columna2">
                            <div class="w3-main w3-white" style="margin-left:80px">
                                <div class="card" >
                                    <form action="Login" method="POST">

                                        <div class="card-body" style="width: 400px;">
                                            <h2 style="text-align: center;"><b>Iniciar Sesión</b></h2>
                                            <br>
                                            <div class="form-group">
                                                <input type="email" class="form-control" id="exampleInputEmail1" name="email" aria-describedby="emailHelp" placeholder="Correo Electronico" required>
                                            </div>
                                            <div class="form-group">

                                                <input type="password" class="form-control" id="exampleInputPassword1" name="pass" placeholder="Contraseña" required>
                                            </div>
                                            <br>
                                            <button type="submit" class="btn btn-info btn-block">Ingresar</button>

                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>

                    </div>
                    </section>
                    <!--//projects -->
                    <!--footer-->
                    <footer>
                        <div class="footer-sec-w3-agileits py-lg-5 py-3">
                            <div class="container py-lg-4 py-3">
                                <div class="row">
                                    <div class="col-lg-4 footer-grid-wthree text-left">
                                        <h3>About US</h3>
                                        <p>Curabitur non nulla sit amet nisl tempus convallis quis ac lectus. lacinia eget consectetur sed, convallis at tellus..</p>
                                        <address class="ad-info mt-3">
                                            <strong>Twitter, Inc.</strong>
                                            <br> 1355 Market St, Suite 900
                                            <br> San Francisco, CA 94103
                                            <br>
                                            <abbr title="Phone">P:</abbr> (123) 456-7890
                                        </address>
                                    </div>
                                    <div class="col-lg-4 footer-grid-wthree text-left">

                                        <div class="tech-btm">
                                            <h3>Popular Properties </h3>
                                            <div class="blog-grids row mb-3">
                                                <div class="col-md-5 blog-grid-left">
                                                    <a href="single.html">
                                                        <img src="images/g1.jpg" class="img-fluid rounded" alt="">
                                                    </a>
                                                </div>
                                                <div class="col-md-7 blog-grid-right">
                                                    <h6 class="price mb-2">$12,000</h6>
                                                    <h5>
                                                        <a href="single.html">Pellentesque dui, non felis. Maecenas male non felis </a>
                                                    </h5>
                                                    <div class="sub-meta mt-2">
                                                        <span>
                                                            <i class="fab fa-periscope"></i> 51-199 Pike St,</span>
                                                    </div>
                                                </div>

                                            </div>
                                            <div class="blog-grids row mt-2">
                                                <div class="col-md-5 blog-grid-left">
                                                    <a href="single.html">
                                                        <img src="images/g5.jpg" class="img-fluid rounded" alt="">
                                                    </a>
                                                </div>
                                                <div class="col-md-7 blog-grid-right">
                                                    <h6 class="price mb-2">$13,000</h6>
                                                    <h5>
                                                        <a href="single.html">Pellentesque dui, non felis. Maecenas male non felis </a>
                                                    </h5>
                                                    <div class="sub-meta mt-2">
                                                        <span>
                                                            <i class="fab fa-periscope"></i> 51-199 Pike St,</span>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                    <!-- subscribe -->
                                    <div class="col-lg-4 subscribe-main footer-grid-wthree text-left">
                                        <h2>Signup to our newsletter</h2>
                                        <div class="subscribe-main text-left">
                                            <div class="subscribe-form">
                                                <form action="#" method="post" class="subscribe_form">
                                                    <input class="form-control" type="email" placeholder="Enter your email..." required="">
                                                    <button type="submit" class="btn btn-primary submit">Submit</button>
                                                </form>
                                                <div class="clearfix"> </div>
                                            </div>
                                            <p>We respect your privacy.No spam ever!</p>
                                        </div>
                                        <!-- //subscribe -->
                                    </div>
                                </div>
                                <!-- //footer -->
                            </div>
                        </div>

                    </footer>
                    <!---->

                    <!-- /.footer -->
                    <script src="js/jquery-2.2.3.min.js"></script>
                    <script src="js/validaciones.js" type="text/javascript" charset="utf-8"></script>


                    <!-- dropdown nav -->
                    <script>
                                                                    $(document).ready(function () {
                                                                        $(".dropdown").hover(
                                                                                function () {
                                                                                    $('.dropdown-menu', this).stop(true, true).slideDown("fast");
                                                                                    $(this).toggleClass('open');
                                                                                },
                                                                                function () {
                                                                                    $('.dropdown-menu', this).stop(true, true).slideUp("fast");
                                                                                    $(this).toggleClass('open');
                                                                                }
                                                                        );
                                                                    });
                    </script>
                    <!-- //dropdown nav -->
                    <!-- smooth-scrolling-of-move-up -->
                    <script>
                        $(document).ready(function () {
                            /*
                             var defaults = {
                             containerID: 'toTop', // fading element id
                             containerHoverID: 'toTopHover', // fading element hover id
                             scrollSpeed: 1200,
                             easingType: 'linear' 
                             };
                             */

                            $().UItoTop({
                                easingType: 'easeOutQuart'
                            });
                        });
                    </script>
                    <!-- //smooth-scrolling-of-move-up -->
                    <!-- start-smooth-scrolling -->
                    <script src="js/move-top.js"></script>
                    <script src="js/easing.js"></script>
                    <script>
                        jQuery(document).ready(function ($) {
                            $(".scroll").click(function (event) {
                                event.preventDefault();
                                $('html,body').animate({
                                    scrollTop: $(this.hash).offset().top
                                }, 1000);
                            });
                        });
                    </script>

                    <!-- //end-smooth-scrolling -->
                    <script src="js/bootstrap.js"></script>
                    <!-- js file -->
                    <!-- jQuery-Photo-filter-lightbox-Gallery-plugin -->
                    <script src="js/jquery-1.7.2.js"></script>
                    <script src="js/jquery.quicksand.js"></script>
                    <script src="js/script.js"></script>
                    <script src="js/jquery.prettyPhoto.js"></script>

                    <script
                        src="https://code.jquery.com/jquery-3.4.1.min.js"
                        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
                    crossorigin="anonymous"></script>

                    <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>


                    <c:if test="${msg_cuenta_creada != null}">
                        <script>

                        toastr.success("${msg_cuenta_creada}", "    Turismo Real ®    ", {

                            "closeButton": false,
                            "debug": false,
                            "newestOnTop": false,
                            "progressBar": true,
                            "positionClass": "toast-bottom-right",
                            "preventDuplicates": false,
                            "onclick": null,
                            "showDuration": "300",
                            "hideDuration": "1000",
                            "timeOut": "5000",
                            "extendedTimeOut": "1000",
                            "showEasing": "swing",
                            "hideEasing": "linear",
                            "showMethod": "fadeIn",
                            "hideMethod": "fadeOut"

                        }
                        );
                        </script> 
                    </c:if>
                    <%
                        session.removeAttribute("msg_cuenta_creada");
                    %>

                    <c:if test="${msg_error != null}">
                        <script>

                            toastr.error("${msg_error}", "    Turismo Real ®    ", {

                                "closeButton": false,
                                "debug": false,
                                "newestOnTop": false,
                                "progressBar": false,
                                "positionClass": "toast-bottom-right",
                                "preventDuplicates": false,
                                "onclick": null,
                                "showDuration": "300",
                                "hideDuration": "1000",
                                "timeOut": "5000",
                                "extendedTimeOut": "1000",
                                "showEasing": "swing",
                                "hideEasing": "linear",
                                "showMethod": "fadeIn",
                                "hideMethod": "fadeOut"

                            }
                            );
                        </script> 
                    </c:if>
                    <%
                        session.removeAttribute("msg_error");
                    %>

                    <c:if test="${msg_iniciar_sesion != null}">
                        <script>

                            toastr.warning("${msg_iniciar_sesion}", "    Turismo Real ®    ", {

                                "closeButton": false,
                                "debug": false,
                                "newestOnTop": false,
                                "progressBar": true,
                                "positionClass": "toast-bottom-right",
                                "preventDuplicates": false,
                                "onclick": null,
                                "showDuration": "300",
                                "hideDuration": "1000",
                                "timeOut": "5000",
                                "extendedTimeOut": "1000",
                                "showEasing": "swing",
                                "hideEasing": "linear",
                                "showMethod": "fadeIn",
                                "hideMethod": "fadeOut"

                            });

                            document.getElementById("exampleInputEmail1").focus();

                        </script>
                    </c:if>
                    <%
                        session.removeAttribute("msg_iniciar_sesion");
                    %>
                    </body>

                    </html>
