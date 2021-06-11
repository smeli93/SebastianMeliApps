
<%-- 
    Document   : listaEspecialidad
    Created on : 25-11-2018, 15:01:39
    Author     : PC
--%>
<%@page import="dto.Usuario"%>
<%@page session="true" %>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:ui="http://xmlns.jcp.org/jsf/facelets"
      xmlns:h="http://xmlns.jcp.org/jsf/html"
      xmlns:f="http://xmlns.jcp.org/jsf/core">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Lista de Horas Medicas</title>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
        <link href="/Veterinaria/resources/layout/styles/layout.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    <c:if test="${mensaje!=null}">
        <script>
            alert("${mensaje}");
        </script>
    </c:if>
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
                                <input class="btn" type="submit" value="Cerrar Sesi�n" name="btnLogout" required style="padding-left: 8px; padding-right: 8px; padding-bottom: 5px; padding-top: 5px; border-radius: 89px 89px 89px 89px;"/>
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
                            <td style="border:hidden;"><br></br><h1><a href="/Veterinaria/index.jsp"> Veterinaria NN</a></h1><p>Cl�nica Veterinaria</p></td> 
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
                                <td style="border:hidden;"><strong>LL�MANOS AHORA</strong><br></br>
                                    +00 (123) 456 7890</td> 
                                <td style="border:hidden;"><strong>HORARIO ATENCI�N</strong><br></br>
                                    21/7</td>
                            </tr>
                        </table>
                    </ul>
                </div>

                <!-- OPCIONES USUARIO -->

            </header>
            <nav id="mainav" class="hoc clear"> 
                <ul class="clear">
                    <li class="active"><a href="/Veterinaria/index.jsp">P�gina Principal</a></li>
                    <li><a href="#">Qui�nes Somos</a></li>
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
                    <%                        } else if (dto.getPerfilidPerfil() == 2) {
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

        <!-- CONTENIDO PAGINA -->

        <div class="wrapper bgded overlay" style="background-image:url('/Veterinaria/resources/images/demo/backgrounds/fondo.png');">
            <section id="breadcrumb" class="hoc clear"> 
                <h1><b>Reservas de horas M�dicas</b></h1>
            </section>
        </div>
        <div class="wrapper row3" align="center">
            <main class="hoc container clear"> 
                <!-- main body -->
                &nbsp;<input type="submit" class="btn" onclick="location.href = '/Veterinaria/Reserva/crearReserva.jsp'" value="+ nueva Reserva"/>
                <br>
                </br>
                <div class="content" align="center"> 

                    <div class="scrollable" align="center">
                        <table border="1" >
                            <tr>
                                <th>Id</th>
                                <th>Motivo</th>
                                <th>Fecha</th>
                                <th>Hora</th>
                                <th>Estado</th>
                                <th>Veterinario</th>
                                <th>Due�o Mascota</th>
                                <th>Mascota</th>
                                <%
                                    if (session.getAttribute("dto") != null) {
                                        Usuario dto = (Usuario) session.getAttribute("dto");
                                        if (dto.getPerfilidPerfil() == 2) {
                                %>                               
                                <th></th>
                                <th></th>
                                <%
                                        }
                                    }
                                %>

                            </tr>
                            <jsp:useBean class="daoImpl.ReservaDAOImp" id="resDAO"></jsp:useBean>
                            <c:forEach items="${resDAO.listarReservas()}" var="res">
                                <tr align="center">
                                    <td>${res.idReserva}</td>
                                    <td>${res.motivoReserva}</td>
                                    <td>${res.fechaReserva}</td>
                                    <td>${res.horaReserva}</td>
                                    <td>${res.estadoidEstado}</td>
                                    <td>${res.veterinarioidVeterinario}</td>
                                    <td>${res.usuariorutusuario}</td>
                                    <td>${res.mascotaidMascota}</td>
                                                                    <%
                                    if (session.getAttribute("dto") != null) {
                                        Usuario dto = (Usuario) session.getAttribute("dto");
                                        if (dto.getPerfilidPerfil() == 2) {
                                %>                               

                                    <td>
                                        <form id="veterinario" action="/Veterinaria/EliminarReserva" method="POST">
                                            <input type="hidden" name="btnEliminar" value="${res.idReserva}" > 
                                            <input name="btnEnviar" type="submit" value="Eliminar">
                                        </form>
                                    </td>
                                    <td>
                                        <form id="Reserva" action="/Veterinaria/BuscarReservaId" method="POST">
                                            <input type="hidden" name="txtMascota2" value="${res.mascotaidMascota}"> 
                                            <input type="hidden" name="txtId2" value="${res.idReserva}"> 
                                            <input name="btnEnviar" type="submit" value="Crear Procedimiento">
                                        </form> 
                                    </td>
                                <%
                                        }
                                    }
                                %>
                                </tr>                   
                            </c:forEach>
                        </table>
                    </div>

                </div>
            </main>
        </div>



        <a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a>

        <div class="wrapper row4 bgded overlay" style="background-image:url('/Veterinaria/resources/images/demo/backgrounds/fondo.png');">
            <footer id="footer" class="hoc clear"> 
                <hr class="btmspace-50"></hr>
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

            </footer>
        </div>
    </body>

</html>