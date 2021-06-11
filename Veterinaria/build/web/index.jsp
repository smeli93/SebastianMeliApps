<%@page import="dto.Usuario"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html">

    <head>
        <title>Página Principal</title>
        <meta charset="utf-8"></meta>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
        <link href="/Veterinaria/resources/layout/styles/layout.css" rel="stylesheet" type="text/css" media="all"/>
        <link href="/Veterinaria/resources/layout/styles/layout.css" rel="stylesheet" type="text/css"/>
    </head>


    <body id="top"> 

        <!-- informacion superior -->
        <div class="wrapper row0">
            <div id="topbar" class="hoc clear"> 
                <!-- ################################################################################################ -->
                <div class="fl_left">
                    <ul>
                        <li><i class="fa fa-map-marker"></i> calle sin nombre 1123</li>
                        <li><i class="fa fa-envelope-o"></i> info@clinicaVet.com</li>
                    </ul>
                </div>

                 <!-- si se inicio sesion -->
                <%
                    if (session.getAttribute("dto") != null) {
                        Usuario dto = (Usuario) session.getAttribute("dto");
                        if (dto.getPerfilidPerfil() == 1 || dto.getPerfilidPerfil() == 2 || dto.getPerfilidPerfil() == 3) {
                %>

                <div class="fl_right">
                    <ul>
                        <li>Bienvenido(a): ${dto.nombreUsuario} ${dto.apellidoUsuario}</li>
                        <li>
                            <form action="/Veterinaria/Logout" method="POST">
                                <input class="btn" type="submit" value="Cerrar Sesión" name="btnLogout" required style="padding-left: 8px; padding-right: 8px; padding-bottom: 5px; padding-top: 5px; border-radius: 89px 89px 89px 89px;"/>
                            </form>
                        </li>
                    </ul>
                </div>
                        
                <!-- si aun no inicio sesion -->
                <%
                    }
                } else if (session.getAttribute("dto") == null) {
                %>    
                <div class="fl_right">
                    <ul>
                        <li><a href="/Veterinaria/login.jsp">Ingresar</a></li>
                        <li><a href="/Veterinaria/Usuario/crearUsuario.jsp">Registrarse</a></li>
                    </ul>
                </div>
                <%
                    }
                %>

            </div>
        </div>
                        
                        
                        
                      
        <!-- MENU PRINCIPAL DEL SITIO-->

        <div class="wrapper row1">
            <header id="header" class="hoc clear"> 
                <div id="logo" class="fl_left">
                    <table style="border:hidden;">
                        <tr>
                            <td style="border:hidden;"><a href="/Veterinaria/index.jsp"><img src="/Veterinaria/resources/images/logo.png" alt="" width="20" height="15"/></a></td>
                            <td style="border:hidden;"><br></br><h1><a href="/Veterinaria/index.jsp"> Veterinaria NN</a></h1><p>Clínica Veterinaria</p></td> 
                        </tr>
                    </table>
                </div>
                <div id="quickinfo" class="fl_right">
                    <ul class="nospace inline">

                        <table style="border:hidden;">
                            <tr>
                                <%
                                    if (session.getAttribute("dto") != null) {
                                        Usuario dto = (Usuario) session.getAttribute("dto");
                                        if (dto.getPerfilidPerfil() == 2 || dto.getPerfilidPerfil() == 3) {
                                %>                               
                                <td style="border:hidden;"><a class="btn" href="/Veterinaria/menuReserva.jsp" ><b>Reserva de Horas</b></a></td>
                                <%
                                        }
                                    }
                                %>
                                <td style="border:hidden;"><strong>LLÁMANOS AHORA</strong><br></br>
                                    +00 (123) 456 7890</td> 
                                <td style="border:hidden;"><strong>HORARIO ATENCIÓN</strong><br></br>
                                    21/7</td>
                            </tr>
                        </table>
                    </ul>
                </div>
                <!-- Menu Bar -->
            </header>
            <nav id="mainav" class="hoc clear"> 
                <ul class="clear">
                    <li class="active"><a href="/Veterinaria/index.jsp">Página Principal</a></li>
                    <li><a href="#">Quiénes Somos</a></li>
                    <li><a href="#">Servicios</a></li>
                    <li><a href="#">Contacto</a></li>
                    <li><a href="#"> &nbsp; </a></li>
                    <li><a href="#"> &nbsp; </a></li>
                    <li><a href="#"> &nbsp; </a></li>
                    <li><a href="#"> &nbsp; </a></li>                    
                    
                        <%
                            if (session.getAttribute("dto") != null) {
                            Usuario dto = (Usuario) session.getAttribute("dto");
                            if (dto.getPerfilidPerfil() == 3) {
                        
                        %>
                        <li><a class="drop" href="#">Cliente</a>
                            <ul>
                                <li><a href="/Veterinaria/Usuario/PerfilUsuario.jsp">Mi Perfil</a></li>
                            </ul>
                        </li>
                        <%
                            }else if (dto.getPerfilidPerfil() == 2) {
                        %>
                        <li><a class="drop" href="#">Veterinario</a>
                            <ul>
                                <li><a href="/Veterinaria/Usuario/PerfilUsuario.jsp">Mi Perfil</a></li>
                                <li><a href="/Veterinaria/Veterinario/listaVeterinario.jsp">Adm. Veterinarios</a></li>
                                <li><a href="/Veterinaria/Mascota/listaMascotas.jsp">Adm. Mascotas</a></li>
                                <li><a href="/Veterinaria/Raza/listaRaza.jsp">Adm. Razas</a></li>
                                <li><a href="/Veterinaria/TipoMascota/listaTipoMascota.jsp">Adm. Tipos Mascotas</a></li>
                            </ul>
                        </li>
                        <%
                            } else if (dto.getPerfilidPerfil() == 1) {
                        %>
                        <li><a class="drop" href="#">Administrador</a>
                            <ul>
                                <li><a href="/Veterinaria/Usuario/PerfilUsuario.jsp">Mi Perfil</a></li>
                                <li><a href="/Veterinaria/Usuario/listaUsuarios.jsp">Adm. Usuarios</a></li>
                                <li><a href="/Veterinaria/Veterinario/listaVeterinario.jsp">Adm. Veterinarios</a></li>
                                <li><a href="/Veterinaria/Especialidad/listaEspecialidad.jsp">Adm. Especialidades</a></li>
                                <li><a href="/Veterinaria/Estado/listaEstado.jsp">Adm. Estados</a></li>
                                <li><a href="/Veterinaria/Perfil/listaPerfil.jsp">Adm. Perfiles</a></li>
                            </ul>
                        </li>                     
                        <%
                            }
                        }
                        %>                    
      
                </ul>
            </nav>
        </div>
                        
                        
        <!-- Contenido Pagina principal -->
        
        <div class="wrapper bgded overlay" style="background-image:url('/Veterinaria/resources/images/demo/backgrounds/descarga.jpg');">
            <div id="pageintro" class="hoc clear"> 
                <div class="flexslider basicslider">
                    <ul class="slides">
                        <li>
                            <article>
                                <h6>Brindar atención especial</h6>
                                <h3 class="heading">Para sus mascotas</h3>
                                <p></p>
                                <p>Tu mascota está en buenas manos con nosotros!<br></br>
                                    Deja que tu favorito reciba la mejor atención en nuestro centro.</p>
                            </article>
                        </li>
                        <li>
                            <article>
                                <h6>Mantener a su mascota en</h6>
                                <h4 class="heading">El camino hacia el bienestar</h4>
                                <p></p>
                                <p>Atención compasiva y de alta calidad.<br></br>
                                    El amor es la mejor medicina.</p>
                            </article>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        

        <div class="wrapper row3">
            <main class="hoc container clear"> 
                <!-- Menu body -->
                <div class="sectiontitle">
                    <h3><b>Servicios Veterinaria</b></h3>
                    <p>Realizamos los servicios necesarios para que tu mascota se recupetre de forma optima</p>
                </div>
                <ul class="nospace group">
                    <li class="one_third first">
                        <article><i class="btmspace-30 fa fa-3x fa-laptop"></i>
                            <h6 class="heading font-x1">Integer sodales odio</h6>
                            <p class="btmspace-30">Mattis erat pede at magna maecenas ut eros vel tortor viverra auctor phasellus ligula lobortis vivamus ultricies [&hellip;]</p>
                            <footer><a class="btn" href="#">Read More &rsaquo;</a></footer>
                        </article>
                    </li>
                    <li class="one_third">
                        <article><i class="btmspace-30 fa fa-3x fa-lastfm"></i>
                            <h6 class="heading font-x1">Ultrices feugiat ligula</h6>
                            <p class="btmspace-30">Massa eget sapienfusce ornare suscipit massa duis sed magnacras condimentum tempor tortor integer id urna [&hellip;]</p>
                            <footer><a class="btn" href="#">Read More &rsaquo;</a></footer>
                        </article>
                    </li>
                    <li class="one_third">
                        <article><i class="btmspace-30 fa fa-3x fa-codiepie"></i>
                            <h6 class="heading font-x1">Augue tempor orci</h6>
                            <p class="btmspace-30">Eros mauris cursus quam consectetuer tincidunt est mi bibendum risus nec rutrum mi justo sit amet mi suspendisse [&hellip;]</p>
                            <footer><a class="btn" href="#">Read More &rsaquo;</a></footer>
                        </article>
                    </li>
                </ul>
                <!-- ################################################################################################ -->
                <!-- / main body -->
                <div class="clear"></div>
            </main>
        </div>
        <!-- ################################################################################################ -->
        <!-- ################################################################################################ -->
        <!-- ################################################################################################ -->

        <div class="wrapper row4 bgded overlay" style="background-image:url('/Veterinaria/resources/images/demo/backgrounds/fondo.png');">
            <footer id="footer" class="hoc clear"> 
                <!-- ################################################################################################ -->
                <hr class="btmspace-50"></hr>
                <!-- ################################################################################################ -->
                <div class="group">
                    <div class="one_half first">
                        <h6 class="heading">Curabitur varius cursus</h6>
                        <ul class="nospace btmspace-30 linklist contact">
                            <li><i class="fa fa-map-marker"></i>
                                <address>
                                    Street Name &amp; Number, Town, Postcode/Zip
                                </address>
                            </li>
                            <li><i class="fa fa-phone"></i> +00 (123) 456 7890</li>
                            <li><i class="fa fa-fax"></i> +00 (123) 456 7890</li>
                            <li><i class="fa fa-envelope-o"></i> info@domain.com</li>
                        </ul>
                    </div>
                    <div class="one_half">
                        <h6 class="heading">Magna mattis nibh ut</h6>
                        <figure>

                            <figcaption>
                                <h6 class="nospace font-x1"><a href="#">Proin commodo semper</a></h6>
                                <time class="font-xs block btmspace-10" datetime="2045-04-06">Friday, 6<sup>th</sup> April 2045</time>
                            </figcaption>
                        </figure>
                    </div>

                </div>
                <!-- ################################################################################################ -->
            </footer>
        </div>
        <a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a>
        <!-- JAVASCRIPTS -->
        <script src="/Veterinaria/resources/layout/scripts/jquery.min.js"></script>
        <script src="/Veterinaria/resources/layout/scripts/jquery.backtotop.js"></script>
        <script src="/Veterinaria/resources/layout/scripts/jquery.mobilemenu.js"></script>
        <script src="/Veterinaria/resources/layout/scripts/jquery.flexslider-min.js"></script>

</html>


