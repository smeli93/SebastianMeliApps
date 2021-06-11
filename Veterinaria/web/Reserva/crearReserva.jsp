<%-- 
    Document   : listaEspecialidad
    Created on : 25-11-2018, 15:01:39
    Author     : PC
--%>
<jsp:useBean id="lista" class="daoImpl.VeterinarioDAOImp"/>
<jsp:useBean id="lista2" class="daoImpl.MascotaDAOImp"/>
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
        <title>Reservar Hora Medica</title>
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
            <h1><b>Nueva Reserva M�dica</b></h1>
        </section>
    </div>
    <div class="wrapper row3" align="center">
        <main class="hoc container clear"> 

            <div class="content" align="center"> 

                <div class="scrollable" align="center">
                    <form action="/Veterinaria/CrearReserva" method="POST">
                        <table border="0" align="center">
                            <tbody align="center">
                            <tr>
                                <td>Motivo</td>
                                <td><input style="width: 300px; height: 30px; text-align: center;" type="text" name="txtMotivo" value="" placeholder="Ingrese El motivo" required/></td>
                            </tr>
                            <tr>
                                <td>Fecha</td>
                                <td><input style="width: 300px; height: 30px; text-align: center;"  type="date" name="txtFechaReserva"  size="90" value="" placeholder="Ingrese Fecha" required/></td>
                            </tr>
                            <tr >
                                <td>Hora</td>
                                <td><select style="width: 300px; height: 30px; text-align-last:center;"  name="cmbHoras">
                                        <option>00:00</option>
                                        <option>00:30</option>
                                        <option>01:00</option>
                                        <option>01:30</option>
                                        <option>02:00</option>
                                        <option>02:30</option>
                                        <option>03:00</option>
                                        <option>03:30</option>
                                        <option>04:00</option>
                                        <option>04:30</option>
                                        <option>05:00</option>
                                        <option>05:30</option>
                                        <option>06:00</option>
                                        <option>06:30</option>
                                        <option>07:00</option>
                                        <option>07:30</option>
                                        <option>08:00</option>
                                        <option>09:30</option>
                                        <option>10:00</option>
                                        <option>10:30</option>
                                        <option>11:00</option>
                                        <option>11:30</option>
                                        <option>12:00</option>
                                        <option>12:30</option>
                                        <option>13:00</option>
                                        <option>13:30</option>
                                        <option>14:00</option>
                                        <option>14:30</option>
                                        <option>15:00</option>
                                        <option>15:30</option>
                                        <option>16:00</option>
                                        <option>16:30</option>
                                        <option>17:00</option>
                                        <option>17:30</option>
                                        <option>18:00</option>
                                        <option>19:30</option>
                                        <option>20:00</option>
                                        <option>20:30</option>
                                        <option>21:00</option>
                                        <option>21:30</option>
                                        <option>22:00</option>
                                        <option>22:30</option>
                                        <option>23:00</option>
                                        <option>23:30</option>
                                    </select></td>
                            </tr>
                            <tr>
                                <td>Veterinario</td>
                                <td><select style="width: 300px; height: 30px; text-align-last:center;" name="cmbVeterinario" required>
                                        <c:forEach  var="vet" items="${lista.listarNombreVeterinario()}">
                                            <b><option><c:out value="${vet}" /></option></b>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>Rut Due�o Mascota</td>
                                <td><input style="width: 300px; height: 30px; text-align: center;" type="text" name="txtRut" value="" placeholder="Ingrese Su rut" required/></td>
                            </tr>
                            <tr>
                                <td>Identificador Mascota</td>
                                <td><input type="text" style="width: 300px; height: 30px; text-align: center;" name="txtMascota" value="" placeholder="Ingrese El codigo de la mascota" required/></td>
                            </tr>
                            </tbody>
                        </table>
                        <br>
                        <br>
                        <input type="submit" style="width: 300px; text-align: center;" class="btn" value="Reservar" name="btnEnviar""/>

                    </form>
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
