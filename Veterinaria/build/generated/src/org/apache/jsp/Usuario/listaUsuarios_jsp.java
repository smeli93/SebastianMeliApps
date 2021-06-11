package org.apache.jsp.Usuario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dto.Usuario;

public final class listaUsuarios_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\"\n");
      out.write("      xmlns:ui=\"http://xmlns.jcp.org/jsf/facelets\"\n");
      out.write("      xmlns:h=\"http://xmlns.jcp.org/jsf/html\"\n");
      out.write("      xmlns:f=\"http://xmlns.jcp.org/jsf/core\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n");
      out.write("        <title>Lista tipo de mascotas</title>\n");
      out.write("        <meta charset=\"utf-8\"/>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\"/>\n");
      out.write("        <link href=\"../resources/layout/styles/layout.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
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
      out.write("                <!-- si se inicio sesion -->\n");
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
      out.write("\n");
      out.write("                <!-- si aun no inicio sesion -->\n");
      out.write("                ");

                    }
                } else if (session.getAttribute("dto") == null) {
                
      out.write("    \n");
      out.write("                <div class=\"fl_right\">\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"../login.jsp\">Ingresar</a></li>\n");
      out.write("                        <li><a href=\"../Usuario/crearUsuario.jsp\">Registrarse</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- MENU PRINCIPAL DEL SITIO-->\n");
      out.write("\n");
      out.write("        <div class=\"wrapper row1\">\n");
      out.write("            <header id=\"header\" class=\"hoc clear\"> \n");
      out.write("                <div id=\"logo\" class=\"fl_left\">\n");
      out.write("                    <table style=\"border:hidden;\">\n");
      out.write("                        <tr>\n");
      out.write("                            <td style=\"border:hidden;\"><a href=\"../index.jsp\"><img src=\"../resources/images/logo.png\" alt=\"\" width=\"20\" height=\"15\"/></a></td>\n");
      out.write("                            <td style=\"border:hidden;\"><br></br><h1><a href=\"../index.jsp\"> Veterinaria NN</a></h1><p>Clínica Veterinaria</p></td> \n");
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
      out.write("                                <td style=\"border:hidden;\"><a class=\"btn\" href=\"../menuReserva.jsp\" ><b>Reserva de Horas</b></a></td>\n");
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
      out.write("\n");
      out.write("                <!-- OPCIONES USUARIO -->\n");
      out.write("\n");
      out.write("            </header>\n");
      out.write("            <nav id=\"mainav\" class=\"hoc clear\"> \n");
      out.write("                <ul class=\"clear\">\n");
      out.write("                    <li class=\"active\"><a href=\"../index.jsp\">Página Principal</a></li>\n");
      out.write("                    <li><a href=\"#\">Quiénes Somos</a></li>\n");
      out.write("                    <li><a href=\"#\">Servicios</a></li>\n");
      out.write("                    <li><a href=\"#\">Contacto</a></li>\n");
      out.write("                    <li><a href=\"#\"> &nbsp; </a></li>\n");
      out.write("                    <li><a href=\"#\"> &nbsp; </a></li>\n");
      out.write("                    <li><a href=\"#\"> &nbsp; </a></li>\n");
      out.write("                    <li><a href=\"#\"> &nbsp; </a></li>                    \n");
      out.write("\n");
      out.write("                    ");

                        if (session.getAttribute("dto") != null) {
                            Usuario dto = (Usuario) session.getAttribute("dto");
                            if (dto.getPerfilidPerfil() == 3) {

                    
      out.write("\n");
      out.write("                    <li><a class=\"drop\" href=\"#\">Cliente</a>\n");
      out.write("                        <ul>\n");
      out.write("                            <li><a href=\"\">Mi Perfil</a></li>\n");
      out.write("                            <li><a href=\"\">Mis Mascotas</a></li>\n");
      out.write("\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                    ");
                        } else if (dto.getPerfilidPerfil() == 2) {
                    
      out.write("\n");
      out.write("                    <li><a class=\"drop\" href=\"#\">Veterinario</a>\n");
      out.write("                        <ul>\n");
      out.write("                            <li><a href=\"\">Mi Perfil</a></li>\n");
      out.write("                            <li><a href=\"../Veterinario/listaVeterinario.jsp\">Adm. Veterinarios</a></li>\n");
      out.write("                            <li><a href=\"../Mascota/listaMascota.jsp\">Adm. Mascotas</a></li>\n");
      out.write("                            <li><a href=\"../Raza/listaRaza.jsp\">Adm. Razas</a></li>\n");
      out.write("                            <li><a href=\"../TipoMascota/listaTipoMascota.jsp\">Adm. Tipos Mascotas</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                    ");

                    } else if (dto.getPerfilidPerfil() == 1) {
                    
      out.write("\n");
      out.write("                    <li><a class=\"drop\" href=\"#\">Administrador</a>\n");
      out.write("                        <ul>\n");
      out.write("                            <li><a href=\"\">Mi Perfil</a></li>\n");
      out.write("                            <li><a href=\"../Usuario/listaUsuarios.jsp\">Adm. Usuarios</a></li>\n");
      out.write("                            <li><a href=\"../Veterinario/listaVeterinario.jsp\">Adm. Veterinarios</a></li>\n");
      out.write("                            <li><a href=\"../Especialidad/listaEspecialidad.jsp\">Adm. Especialidades</a></li>\n");
      out.write("                            <li><a href=\"../Estado/listaEstado.jsp\">Adm. Estados</a></li>\n");
      out.write("                            <li><a href=\"../Perfil/listaPerfil.jsp\">Adm. Perfiles</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>                     \n");
      out.write("                    ");

                            }
                        }
                    
      out.write("                    \n");
      out.write("\n");
      out.write("                </ul>\n");
      out.write("            </nav>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- CONTENIDO PAGINA -->\n");
      out.write("\n");
      out.write("        <div class=\"wrapper bgded overlay\" style=\"background-image:url('../resources/images/demo/backgrounds/fondo.png');\">\n");
      out.write("            <section id=\"breadcrumb\" class=\"hoc clear\"> \n");
      out.write("                <h1><b>Lista de Tipos de mascotas</b></h1>\n");
      out.write("            </section>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"wrapper row3\" align=\"center\">\n");
      out.write("            <main class=\"hoc container clear\"> \n");
      out.write("                <!-- main body -->\n");
      out.write("                &nbsp;<input type=\"submit\" class=\"btn\" onclick=\"location.href = '../Usuario/crearUsuarioAdmin.jsp'\" value=\"+ nuevo\"/>\n");
      out.write("                <br>\n");
      out.write("                </br>\n");
      out.write("                <div class=\"content\" align=\"center\"> \n");
      out.write("\n");
      out.write("                    <div class=\"scrollable\" align=\"center\">\n");
      out.write("                        <table border=\"1\">\n");
      out.write("                            <tr>\n");
      out.write("                                <th>Rut</th>\n");
      out.write("                                <th>Nombre</th>\n");
      out.write("                                <th>Apellido</th>\n");
      out.write("                                <th>Email</th>\n");
      out.write("                                <th>Telefono</th>\n");
      out.write("                                <th>Perfil</th>\n");
      out.write("                                <th>Acción</th>\n");
      out.write("                            </tr>\n");
      out.write("                            ");
      daoImpl.UsuarioDAOImp usuDAO = null;
      synchronized (_jspx_page_context) {
        usuDAO = (daoImpl.UsuarioDAOImp) _jspx_page_context.getAttribute("usuDAO", PageContext.PAGE_SCOPE);
        if (usuDAO == null){
          usuDAO = new daoImpl.UsuarioDAOImp();
          _jspx_page_context.setAttribute("usuDAO", usuDAO, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("                            ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </main>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <a id=\"backtotop\" href=\"#top\"><i class=\"fa fa-chevron-up\"></i></a>\n");
      out.write("\n");
      out.write("        <div class=\"wrapper row4 bgded overlay\" style=\"background-image:url('../resources/images/demo/backgrounds/fondo.png');\">\n");
      out.write("            <footer id=\"footer\" class=\"hoc clear\"> \n");
      out.write("                <hr class=\"btmspace-50\"></hr>\n");
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
      out.write("\n");
      out.write("            </footer>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usuDAO.listarUsuarios()}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("usu");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                <tr>\n");
          out.write("                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usu.rutUsuario}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usu.nombreUsuario}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usu.apellidoUsuario}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usu.emailUsuario}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usu.telefonoUsuario}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usu.perfilidPerfil}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                    <td>\n");
          out.write("                                        <form id=\"veterinario\" action=\"/Veterinaria/EliminarUsuario\" method=\"POST\">\n");
          out.write("                                            <input type=\"hidden\" name=\"btnEliminar\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usu.rutUsuario}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"> \n");
          out.write("                                            <input name=\"btnEnviar\" type=\"submit\" value=\"Eliminar\">\n");
          out.write("                                        </form> \n");
          out.write("                                    </td>\n");
          out.write("                                </tr>                   \n");
          out.write("                            ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
