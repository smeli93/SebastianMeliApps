<%-- 
    Document   : reservaRealizada
    Created on : 24-10-2019, 19:26:18
    Author     : Germán
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dto.DepartamentoDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="daoImp.DepartamentoDaoImp"%>
<%@page import="dto.UsuarioDto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registrar Checks</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta charset="utf-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">

        <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
        <link href="css/prettyPhoto.css" rel="stylesheet" type="text/css">
        <link href="css/style.css" rel='stylesheet' type='text/css' />
        <link href="css/fontawesome-all.css" rel="stylesheet">
        <link href="//fonts.googleapis.com/css?family=Quicksand:300,400,500,700" rel="stylesheet">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <style>
            body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", Arial, Helvetica, sans-serif}
            .mySlides {display:none}
        </style>
    </head>
    <body>

        <%

            int subTotal = 0;

            UsuarioDto usuarioDto = (UsuarioDto) session.getAttribute("dto");
            int id = (Integer) session.getAttribute("id");
            int cantDias = (Integer) session.getAttribute("cantDias");
            String llegada = (String) session.getAttribute("fechaInicio");
            String salida = (String) session.getAttribute("fechaSalida");

            DepartamentoDaoImp daoDepartamento = new DepartamentoDaoImp();

            ArrayList<DepartamentoDto> listaDepartamento = daoDepartamento.buscarPorId(id);

            for (DepartamentoDto var : listaDepartamento) {

        %>
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
                        <%                            if (session.getAttribute("dto") != null) {
                                UsuarioDto usuario = (UsuarioDto) session.getAttribute("dto");

                        %>
                        <ul class="navbar-nav ml-auto">
                            <li class="nav-item ml-xl-2">
                                <button type="button" onclick="location.href = 'miPerfil.jsp'" class="btn btn-info btn-block">Mi Perfil</button>
                            </li>
                            <form id="" action="LogOut" method="post">
                                <li class="nav-item ml-xl-2">
                                    <button type="submit"  class="btn btn-dark">Cerrar Sesión</button>
                                </li>
                            </form>
                        </ul> 
                        <%                        } else if (session.getAttribute("dto") == null) {
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
        <%            UsuarioDto usuario = (UsuarioDto) session.getAttribute("dto");


        %>

        <section class="banner-w3layouts-bottom py-lg-4 py-3" >
            
            <table border="0" style="margin: 0 auto; width: 800px;">

                <tbody>
                    <tr>
                        <td>
                            <div class="card">
                                <div class="card-body">
                                    <h3 align="center">    Detalles Reserva    </h3>
                                    <table class="table table-striped table-hover table-bordered">
                                        <tbody>
                                            <tr>
                                                <td style="width: 500px; text-align: left">Nombre Cliente</td>
                                                <td style="text-align: center"><%= usuarioDto.getRutPersona().getPrimer_nombre() + " " + usuarioDto.getRutPersona().getAp_paterno() + " " + usuarioDto.getRutPersona().getAp_materno()%></td>
                                            </tr>
                                            <tr>
                                                <td style="width: 500px; text-align: left">Rut Cliente</td>
                                                <td style="text-align: center"><%= usuarioDto.getRutPersona().getRut()%></td>
                                            </tr>
                                            <tr>
                                                <td style="width: 500px; text-align: left">N° Departamento</td>
                                                <td style="text-align: center"><%= var.getNumero_depto()%></td>
                                            </tr>
                                            <tr>
                                                <td style="width: 500px; text-align: left">Fecha Llegada</td>
                                                <td style="text-align: center"><%= llegada%></td>
                                            </tr>
                                            <tr>
                                                <td style="width: 500px; text-align: left">Fecha Salida</td>
                                                <td style="text-align: center"><%= salida%></td>
                                            </tr>
                                            <tr>
                                                <td style="width: 500px; text-align: left">Cantidad de Dias</td>
                                                <td style="text-align: center"><%= cantDias%></td>
                                            </tr>
                                            <tr>
                                                <td style="width: 500px; text-align: left">Sub Total</td>
                                                <td style="text-align: center">$<%= subTotal = var.getValor() * cantDias%></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>

                        </td>

                    </tr>
                </tbody>
                <% }%>
            </table>
        </section>
        <br>
        <br>
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

        <c:if test="${msg_exito != null}">
            <script>

            toastr.success("${msg_exito}", "    Turismo Real ®   ", {

                "closeButton": false,
                "debug": false,
                "newestOnTop": false,
                "progressBar": true,
                "positionClass": "toast-bottom-full-width",
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

            </script>
        </c:if>




        <%
            session.removeAttribute("msg_exito");
        %>

    </body>
</html>
