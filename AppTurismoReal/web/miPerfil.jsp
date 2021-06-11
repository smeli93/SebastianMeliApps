<%@page import="dto.UsuarioDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="daoImp.UsuarioDaoImp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zxx">

    <head>
        <title>Mi Perfil</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta charset="utf-8">

        <!--/CSS-->
        <link href="css/bootstrap.css" rel='stylesheet' type='text/css'/>
        <link href="css/prettyPhoto.css" rel="stylesheet" type="text/css">
        <link href="css/style.css" rel='stylesheet' type='text/css' />
        <link href="css/button.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

        <!--/FONTS-->
        <link href="https://fonts.googleapis.com/css?family=Ubuntu&display=swap" rel="stylesheet">
        <script src="https://kit.fontawesome.com/662e51b710.js" crossorigin="anonymous"></script>
        <style>
            body,h1,h2,h3,h4,h5,h6 {font-family: "Ubuntu", Arial, Helvetica, sans-serif}
            .mySlides {display:none}
        </style>

        <!--/JS-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script> 
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script> 
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
                                UsuarioDto usuario = (UsuarioDto) session.getAttribute("dto");

                        %>
                        <ul class="navbar-nav ml-auto">
                            <li class="nav-item ml-xl-2">

                                <button type="button" class="btn btn-info " onclick="location.href = 'miPerfil.jsp?rut=<%=usuario.getRutPersona().getRut()%>'" class="btn btn-info btn-block">Mi Perfil</button>
                            </li>                         
                            <form id="logout" action="/AppTurismoReal/Logout" method="POST">
                                <li class="nav-item ml-xl-2">
                                    <a class="nav-link" onclick="document.getElementById('logout').submit();">Cerrar Sesion</a>
                                </li>                                 

                            </form>
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

        <section class="banner-w3layouts-bottom1">
            <%
                UsuarioDaoImp dao = new UsuarioDaoImp();
                 UsuarioDto usuario = (UsuarioDto) session.getAttribute("dto");
                ArrayList<UsuarioDto> list = dao.buscarPorRut(usuario.getRutPersona().getRut());
                for (UsuarioDto var : list) {

            %>
            <div class="container py-lg-4 py-3" style=" justify-content: center;">
                <div id="contenedor">
                    <div id="fila">
                        <div id="columna1"  >                        
                            <table id="tablaCatalogo">              
                                <tbody>   

                                <th>
                                    <div class="text-info-sec">
                                        <div class="card" style="width: 280px; height: 450px ; text-align: center; margin-bottom: 50px;">
                                            <div class="card-body">

                                                <img src="images/path859.png" class="img-responsive1"/>
                                                <br>
                                                <br>
                                                <h3 class="labelP1"><b><%= var.getRutPersona().getPrimer_nombre()%> <%= var.getRutPersona().getAp_paterno()%></b></h3>
                                                <h3 class="labelP1"> <%= var.getRutPersona().getRut()%> </h3>
                                                <br>
                                                <hr>
                                                <a class="nav-link" href="#">Eliminar Cuenta</a>                                              
                                            </div>
                                        </div>
                                    </div>
                                </th>

                                </tbody>

                            </table>
                        </div>



                        <div id="columna2">
                            <!-- !PAGE CONTENT! -->
                            <div class="w3-main" style="margin-left:20px;">

                                <table id="tablaCatalogo">              
                                    <tbody>   

                                    <th>
                                        <div class="text-info-sec">

                                            <div class="card" style="width: 800px; height: 500px; ">

                                                <!-- !TABS! -->
                                                <ul class="nav nav-tabs" id="myTab" role="tablist">
                                                    <li class="nav-item">
                                                        <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true"><label class="fa fa-user-circle"></label> Mi Información</a>
                                                    </li>
                                                    <li class="nav-item">
                                                        <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false"><label class="fa fa-edit"></label> Actualizar Datos</a>
                                                    </li>
                                                    <li class="nav-item">
                                                        <a class="nav-link" id="contact-tab" data-toggle="tab" href="#contact" role="tab" aria-controls="contact" aria-selected="false"><label class="fa fa-calendar-check"></label> Mis Reservas</a>
                                                    </li>
                                                </ul>

                                                <div class="card-body">

                                                    <div class="tab-content" id="myTabContent">

                                                        <!-- !TABS NUMERO 1! -->
                                                        <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">


                                                            <br>
                                                            <table border="0" style="text-align: center;">
                                                                <tbody>

                                                                    <tr>
                                                                        <td>
                                                                            <h6 class="labelP"><b> Segundo Nombre </b></h6>

                                                                        </td>                                           
                                                                        <td>
                                                                            <h6 class="labelP2"> <%= var.getRutPersona().getSegundo_nombre()%> </h6>
                                                                        </td>
                                                                    </tr>                                                                            
                                                                    <tr>
                                                                        <td>
                                                                            <h6 class="labelP"><b> Apellido Materno </b></h6>

                                                                        </td>                                           
                                                                        <td>
                                                                            <h6 class="labelP2"> <%= var.getRutPersona().getAp_materno()%> </h6>
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>
                                                                            <h6 class="labelP"><b> Dirección </b></h6>

                                                                        </td>                                           
                                                                        <td>
                                                                            <h6 class="labelP2"> <%= var.getRutPersona().getDireccion()%> </h6>
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>
                                                                            <h6 class="labelP"><b> Numero Telefono </b></h6>

                                                                        </td>                                           
                                                                        <td>
                                                                            <h6 class="labelP2"> <%= var.getRutPersona().getTelefono()%> </h6>
                                                                        </td>
                                                                    </tr>                                                                      
                                                                    <tr>
                                                                        <td>
                                                                            <h6 class="labelP"><b> Correo Electronico </b></h6>

                                                                        </td>                                           
                                                                        <td>
                                                                            <h6 class="labelP2"> <%= var.getEmail()%> </h6>
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>
                                                                            <h6 class="labelP"><b> Fecha Nacimiento </b></h6>

                                                                        </td>                                           
                                                                        <td>
                                                                            <h6 class="labelP2"> <%= var.getRutPersona().getFecha_nacimiento()%> </h6>
                                                                        </td>
                                                                    </tr>


                                                                </tbody>
                                                            </table>

                                                        </div>


                                                        <!-- !TABS NUMERO 2! -->
                                                        <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                                                            <form id="" action="/AppTurismoReal/ModificarMiPerfil" method="POST">
                                                                <div class="card">
                                                                    <div class="card-body">

                                                                        <table border="0">
                                                                            <input type="hidden" class="form-control1" value="<%= var.getRutPersona().getRut()%>" name="rut" placeholder="Primer Nombre">
                                                                            <tbody>
                                                                                <tr>
                                                                                    <td>

                                                                            <h7 class="labelP3"><b> Primer Nombre* </b></h7>
                                                                            <input type="text" class="form-control1" value="<%= var.getRutPersona().getPrimer_nombre()%>" name="priNombre" placeholder="Primer Nombre">

                                                                            </td>                                           
                                                                            <td>
                                                                            <h7 class="labelP3"><b> Segundo Nombre* </b></h7>
                                                                            <input type="text" class="form-control1" value="<%= var.getRutPersona().getSegundo_nombre()%>" name="segNombre" placeholder="Segundo Nombre">
                                                                            </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>
                                                                            <h7 class="labelP3"><b> Apellido Paterno* </b></h7>
                                                                            <input type="text" class="form-control1" value="<%= var.getRutPersona().getAp_paterno()%>" name="paterno" placeholder="Apellido Paterno">
                                                                            </td>                                           
                                                                            <td>
                                                                            <h7 class="labelP3"><b> Apellido Materno* </b></h7>
                                                                            <input type="text" class="form-control1" value="<%= var.getRutPersona().getAp_materno()%>" name="materno" placeholder="Apellido Materno">
                                                                            </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>
                                                                            <h7 class="labelP3"><b> Dirección* </b></h7>
                                                                            <input type="text" class="form-control1" value="<%= var.getRutPersona().getDireccion()%>" name="direccion" placeholder="Dirección">
                                                                            </td>                                           
                                                                            <td>
                                                                            <h7 class="labelP3"><b> Numero Telefono* </b></h7>
                                                                            <input type="text" class="form-control1" value="<%= var.getRutPersona().getTelefono()%>" name="telefono" placeholder="Telefono">
                                                                            </td>
                                                                            </tr>                                                                            
                                                                            <tr>
                                                                                <td>
                                                                            <h7 class="labelP3"><b> Fecha Nacimiento* </b></h7>
                                                                            <input type="date" class="form-control1" value="<%= var.getRutPersona().getFecha_nacimiento()%>" name="fechNacimiento" placeholder="Fecha Nacimiento">
                                                                            </td>                                           

                                                                            </tr>



                                                                            </tbody>
                                                                        </table>
                                                                    </div>
                                                                </div>
                                                                <br>
                                                                <input class="btn btn-info btn-block" type="submit" value="Guardar">
                                                            </form>



                                                        </div>
                                                        <% }%>

                                                        <!-- !TABS NUMERO 3! -->
                                                        <div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab">
                                                            <div class="table-wrapper">

                                                                <br>
                                                                <table class="table table-striped table-hover table-bordered">
                                                                    <thead>
                                                                        <tr>
                                                                            <th>Id</th>
                                                                            <th>Nombre</th>
                                                                            <th>Dirección</th>
                                                                            <th>Ciudad</th>
                                                                            <th>Estado</th>
                                                                            <th>Ciudad</th>
                                                                            <th>Acciones</th>
                                                                        </tr>
                                                                    </thead>
                                                                    <tbody>
                                                                        <tr>
                                                                            <td>1</td>
                                                                            <td>Thomas Hardy</td>
                                                                            <td>89 Chiaroscuro Rd.</td>
                                                                            <td>Portland</td>
                                                                            <td>Pendiente</td>
                                                                            <td>USA</td>
                                                                            <td>
                                                                                <button type="button" class="btndele">Cancelar</button>
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td>2</td>
                                                                            <td>Maria Anders</td>
                                                                            <td>Obere Str. 57</td>
                                                                            <td>Berlin</td>
                                                                            <td>Pendiente</td>
                                                                            <td>Germany</td>
                                                                            <td>
                                                                                <button type="button" class="btndele">Cancelar</button>
                                                                            </td>
                                                                        </tr>


                                                                    </tbody>
                                                                </table>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </th>

                                    </tbody>

                                </table>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
            <br>
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
        <!-- JS -->
        <script src="js/jquery-2.2.3.min.js"></script>
        <script src="js/bootstrap.js"></script>
        <script src="js/script.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>




    </body>

</html>

