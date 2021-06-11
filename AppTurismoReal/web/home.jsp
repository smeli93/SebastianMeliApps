<%@page import="dto.UsuarioDto"%>
<jsp:useBean id="listaRegiones" class="daoImp.RegionDaoImp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dto.FotografiaDto"%>
<%@page import="daoImp.FotografiaDaoImp"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="daoImp.DepartamentoDaoImp"%>
<%@page import="dto.DepartamentoDto"%>
<!DOCTYPE html>
<html lang="zxx">

    <head>
        <title>Turismo Real</title>
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

            .toast-info{
                background-color: #00A591;
            }
        </style>

    </head>

    <body>

        <!--banner-->
        <div class="banner-w3layouts">
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

            <!--banner-buscador-->
            <div class="banner-w3layouts-info">
                <!--/search_form -->
                <div id="search_form" class="search_top text-center" >
                    <h3>Reserva los mejores </h3><h3>Departamentos del País</h3>
                    <p>Selecciona una ubicación</p>

                    <!--/COMBO BOX AUTOMATICO-->
                    <form id="" action="BuscarPorRegion" method="POST">
                        <table border="0" style="margin: 0 auto;">
                            <tbody>
                                <tr>
                                    <td style="width: 450px;">

                                        <select class="form-control" id="country12" name="cmbRegion" required>
                                            <c:forEach var="region" items="${listaRegiones.listarNombreRegion()}">
                                                <b><option><c:out value="${region}"/></option></b>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <td>
                                        <input class="form-control" type="submit" value="Buscar">
                                    </td>
                                </tr>
                            </tbody>
                        </table>  
                    </form>                               

                </div>
            </div>
        </div>

        <!--/process-->
        <section class="banner-w3layouts-bottom py-lg-5 py-3" id="plats">
            <div class="container py-lg-4 py-3">
                <h3 class="tittle text-center">LO MÁS BUSCADO</h3>
                <div class="row inner-sec-agileits-w3ls">
                    <div class="tabs">
                        <ul class="nav nav-pills my-4 justify-content-center my-lg-5 my-3" id="pills-tab" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" id="pills-home-tab" data-toggle="pill" href="#pills-home" role="tab" aria-controls="pills-home"
                                   aria-selected="true">Todo</a>
                            </li>
                            <li class="nav-item mx-2">
                                <a class="nav-link" id="pills-profile-tab" data-toggle="pill" href="#pills-profile" role="tab" aria-controls="pills-profile"
                                   aria-selected="false">Oferta</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" id="pills-edit-tab" data-toggle="pill" href="#pills-edit" role="tab" aria-controls="pills-profile" 
                                   aria-selected="false">Premium</a>
                            </li>
                        </ul>

                        
                        <div class="tab-content" id="pills-tabContent">


                            <table id="tablaCatalogo">
                                <div class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab">
                                    <%
                                        DepartamentoDaoImp dao = new DepartamentoDaoImp();
                                        FotografiaDaoImp foto = new FotografiaDaoImp();
                                        ArrayList<DepartamentoDto> lista = dao.listarDepartamentos();
                                        Iterator<DepartamentoDto> iter = lista.iterator();

                                        int salto = 0;

                                        DepartamentoDto depto = null;

                                        while (iter.hasNext()) {
                                            depto = iter.next();
                                            int id = depto.getId_depto();


                                    %>
                                    <th>
                                        <div class="card" style="width: 340px; margin: 15px;">
                                            <div class="card-body">

                                                <%  ArrayList<FotografiaDto> x = foto.mostrarImagenPrincipal(id);

                                                    for (FotografiaDto vd : x) {
                                                        String imagen = vd.getImagen();
                                                        System.out.println(imagen);
                                                %>
                                                <img src="<%=imagen%>" alt="Realtie" class="img-fluid" />
                                                <% }%>
                                                <h5 class="card-title mt-3"><%= depto.getNumero_depto()%>
                                                    <br>
                                                    <span>$<%=depto.getValor()%></span>
                                                    <span>por Día</span>
                                                </h5>

                                                <p class="card-text">
                                                    <i class="fas fa-map-marker-alt"></i> <%= depto.getDireccion()%></p>
                                                <ul class="property-box" style="text-align: center;">
                                                    <button type="button" class="btn btn-info btn-block" onclick="location.href = 'detalleDepartamento.jsp?id=<%= id%>'">Ver Más</button>
                                                </ul>
                                            </div>

                                        </div>
                                    </th>
                                    <%
                                        salto++;
                                        if (salto == 3) {
                                    %> 

                            </table>

                            <%
                                        salto = 0;
                                    }
                                }
                            %>
                        </div>


                        <div class="tab-pane fade" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab">
                            <div class="menu-grids mt-4">
                                <div class="row t-in">



                                </div>

                            </div>
                        </div>

                        <div class="tab-pane fade" id="pills-edit" role="tabpanel" aria-labelledby="pills-edit-tab">
                            <div class="menu-grids mt-4">
                                <div class="row t-in">



                                </div>

                            </div>	

                        </div>
                    </div>

                </div>
            </div>
        </section>


        <!---->

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

        <!-- /.footer -->
        <script src="js/jquery-2.2.3.min.js"></script>
        <!-- carousel -->
        <script src="js/owl.carousel.js"></script>
        <script>
                                                        $(document).ready(function () {
                                                            $('.owl-carousel').owlCarousel({
                                                                loop: true,
                                                                margin: 10,
                                                                responsiveClass: true,
                                                                responsive: {
                                                                    0: {
                                                                        items: 1,
                                                                        nav: true
                                                                    },
                                                                    600: {
                                                                        items: 2,
                                                                        nav: false
                                                                    },
                                                                    900: {
                                                                        items: 3,
                                                                        nav: false
                                                                    },
                                                                    1000: {
                                                                        items: 4,
                                                                        nav: true,
                                                                        loop: false,
                                                                        margin: 20
                                                                    }
                                                                }
                                                            })
                                                        })
        </script>
        <!-- //carousel -->
        <!-- stats -->
        <script src="js/jquery.waypoints.min.js"></script>
        <script src="js/jquery.countup.js"></script>
        <script>
                                                        $('.counter').countUp();
        </script>
        <!-- //stats -->
        <!-- flexSlider -->
        <script defer src="js/jquery.flexslider.js"></script>
        <script>
                                                        $(window).load(function () {
                                                            $('.flexslider').flexslider({
                                                                animation: "slide",
                                                                start: function (slider) {
                                                                    $('body').removeClass('loading');
                                                                }
                                                            });
                                                        });
        </script>
        <!-- //flexSlider -->
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
        <script src="js/bootstrap.js"></script>
        <!-- js file -->

        <script
            src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>

        <c:if test="${msg_bienvenida != null}">
            <script>

            toastr.info("${msg_bienvenida}", "    Turismo Real ®    ", {

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

            </script>
        </c:if>
        <%
            session.removeAttribute("msg_bienvenida");
        %>

    </body>

</html>