package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dto.Usuario;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\"\n");
      out.write("      xmlns:h=\"http://xmlns.jcp.org/jsf/html\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <title>Página Principal</title>\n");
      out.write("        <meta charset=\"utf-8\"></meta>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\"/>\n");
      out.write("        <link href=\"/Veterinaria/resources/layout/styles/layout.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\"/>\n");
      out.write("        <link href=\"/Veterinaria/resources/layout/styles/layout.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <body id=\"top\"> \n");
      out.write("\n");
      out.write("        <!-- informacion superior -->\n");
      out.write("        <div class=\"wrapper row0\">\n");
      out.write("            <div id=\"topbar\" class=\"hoc clear\"> \n");
      out.write("                <!-- ################################################################################################ -->\n");
      out.write("                <div class=\"fl_left\">\n");
      out.write("                    <ul>\n");
      out.write("                        <li><i class=\"fa fa-map-marker\"></i> calle sin nombre 1123</li>\n");
      out.write("                        <li><i class=\"fa fa-envelope-o\"></i> info@clinicaVet.com</li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                 <!-- si se inicio sesion -->\n");
      out.write("                ");

                    if (session.getAttribute("dto") != null) {
                        Usuario dto = (Usuario) session.getAttribute("dto");
                        if (dto.getPerfilidPerfil() == 1 || dto.getPerfilidPerfil() == 2 || dto.getPerfilidPerfil() == 3) {
                
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"fl_right\">\n");
      out.write("                    <ul>\n");
      out.write("                        <li>Bienvenido(a): ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dto.nombreUsuario}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dto.apellidoUsuario}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</li>\n");
      out.write("                        <li>\n");
      out.write("                            <form action=\"/Veterinaria/Logout\" method=\"POST\">\n");
      out.write("                                <input class=\"btn\" type=\"submit\" value=\"Cerrar Sesión\" name=\"btnLogout\" required style=\"padding-left: 8px; padding-right: 8px; padding-bottom: 5px; padding-top: 5px; border-radius: 89px 89px 89px 89px;\"/>\n");
      out.write("                            </form>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("                        \n");
      out.write("                <!-- si aun no inicio sesion -->\n");
      out.write("                ");

                    }
                } else if (session.getAttribute("dto") == null) {
                
      out.write("    \n");
      out.write("                <div class=\"fl_right\">\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"/Veterinaria/login.jsp\">Ingresar</a></li>\n");
      out.write("                        <li><a href=\"/Veterinaria/Usuario/crearUsuario.jsp\">Registrarse</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                      \n");
      out.write("        <!-- MENU PRINCIPAL DEL SITIO-->\n");
      out.write("\n");
      out.write("        <div class=\"wrapper row1\">\n");
      out.write("            <header id=\"header\" class=\"hoc clear\"> \n");
      out.write("                <div id=\"logo\" class=\"fl_left\">\n");
      out.write("                    <table style=\"border:hidden;\">\n");
      out.write("                        <tr>\n");
      out.write("                            <td style=\"border:hidden;\"><a href=\"/Veterinaria/index.jsp\"><img src=\"/Veterinaria/resources/images/logo.png\" alt=\"\" width=\"20\" height=\"15\"/></a></td>\n");
      out.write("                            <td style=\"border:hidden;\"><br></br><h1><a href=\"/Veterinaria/index.jsp\"> Veterinaria NN</a></h1><p>Clínica Veterinaria</p></td> \n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"quickinfo\" class=\"fl_right\">\n");
      out.write("                    <ul class=\"nospace inline\">\n");
      out.write("\n");
      out.write("                        <table style=\"border:hidden;\">\n");
      out.write("                            <tr>\n");
      out.write("                                ");

                                    if (session.getAttribute("dto") != null) {
                                        Usuario dto = (Usuario) session.getAttribute("dto");
                                        if (dto.getPerfilidPerfil() == 2 || dto.getPerfilidPerfil() == 3) {
                                
      out.write("                               \n");
      out.write("                                <td style=\"border:hidden;\"><a class=\"btn\" href=\"/Veterinaria/menuReserva.jsp\" ><b>Reserva de Horas</b></a></td>\n");
      out.write("                                ");

                                        }
                                    }
                                
      out.write("\n");
      out.write("                                <td style=\"border:hidden;\"><strong>LLÁMANOS AHORA</strong><br></br>\n");
      out.write("                                    +00 (123) 456 7890</td> \n");
      out.write("                                <td style=\"border:hidden;\"><strong>HORARIO ATENCIÓN</strong><br></br>\n");
      out.write("                                    21/7</td>\n");
      out.write("                            </tr>\n");
      out.write("                        </table>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("                <!-- Menu Bar -->\n");
      out.write("            </header>\n");
      out.write("            <nav id=\"mainav\" class=\"hoc clear\"> \n");
      out.write("                <ul class=\"clear\">\n");
      out.write("                    <li class=\"active\"><a href=\"/Veterinaria/index.jsp\">Página Principal</a></li>\n");
      out.write("                    <li><a href=\"#\">Quiénes Somos</a></li>\n");
      out.write("                    <li><a href=\"#\">Servicios</a></li>\n");
      out.write("                    <li><a href=\"#\">Contacto</a></li>\n");
      out.write("                    <li><a href=\"#\"> &nbsp; </a></li>\n");
      out.write("                    <li><a href=\"#\"> &nbsp; </a></li>\n");
      out.write("                    <li><a href=\"#\"> &nbsp; </a></li>\n");
      out.write("                    <li><a href=\"#\"> &nbsp; </a></li>                    \n");
      out.write("                    \n");
      out.write("                        ");

                            if (session.getAttribute("dto") != null) {
                            Usuario dto = (Usuario) session.getAttribute("dto");
                            if (dto.getPerfilidPerfil() == 3) {
                        
                        
      out.write("\n");
      out.write("                        <li><a class=\"drop\" href=\"#\">Cliente</a>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"/Veterinaria/Usuario/PerfilUsuario.jsp\">Mi Perfil</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                        ");

                            }else if (dto.getPerfilidPerfil() == 2) {
                        
      out.write("\n");
      out.write("                        <li><a class=\"drop\" href=\"#\">Veterinario</a>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"/Veterinaria/Usuario/PerfilUsuario.jsp\">Mi Perfil</a></li>\n");
      out.write("                                <li><a href=\"/Veterinaria/Veterinario/listaVeterinario.jsp\">Adm. Veterinarios</a></li>\n");
      out.write("                                <li><a href=\"/Veterinaria/Mascota/listaMascotas.jsp\">Adm. Mascotas</a></li>\n");
      out.write("                                <li><a href=\"/Veterinaria/Raza/listaRaza.jsp\">Adm. Razas</a></li>\n");
      out.write("                                <li><a href=\"/Veterinaria/TipoMascota/listaTipoMascota.jsp\">Adm. Tipos Mascotas</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                        ");

                            } else if (dto.getPerfilidPerfil() == 1) {
                        
      out.write("\n");
      out.write("                        <li><a class=\"drop\" href=\"#\">Administrador</a>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"/Veterinaria/Usuario/PerfilUsuario.jsp\">Mi Perfil</a></li>\n");
      out.write("                                <li><a href=\"/Veterinaria/Usuario/listaUsuarios.jsp\">Adm. Usuarios</a></li>\n");
      out.write("                                <li><a href=\"/Veterinaria/Veterinario/listaVeterinario.jsp\">Adm. Veterinarios</a></li>\n");
      out.write("                                <li><a href=\"/Veterinaria/Especialidad/listaEspecialidad.jsp\">Adm. Especialidades</a></li>\n");
      out.write("                                <li><a href=\"/Veterinaria/Estado/listaEstado.jsp\">Adm. Estados</a></li>\n");
      out.write("                                <li><a href=\"/Veterinaria/Perfil/listaPerfil.jsp\">Adm. Perfiles</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>                     \n");
      out.write("                        ");

                            }
                        }
                        
      out.write("                    \n");
      out.write("      \n");
      out.write("                </ul>\n");
      out.write("            </nav>\n");
      out.write("        </div>\n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("        <!-- Contenido Pagina principal -->\n");
      out.write("        \n");
      out.write("        <div class=\"wrapper bgded overlay\" style=\"background-image:url('/Veterinaria/resources/images/demo/backgrounds/descarga.jpg');\">\n");
      out.write("            <div id=\"pageintro\" class=\"hoc clear\"> \n");
      out.write("                <div class=\"flexslider basicslider\">\n");
      out.write("                    <ul class=\"slides\">\n");
      out.write("                        <li>\n");
      out.write("                            <article>\n");
      out.write("                                <h6>Brindar atención especial</h6>\n");
      out.write("                                <h3 class=\"heading\">Para sus mascotas</h3>\n");
      out.write("                                <p></p>\n");
      out.write("                                <p>Tu mascota está en buenas manos con nosotros!<br></br>\n");
      out.write("                                    Deja que tu favorito reciba la mejor atención en nuestro centro.</p>\n");
      out.write("                            </article>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <article>\n");
      out.write("                                <h6>Mantener a su mascota en</h6>\n");
      out.write("                                <h4 class=\"heading\">El camino hacia el bienestar</h4>\n");
      out.write("                                <p></p>\n");
      out.write("                                <p>Atención compasiva y de alta calidad.<br></br>\n");
      out.write("                                    El amor es la mejor medicina.</p>\n");
      out.write("                            </article>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("\n");
      out.write("        <div class=\"wrapper row3\">\n");
      out.write("            <main class=\"hoc container clear\"> \n");
      out.write("                <!-- Menu body -->\n");
      out.write("                <div class=\"sectiontitle\">\n");
      out.write("                    <h3><b>Servicios Veterinaria</b></h3>\n");
      out.write("                    <p>Realizamos los servicios necesarios para que tu mascota se recupetre de forma optima</p>\n");
      out.write("                </div>\n");
      out.write("                <ul class=\"nospace group\">\n");
      out.write("                    <li class=\"one_third first\">\n");
      out.write("                        <article><i class=\"btmspace-30 fa fa-3x fa-laptop\"></i>\n");
      out.write("                            <h6 class=\"heading font-x1\">Integer sodales odio</h6>\n");
      out.write("                            <p class=\"btmspace-30\">Mattis erat pede at magna maecenas ut eros vel tortor viverra auctor phasellus ligula lobortis vivamus ultricies [&hellip;]</p>\n");
      out.write("                            <footer><a class=\"btn\" href=\"#\">Read More &rsaquo;</a></footer>\n");
      out.write("                        </article>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"one_third\">\n");
      out.write("                        <article><i class=\"btmspace-30 fa fa-3x fa-lastfm\"></i>\n");
      out.write("                            <h6 class=\"heading font-x1\">Ultrices feugiat ligula</h6>\n");
      out.write("                            <p class=\"btmspace-30\">Massa eget sapienfusce ornare suscipit massa duis sed magnacras condimentum tempor tortor integer id urna [&hellip;]</p>\n");
      out.write("                            <footer><a class=\"btn\" href=\"#\">Read More &rsaquo;</a></footer>\n");
      out.write("                        </article>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"one_third\">\n");
      out.write("                        <article><i class=\"btmspace-30 fa fa-3x fa-codiepie\"></i>\n");
      out.write("                            <h6 class=\"heading font-x1\">Augue tempor orci</h6>\n");
      out.write("                            <p class=\"btmspace-30\">Eros mauris cursus quam consectetuer tincidunt est mi bibendum risus nec rutrum mi justo sit amet mi suspendisse [&hellip;]</p>\n");
      out.write("                            <footer><a class=\"btn\" href=\"#\">Read More &rsaquo;</a></footer>\n");
      out.write("                        </article>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("                <!-- ################################################################################################ -->\n");
      out.write("                <!-- / main body -->\n");
      out.write("                <div class=\"clear\"></div>\n");
      out.write("            </main>\n");
      out.write("        </div>\n");
      out.write("        <!-- ################################################################################################ -->\n");
      out.write("        <!-- ################################################################################################ -->\n");
      out.write("        <!-- ################################################################################################ -->\n");
      out.write("\n");
      out.write("        <div class=\"wrapper row4 bgded overlay\" style=\"background-image:url('/Veterinaria/resources/images/demo/backgrounds/fondo.png');\">\n");
      out.write("            <footer id=\"footer\" class=\"hoc clear\"> \n");
      out.write("                <!-- ################################################################################################ -->\n");
      out.write("                <hr class=\"btmspace-50\"></hr>\n");
      out.write("                <!-- ################################################################################################ -->\n");
      out.write("                <div class=\"group\">\n");
      out.write("                    <div class=\"one_half first\">\n");
      out.write("                        <h6 class=\"heading\">Curabitur varius cursus</h6>\n");
      out.write("                        <ul class=\"nospace btmspace-30 linklist contact\">\n");
      out.write("                            <li><i class=\"fa fa-map-marker\"></i>\n");
      out.write("                                <address>\n");
      out.write("                                    Street Name &amp; Number, Town, Postcode/Zip\n");
      out.write("                                </address>\n");
      out.write("                            </li>\n");
      out.write("                            <li><i class=\"fa fa-phone\"></i> +00 (123) 456 7890</li>\n");
      out.write("                            <li><i class=\"fa fa-fax\"></i> +00 (123) 456 7890</li>\n");
      out.write("                            <li><i class=\"fa fa-envelope-o\"></i> info@domain.com</li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"one_half\">\n");
      out.write("                        <h6 class=\"heading\">Magna mattis nibh ut</h6>\n");
      out.write("                        <figure>\n");
      out.write("\n");
      out.write("                            <figcaption>\n");
      out.write("                                <h6 class=\"nospace font-x1\"><a href=\"#\">Proin commodo semper</a></h6>\n");
      out.write("                                <time class=\"font-xs block btmspace-10\" datetime=\"2045-04-06\">Friday, 6<sup>th</sup> April 2045</time>\n");
      out.write("                            </figcaption>\n");
      out.write("                        </figure>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <!-- ################################################################################################ -->\n");
      out.write("            </footer>\n");
      out.write("        </div>\n");
      out.write("        <a id=\"backtotop\" href=\"#top\"><i class=\"fa fa-chevron-up\"></i></a>\n");
      out.write("        <!-- JAVASCRIPTS -->\n");
      out.write("        <script src=\"/Veterinaria/resources/layout/scripts/jquery.min.js\"></script>\n");
      out.write("        <script src=\"/Veterinaria/resources/layout/scripts/jquery.backtotop.js\"></script>\n");
      out.write("        <script src=\"/Veterinaria/resources/layout/scripts/jquery.mobilemenu.js\"></script>\n");
      out.write("        <script src=\"/Veterinaria/resources/layout/scripts/jquery.flexslider-min.js\"></script>\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
