package org.apache.jsp.Reserva;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dto.Usuario;

public final class crearReserva_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_out_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_out_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_out_value_nobody.release();
    _jspx_tagPool_c_if_test.release();
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

      out.write('\n');
      daoImpl.VeterinarioDAOImp lista = null;
      synchronized (_jspx_page_context) {
        lista = (daoImpl.VeterinarioDAOImp) _jspx_page_context.getAttribute("lista", PageContext.PAGE_SCOPE);
        if (lista == null){
          lista = new daoImpl.VeterinarioDAOImp();
          _jspx_page_context.setAttribute("lista", lista, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      daoImpl.MascotaDAOImp lista2 = null;
      synchronized (_jspx_page_context) {
        lista2 = (daoImpl.MascotaDAOImp) _jspx_page_context.getAttribute("lista2", PageContext.PAGE_SCOPE);
        if (lista2 == null){
          lista2 = new daoImpl.MascotaDAOImp();
          _jspx_page_context.setAttribute("lista2", lista2, PageContext.PAGE_SCOPE);
        }
      }
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
      out.write("        <title>Reservar Hora Medica</title>\n");
      out.write("        <meta charset=\"utf-8\"/>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\"/>\n");
      out.write("        <link href=\"/Veterinaria/resources/layout/styles/layout.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("    <!-- informacion superior -->\n");
      out.write("    <div class=\"wrapper row0\">\n");
      out.write("        <div id=\"topbar\" class=\"hoc clear\"> \n");
      out.write("            <!-- ################################################################################################ -->\n");
      out.write("            <div class=\"fl_left\">\n");
      out.write("                <ul>\n");
      out.write("                    <li><i class=\"fa fa-map-marker\"></i> calle sin nombre 1123</li>\n");
      out.write("                    <li><i class=\"fa fa-envelope-o\"></i> info@clinicaVet.com</li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- si se inicio sesion -->\n");
      out.write("            ");

                if (session.getAttribute("dto") != null) {
                    Usuario dto = (Usuario) session.getAttribute("dto");
                    if (dto.getPerfilidPerfil() == 1 || dto.getPerfilidPerfil() == 2 || dto.getPerfilidPerfil() == 3) {
            
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"fl_right\">\n");
      out.write("                <ul>\n");
      out.write("                    <li>Bienvenido(a): ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dto.nombreUsuario}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dto.apellidoUsuario}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</li>\n");
      out.write("                    <li>\n");
      out.write("                        <form action=\"/Veterinaria/Logout\" method=\"POST\">\n");
      out.write("                            <input class=\"btn\" type=\"submit\" value=\"Cerrar Sesión\" name=\"btnLogout\" required style=\"padding-left: 8px; padding-right: 8px; padding-bottom: 5px; padding-top: 5px; border-radius: 89px 89px 89px 89px;\"/>\n");
      out.write("                        </form>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- si aun no inicio sesion -->\n");
      out.write("            ");

                }
            } else if (session.getAttribute("dto") == null) {
            
      out.write("    \n");
      out.write("            <div class=\"fl_right\">\n");
      out.write("                <ul>\n");
      out.write("                    <li><a href=\"/Veterinaria/login.jsp\">Ingresar</a></li>\n");
      out.write("                    <li><a href=\"/Veterinaria/Usuario/crearUsuario.jsp\">Registrarse</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!-- MENU PRINCIPAL DEL SITIO-->\n");
      out.write("\n");
      out.write("    <div class=\"wrapper row1\">\n");
      out.write("        <header id=\"header\" class=\"hoc clear\"> \n");
      out.write("            <div id=\"logo\" class=\"fl_left\">\n");
      out.write("                <table style=\"border:hidden;\">\n");
      out.write("                    <tr>\n");
      out.write("                        <td style=\"border:hidden;\"><a href=\"/Veterinaria/index.jsp\"><img src=\"/Veterinaria/resources/images/logo.png\" alt=\"\" width=\"20\" height=\"15\"/></a></td>\n");
      out.write("                        <td style=\"border:hidden;\"><br></br><h1><a href=\"/Veterinaria/index.jsp\"> Veterinaria NN</a></h1><p>Clínica Veterinaria</p></td> \n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"quickinfo\" class=\"fl_right\">\n");
      out.write("                <ul class=\"nospace inline\">\n");
      out.write("\n");
      out.write("                    <table style=\"border:hidden;\">\n");
      out.write("                        <tr>\n");
      out.write("                            ");

                                if (session.getAttribute("dto") != null) {
                                    Usuario dto = (Usuario) session.getAttribute("dto");
                                    if (dto.getPerfilidPerfil() == 2 || dto.getPerfilidPerfil() == 3) {
                            
      out.write("                               \n");
      out.write("                            <td style=\"border:hidden;\"><a class=\"btn\" href=\"/Veterinaria/menuReserva.jsp\" ><b>Reserva de Horas</b></a></td>\n");
      out.write("                            ");

                                    }
                                }
                            
      out.write("\n");
      out.write("                            <td style=\"border:hidden;\"><strong>LLÁMANOS AHORA</strong><br></br>\n");
      out.write("                                +00 (123) 456 7890</td> \n");
      out.write("                            <td style=\"border:hidden;\"><strong>HORARIO ATENCIÓN</strong><br></br>\n");
      out.write("                                21/7</td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- OPCIONES USUARIO -->\n");
      out.write("\n");
      out.write("        </header>\n");
      out.write("        <nav id=\"mainav\" class=\"hoc clear\"> \n");
      out.write("            <ul class=\"clear\">\n");
      out.write("                <li class=\"active\"><a href=\"/Veterinaria/index.jsp\">Página Principal</a></li>\n");
      out.write("                <li><a href=\"#\">Quiénes Somos</a></li>\n");
      out.write("                <li><a href=\"#\">Servicios</a></li>\n");
      out.write("                <li><a href=\"#\">Contacto</a></li>\n");
      out.write("                <li><a href=\"#\"> &nbsp; </a></li>\n");
      out.write("                <li><a href=\"#\"> &nbsp; </a></li>\n");
      out.write("                <li><a href=\"#\"> &nbsp; </a></li>\n");
      out.write("                <li><a href=\"#\"> &nbsp; </a></li>                    \n");
      out.write("\n");
      out.write("                ");

                    if (session.getAttribute("dto") != null) {
                        Usuario dto = (Usuario) session.getAttribute("dto");
                        if (dto.getPerfilidPerfil() == 3) {

                
      out.write("\n");
      out.write("                <li><a class=\"drop\" href=\"#\">Cliente</a>\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"/Veterinaria/Usuario/PerfilUsuario.jsp\">Mi Perfil</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("                ");
                        } else if (dto.getPerfilidPerfil() == 2) {
                
      out.write("\n");
      out.write("                <li><a class=\"drop\" href=\"#\">Veterinario</a>\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"/Veterinaria/Usuario/PerfilUsuario.jsp\">Mi Perfil</a></li>\n");
      out.write("                        <li><a href=\"/Veterinaria/Veterinario/listaVeterinario.jsp\">Adm. Veterinarios</a></li>\n");
      out.write("                        <li><a href=\"/Veterinaria/Mascota/listaMascotas.jsp\">Adm. Mascotas</a></li>\n");
      out.write("                        <li><a href=\"/Veterinaria/Raza/listaRaza.jsp\">Adm. Razas</a></li>\n");
      out.write("                        <li><a href=\"/Veterinaria/TipoMascota/listaTipoMascota.jsp\">Adm. Tipos Mascotas</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("                ");

                } else if (dto.getPerfilidPerfil() == 1) {
                
      out.write("\n");
      out.write("                <li><a class=\"drop\" href=\"#\">Administrador</a>\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"/Veterinaria/Usuario/PerfilUsuario.jsp\">Mi Perfil</a></li>\n");
      out.write("                        <li><a href=\"/Veterinaria/Usuario/listaUsuarios.jsp\">Adm. Usuarios</a></li>\n");
      out.write("                        <li><a href=\"/Veterinaria/Veterinario/listaVeterinario.jsp\">Adm. Veterinarios</a></li>\n");
      out.write("                        <li><a href=\"/Veterinaria/Especialidad/listaEspecialidad.jsp\">Adm. Especialidades</a></li>\n");
      out.write("                        <li><a href=\"/Veterinaria/Estado/listaEstado.jsp\">Adm. Estados</a></li>\n");
      out.write("                        <li><a href=\"/Veterinaria/Perfil/listaPerfil.jsp\">Adm. Perfiles</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>                     \n");
      out.write("                ");

                        }
                    }
                
      out.write("                    \n");
      out.write("\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- CONTENIDO PAGINA -->\n");
      out.write("\n");
      out.write("    <div class=\"wrapper bgded overlay\" style=\"background-image:url('/Veterinaria/resources/images/demo/backgrounds/fondo.png');\">\n");
      out.write("        <section id=\"breadcrumb\" class=\"hoc clear\"> \n");
      out.write("            <h1><b>Nueva Reserva Médica</b></h1>\n");
      out.write("        </section>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"wrapper row3\" align=\"center\">\n");
      out.write("        <main class=\"hoc container clear\"> \n");
      out.write("\n");
      out.write("            <div class=\"content\" align=\"center\"> \n");
      out.write("\n");
      out.write("                <div class=\"scrollable\" align=\"center\">\n");
      out.write("                    <form action=\"/Veterinaria/CrearReserva\" method=\"POST\">\n");
      out.write("                        <table border=\"0\" align=\"center\">\n");
      out.write("                            <tbody align=\"center\">\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Motivo</td>\n");
      out.write("                                <td><input style=\"width: 300px; height: 30px; text-align: center;\" type=\"text\" name=\"txtMotivo\" value=\"\" placeholder=\"Ingrese El motivo\" required/></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Fecha</td>\n");
      out.write("                                <td><input style=\"width: 300px; height: 30px; text-align: center;\"  type=\"date\" name=\"txtFechaReserva\"  size=\"90\" value=\"\" placeholder=\"Ingrese Fecha\" required/></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr >\n");
      out.write("                                <td>Hora</td>\n");
      out.write("                                <td><select style=\"width: 300px; height: 30px; text-align-last:center;\"  name=\"cmbHoras\">\n");
      out.write("                                        <option>00:00</option>\n");
      out.write("                                        <option>00:30</option>\n");
      out.write("                                        <option>01:00</option>\n");
      out.write("                                        <option>01:30</option>\n");
      out.write("                                        <option>02:00</option>\n");
      out.write("                                        <option>02:30</option>\n");
      out.write("                                        <option>03:00</option>\n");
      out.write("                                        <option>03:30</option>\n");
      out.write("                                        <option>04:00</option>\n");
      out.write("                                        <option>04:30</option>\n");
      out.write("                                        <option>05:00</option>\n");
      out.write("                                        <option>05:30</option>\n");
      out.write("                                        <option>06:00</option>\n");
      out.write("                                        <option>06:30</option>\n");
      out.write("                                        <option>07:00</option>\n");
      out.write("                                        <option>07:30</option>\n");
      out.write("                                        <option>08:00</option>\n");
      out.write("                                        <option>09:30</option>\n");
      out.write("                                        <option>10:00</option>\n");
      out.write("                                        <option>10:30</option>\n");
      out.write("                                        <option>11:00</option>\n");
      out.write("                                        <option>11:30</option>\n");
      out.write("                                        <option>12:00</option>\n");
      out.write("                                        <option>12:30</option>\n");
      out.write("                                        <option>13:00</option>\n");
      out.write("                                        <option>13:30</option>\n");
      out.write("                                        <option>14:00</option>\n");
      out.write("                                        <option>14:30</option>\n");
      out.write("                                        <option>15:00</option>\n");
      out.write("                                        <option>15:30</option>\n");
      out.write("                                        <option>16:00</option>\n");
      out.write("                                        <option>16:30</option>\n");
      out.write("                                        <option>17:00</option>\n");
      out.write("                                        <option>17:30</option>\n");
      out.write("                                        <option>18:00</option>\n");
      out.write("                                        <option>19:30</option>\n");
      out.write("                                        <option>20:00</option>\n");
      out.write("                                        <option>20:30</option>\n");
      out.write("                                        <option>21:00</option>\n");
      out.write("                                        <option>21:30</option>\n");
      out.write("                                        <option>22:00</option>\n");
      out.write("                                        <option>22:30</option>\n");
      out.write("                                        <option>23:00</option>\n");
      out.write("                                        <option>23:30</option>\n");
      out.write("                                    </select></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Veterinario</td>\n");
      out.write("                                <td><select style=\"width: 300px; height: 30px; text-align-last:center;\" name=\"cmbVeterinario\" required>\n");
      out.write("                                        ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                    </select>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Rut Dueño Mascota</td>\n");
      out.write("                                <td><input style=\"width: 300px; height: 30px; text-align: center;\" type=\"text\" name=\"txtRut\" value=\"\" placeholder=\"Ingrese Su rut\" required/></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Identificador Mascota</td>\n");
      out.write("                                <td><input type=\"text\" style=\"width: 300px; height: 30px; text-align: center;\" name=\"txtMascota\" value=\"\" placeholder=\"Ingrese El codigo de la mascota\" required/></td>\n");
      out.write("                            </tr>\n");
      out.write("                            </tbody>\n");
      out.write("                        </table>\n");
      out.write("                        <br>\n");
      out.write("                        <br>\n");
      out.write("                        <input type=\"submit\" style=\"width: 300px; text-align: center;\" class=\"btn\" value=\"Reservar\" name=\"btnEnviar\"\"/>\n");
      out.write("\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </main>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <a id=\"backtotop\" href=\"#top\"><i class=\"fa fa-chevron-up\"></i></a>\n");
      out.write("\n");
      out.write("    <div class=\"wrapper row4 bgded overlay\" style=\"background-image:url('/Veterinaria/resources/images/demo/backgrounds/fondo.png');\">\n");
      out.write("        <footer id=\"footer\" class=\"hoc clear\"> \n");
      out.write("            <hr class=\"btmspace-50\"></hr>\n");
      out.write("            <div class=\"group\">\n");
      out.write("                <div class=\"one_half first\">\n");
      out.write("                    <h6 class=\"heading\">Curabitur varius cursus</h6>\n");
      out.write("                    <ul class=\"nospace btmspace-30 linklist contact\">\n");
      out.write("                        <li><i class=\"fa fa-map-marker\"></i>\n");
      out.write("                            <address>\n");
      out.write("                                Street Name &amp; Number, Town, Postcode/Zip\n");
      out.write("                            </address>\n");
      out.write("                        </li>\n");
      out.write("                        <li><i class=\"fa fa-phone\"></i> +00 (123) 456 7890</li>\n");
      out.write("                        <li><i class=\"fa fa-fax\"></i> +00 (123) 456 7890</li>\n");
      out.write("                        <li><i class=\"fa fa-envelope-o\"></i> info@domain.com</li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"one_half\">\n");
      out.write("                    <h6 class=\"heading\">Magna mattis nibh ut</h6>\n");
      out.write("                    <figure>\n");
      out.write("\n");
      out.write("                        <figcaption>\n");
      out.write("                            <h6 class=\"nospace font-x1\"><a href=\"#\">Proin commodo semper</a></h6>\n");
      out.write("                            <time class=\"font-xs block btmspace-10\" datetime=\"2045-04-06\">Friday, 6<sup>th</sup> April 2045</time>\n");
      out.write("                        </figcaption>\n");
      out.write("                    </figure>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </footer>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("</body>\n");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensaje!=null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("        <script>\n");
        out.write("            alert(\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensaje}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\");\n");
        out.write("        </script>\n");
        out.write("    ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("vet");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${lista.listarNombreVeterinaio()}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                            <b><option>");
          if (_jspx_meth_c_out_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</option></b>\n");
          out.write("                                        ");
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

  private boolean _jspx_meth_c_out_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_0.setPageContext(_jspx_page_context);
    _jspx_th_c_out_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${vet}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_0 = _jspx_th_c_out_0.doStartTag();
    if (_jspx_th_c_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
    return false;
  }
}
