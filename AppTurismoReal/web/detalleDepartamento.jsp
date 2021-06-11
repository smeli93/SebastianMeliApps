<%@page import="dto.UsuarioDto"%>
<%@page import="daoImp.FotografiaDaoImp"%>
<%@page import="dto.FotografiaDto"%>
<%@page import="daoImp.DepartamentoDaoImp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.DepartamentoDto"%>
<!DOCTYPE html>
<html lang="zxx">

    <head>
        <title>Detalle Departamento</title>
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
        </style>
    </head>


    <body>
        <%
            DepartamentoDaoImp dao = new DepartamentoDaoImp();
            int id = Integer.parseInt(request.getParameter("id"));
            String direccion = dao.retornaDireccion(id);
            System.out.println(direccion);
            ArrayList<DepartamentoDto> list = dao.buscarPorId(id);

            for (DepartamentoDto var : list) {

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
        <section class="banner-w3layouts-bottom py-lg-5 py-3">
            <div class="container py-lg-4 py-3">
                <div id="contenedor">
                    <div id="fila">
                        <div id="columna1" >                        
                            <nav class="w3-light-grey w3-collapse" style="z-index:3;width:260px" id="mySidebar">
                                <form id="envioDetalles" action="EnviarDatosDetalleReserva" method="POST" onsubmit="return validar();">

                                    <div class="w3-container w3-display-container w3-padding-16">
                                        <h4 style="text-align: left"><b>Depto: <%= var.getNumero_depto()%></b></h4>
                                        <h4 style="text-align: left"><b>Valor: $<%= var.getValor()%> por día</b></h4>

                                        <br>

                                        <p><label><i class="fa fa-calendar-check-o"></i> Fecha Inicio</label></p>
                                        <input class="w3-input w3-border" id="fechaInicio" value="" min="" onchange="calcularDias();" type="date" min="" placeholder="DD MM YYYY" name="fechaInicio" required>  
                                        <br>
                                        <p><label><i class="fa fa-calendar-o"></i> Fecha Termino</label></p>
                                        <input class="w3-input w3-border" id="fechaSalida" type="date" onchange="calcularDias();" placeholder="DD MM YYYY" name="fechaSalida" required>         
                                        <br>
                                        <p><label><i class="fa fa-calendar"></i> Cantidad de Dias: <label id="cantDias" name="cantDias">0</label> </label></p>
                                        <input name="cant" value="" id="cant" type="hidden"/>
                                        <input name="idDepto" value="<%=var.getId_depto()%>" id="idDepto" type="hidden"/>
                                        <br>
                                        <% if (session.getAttribute("dto") != null) { %>
                                        <p><button type="submit" class="btn btn-info btn-block">Reservar</button></p>
                                        <%}%>
                                    </div>

                                </form>

                            </nav></div>

                        <div id="columna2">

                            <!-- !PAGE CONTENT! -->
                            <div class="w3-main w3-white" style="margin-left:60px">


                                <!-- Slideshow Header -->
                                <div class="w3-container" id="apartment">
                                    <h4><strong>Fotografías</strong></h4>
                                    <%
                                        FotografiaDaoImp foto = new FotografiaDaoImp();
                                        ArrayList<FotografiaDto> x = foto.listarImagenes(id);

                                        for (FotografiaDto vd : x) {
                                            String imagen = vd.getImagen();
                                            System.out.println(imagen);
                                    %>
                                    <div class="w3-display-container mySlides">
                                        <img src="<%=imagen%>" style="width:100%;margin-bottom:-6px">
                                        <div class="w3-display-bottomleft w3-container w3-black">

                                        </div>
                                    </div>
                                    <% }%>
                                </div>
                                <div class="w3-row-padding w3-section">
                                    <%
                                        int index = 1;
                                        for (FotografiaDto vd : x) {
                                            String imagen = vd.getImagen();
                                            System.out.println(imagen);
                                    %>
                                    <div class="w3-col s3">
                                        <img class="demo w3-opacity w3-hover-opacity-off" src="<%=imagen%>" style="width:100%;cursor:pointer" onclick="currentDiv(<%= index++%>)">
                                    </div>
                                    <% } %>
                                </div>

                                <div class="w3-container">
                                    <h4><strong>Características</strong></h4>
                                    <div class="w3-row w3-large">
                                        <%                                            String coci, est = "";
                                            if (var.isCocina()) {

                                                coci = "Si";
                                            } else {
                                                coci = "No";
                                            }
                                            if (var.isEstacionamiento()) {
                                                est = "Si";
                                            } else {
                                                est = "No";
                                            }
                                        %>
                                        <div class="w3-col s6">
                                            <p><i class="fa fa-fw fa-male"></i> Max Personas: <%= var.getCant_personas()%></p>
                                            <p><i class="fa fa-fw fa-bed"></i> Habitaciones: <%= var.getCant_habitaciones()%></p>
                                            <p><i class="fa fa-fw fa-cutlery"></i> Cocina: <%= coci%></p>
                                        </div>
                                        <div class="w3-col s6">
                                            <p><i class="fa fa-fw fa-car"></i> Estacionamiento: <%= est%>
                                            </p>
                                            <p><i class="fa fa-fw fa-bath"></i> Baños: <%= var.getCant_banos()%>
                                            </p>
                                        </div>
                                    </div>
                                    <hr>


                                    <h4><strong>Comodidades</strong></h4>
                                    <div class="w3-row w3-large">
                                        <%
                                            String inte, tv = "";
                                            if (var.isInternet()) {

                                                inte = "Si";
                                            } else {
                                                inte = "No";
                                            }

                                            if (var.isTv_cable()) {
                                                tv = "Si";
                                            } else {
                                                tv = "No";
                                            }

                                        %>
                                        <div class="w3-col s6">
                                            <p><i class="fa fa-fw fa-wifi"></i> WiFi: <%= inte%></p>
                                            <p><i class="fa fa-fw fa-tv"></i> TV Cable: <%= tv%></p>
                                        </div>
                                        <div class="w3-col s6">
                                            <%
                                                String acs, cal = "";
                                                if (var.isAccesible()) {

                                                    acs = "Si";
                                                } else {
                                                    acs = "No";
                                                }

                                                if (var.isCalefaccion()) {
                                                    cal = "Si";
                                                } else {
                                                    cal = "No";
                                                }

                                            %>

                                            <p><i class="fa fa-fw fa-thermometer"></i> Calefacción: <%= acs%> </p>
                                            <p><i class="fa fa-fw fa-wheelchair"></i> Accessible: <%= cal%></p>

                                        </div>
                                    </div>
                                    <hr>

                                    <h4><strong>Información Extra</strong></h4>
                                    <p>Nuestros departamentos vienen completamente equipados para cumplir con todas las necesidades que necesites</p>
                                    <p>Aceptamos: <i class="fa fa-credit-card w3-large"></i> <i class="fa fa-cc-mastercard w3-large"></i> <i class="fa fa-cc-amex w3-large"></i> <i class="fa fa-cc-cc-visa w3-large"></i><i class="fa fa-cc-paypal w3-large"></i></p>
                                </div>
                                <hr>

                                <!-- Contact -->
                                <div class="w3-container" id="contact">
                                    <h4><strong>Ubicación</strong></h4>
                                    <p class="card-text">
                                        <i class="fas fa-map-marker-alt"></i> <%= var.getDireccion()%></p>
                                    <br>
                                    <div id="map" style="width:700px;height:400px;"></div>
                                    <%}%>
                                    <script>
                                        function initMap() {
                                            geocoder = new google.maps.Geocoder();
                                            var latlng = new google.maps.LatLng(-33.4372, -70.6506);
                                            var mapOptions = {
                                                zoom: 8,
                                                center: latlng
                                            }
                                            map = new google.maps.Map(document.getElementById('map'), mapOptions);
                                        }
                                    </script>
                                </div>

                            </div>


                            <script>

                                window.onload = function () {
                                    Mover();
                                    FechaActual();
                                };


                                // Script to open and close sidebar when on tablets and phones
                                function w3_open() {
                                    document.getElementById("mySidebar").style.display = "block";
                                    document.getElementById("myOverlay").style.display = "block";
                                }

                                function w3_close() {
                                    document.getElementById("mySidebar").style.display = "none";
                                    document.getElementById("myOverlay").style.display = "none";
                                }

                                // Slideshow Apartment Images
                                var slideIndex = 1;
                                showDivs(slideIndex);

                                function plusDivs(n) {
                                    showDivs(slideIndex += n);
                                }

                                function currentDiv(n) {
                                    showDivs(slideIndex = n);
                                }

                                function showDivs(n) {
                                    var i;
                                    var x = document.getElementsByClassName("mySlides");
                                    var dots = document.getElementsByClassName("demo");
                                    if (n > x.length) {
                                        slideIndex = 1
                                    }
                                    if (n < 1) {
                                        slideIndex = x.length
                                    }
                                    for (i = 0; i < x.length; i++) {
                                        x[i].style.display = "none";
                                    }
                                    for (i = 0; i < dots.length; i++) {
                                        dots[i].className = dots[i].className.replace(" w3-opacity-off", "");
                                    }
                                    x[slideIndex - 1].style.display = "block";
                                    dots[slideIndex - 1].className += " w3-opacity-off";
                                }



                                var geocoder;
                                var map;
                                var markers = [];

                                function Mover() {


                                    var address = "<%= direccion%>";


                                    geocoder.geocode({'address': address}, function (results, status) {
                                        if (status === 'OK') {
                                            map.setCenter(results[0].geometry.location);


                                            var marker = new google.maps.Marker({
                                                map: map,
                                                position: results[0].geometry.location,
                                                title: results[0].formatted_address,
                                                draggable: true,
                                                animation: google.maps.Animation.DROP
                                            });

                                            map.setZoom(16);
                                            markers.push(marker);
                                            marker.addListener('click', toggleBounce);
                                            marker.addListener('click', function () {
                                                infowindow.open(map, marker);
                                            });

                                            function toggleBounce() {
                                                if (marker.getAnimation() !== null) {
                                                    marker.setAnimation(null);
                                                } else {
                                                    marker.setAnimation(google.maps.Animation.BOUNCE);
                                                }
                                            }


                                        } else {
                                            alert('Geocode was not successful for the following reason: ' + status);
                                        }
                                    });

                                }

                                function calcularDias() {

                                    var ini = document.getElementById("fechaInicio").value;
                                    var fin = document.getElementById("fechaSalida").value;

                                    if (ini > fin) {

                                        toastr.error("Fecha Invalida", "    Turismo Real ®    ", {

                                            "closeButton": false,
                                            "debug": false,
                                            "newestOnTop": false,
                                            "positionClass": "toast-bottom-left",
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
                                        FechaActual();
                                        document.getElementById("cantDias").innerText = 0;
                                        document.getElementById("cant").value = 0;
                                    } else {

                                        var fechaini = new Date(ini);
                                        var fechafin = new Date(fin);
                                        var diasdif = fechafin.getTime() - fechaini.getTime();
                                        var contdias = Math.round(diasdif / (1000 * 60 * 60 * 24));
                                        document.getElementById("cantDias").innerText = contdias;
                                        document.getElementById("cant").value = contdias;
                                    }
                                }

                                function validar() {
                                    var formulario = document.getElementById("envioDetalles");
                                    var dias = document.getElementById("cant").value;

                                    if (dias == 0) {

                                        toastr.error("Dias de reserva no puede ser igual a 0...", "    Turismo Real ®    ", {

                                            "closeButton": false,
                                            "debug": false,
                                            "newestOnTop": false,
                                            "positionClass": "toast-bottom-left",
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
                                        return false;

                                    } else {

                                        formulario.submit();
                                        return true;

                                    }
                                }

                                function FechaActual() {
                                    var f = new Date();
                                    f = f.getFullYear() + "-" + (f.getMonth() + 1) + "-" + f.getDate();

                                    document.getElementById("fechaInicio").value = f;
                                    document.getElementById("fechaInicio").min = f;

                                    document.getElementById("fechaSalida").value = f;
                                    document.getElementById("fechaSalida").min = f;
                                }
                            </script>
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

        <!-- //end-smooth-scrolling -->
        <script src="js/bootstrap.js"></script>
        <!-- js file -->
        <!-- jQuery-Photo-filter-lightbox-Gallery-plugin -->
        <script src="js/jquery-1.7.2.js"></script>
        <script src="js/jquery.quicksand.js"></script>
        <script src="js/script.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <!-- //jQuery-Photo-filter-lightbox-Gallery-plugin -->
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCTOw0eddhzJALx1PKmKXmJg1_Q14HcsvQ&callback=initMap"
        async defer></script>

        <script
            src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
    </body>

</html>
