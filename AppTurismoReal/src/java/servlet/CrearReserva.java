/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import daoImp.DetalleServicioExtraDaoImp;
import daoImp.MetodoPagoDaoImp;
import daoImp.ReservaDaoImp;
import daoImp.ServicioExtraDaoImp;
import dto.DepartamentoDto;
import dto.DetalleServicioExtraDto;
import dto.MetodoPagoDto;
import dto.PersonaDto;
import dto.ReservaDto;
import dto.ServicioExtraDto;
import dto.UsuarioDto;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Germán
 */
@WebServlet(name = "CrearReserva", urlPatterns = {"/CrearReserva"})
public class CrearReserva extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            //CREAMOS TODAS LAS INSTANCIAS DE LAS CLASES Y VARIABLES NECESARIAS PARA PODER AGREGAR UNA NUEVA RESERVA
            int id_reserva=0;
            HttpSession misession = request.getSession();
            DetalleServicioExtraDaoImp detalleDao = new DetalleServicioExtraDaoImp();
            DetalleServicioExtraDto detalleDto = new DetalleServicioExtraDto();
            MetodoPagoDaoImp metodoPagoDao = new MetodoPagoDaoImp();
            UsuarioDto usuarioDto = (UsuarioDto) misession.getAttribute("dto");
            PersonaDto personaDto = new PersonaDto();
            ReservaDto reservaDto = new ReservaDto();
            MetodoPagoDto metodopagodto = new MetodoPagoDto();
            DepartamentoDto departamentoDto = new DepartamentoDto();
            ReservaDaoImp reservaDao = new ReservaDaoImp();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            //PREGUNTAMOS SI HAY UN USUARIO EN LA SESSION, EN CASO CONTRARIO, LO REDIGIRIMOS A LA PAGINA PARA INGRESAR       
            if (usuarioDto != null) {

                try {
                    //ACCEDEMOS A RECUPERAR LOS DATOS DEL TIPO RESERVA DEL FORMULARIO 
                    int cantDias = Integer.parseInt(request.getParameter("txtDias"));
                    String llegada = request.getParameter("txtLlegada");
                    String salida = request.getParameter("txtSalida");
                    Date inicio = formatter.parse(llegada);
                    Date termino = formatter.parse(salida);
                    java.sql.Date inicio_reserva = new java.sql.Date(inicio.getTime());
                    java.sql.Date termino_reserva = new java.sql.Date(termino.getTime());
                    int garantia = Integer.parseInt(request.getParameter("txtGarantia"));
                    String[] servicios = request.getParameterValues("chkServicio");//GUARDAMOS EN UN ARRAY EL ID DE LOS CHECKBOX SELECCIONADOS

                    metodopagodto.setId_metodo_pago(metodoPagoDao.MetodoPagoToId(request.getParameter("cmbMetodoPago")));
                    personaDto.setRut(usuarioDto.getRutPersona().getRut());
                    departamentoDto.setId_depto(Integer.parseInt(request.getParameter("txtIdDepto")));

                    //CREAMOS LA ISNTANCIA DE LA CLASE RESERVA Y "SETEAMOS" SUS PARAMETROS.
                    reservaDto.setCant_dias(cantDias);
                    reservaDto.setInicio_reserva(inicio_reserva);
                    reservaDto.setTermino_reserva(termino_reserva);
                    reservaDto.setPago_garantia(garantia);
                    reservaDto.setMetodoPago(metodopagodto);
                    reservaDto.setPersona(personaDto);
                    reservaDto.setDepartamento(departamentoDto);

                    id_reserva = reservaDao.agregarReservaRetornandoId(reservaDto);//AGREGAMOS LA RESERVA Y RETORNAMOS EL ID DE ESTA MISMA AUTOMATICAMENTE.

                    reservaDto.setId_reserva(id_reserva);//LE ASIGNAMOS EL ID DE LA RESERVA A LA ISTANCIA DE LA CLASE.

                    //VERIFICAMOS SI HAY SERVICIOS SELECCIONADOS.
                    if (servicios != null) {

                        //RECORREMOS EL ARRAY CREADO ANTERIORMENTE Y LO RECORREMOS.
                        for (String servicio : servicios) {

                            //CREAMOS LA INSTANCIA DE LA CLASE SERVICIO EXTRA Y "SETEAMOS" EL PARAMETRO ID DEL SERVICIO LOS CUALES VIENEN EN EL ARREGLO.
                            ServicioExtraDto servicioDto = new ServicioExtraDto();
                            servicioDto.setId_servicioExtra(Integer.parseInt(servicio));

                            //"SETEAMOS" LOS PARAMETROS DE LA INSTANCIA Y FINALMENTE REGISTRAMOS LOS DETALLES SERVICIOS ASIGNANDOSELOS A UNA RESERVA.
                            detalleDto.setServicio_extra(servicioDto);
                            detalleDto.setReserva(reservaDto);
                            detalleDao.registrar(detalleDto);
                        }

                    }

                    //UNA VEZ QUE TENEMOS LOS DETALLES SERVICIOS ASIGNADOS A UNA RESERVA EN LA BD, PROCEDEMOS A SUMARLOS Y REGISTRAR SU TOTAL EN LA TABLA RESERVA.
                    detalleDao.modificarTotalServicios(id_reserva);

                    //"SETEAMOS" LOS ATRIBUTOS LOS CUALES ENVIAREMOS AL JSP A TRAVES DE LA RESPUESTA QUE ENVIA EL SERVLET.
                    misession.setAttribute("id", departamentoDto.getId_depto());
                    misession.setAttribute("cantDias", cantDias);
                    misession.setAttribute("fechaInicio", llegada);
                    misession.setAttribute("fechaSalida", salida);

                    misession.setAttribute("msg_exito", "!Reserva creada exitosamente!");

                    response.sendRedirect("reservaRealizada.jsp");

                } catch (Exception ex) {

                    System.out.println(ex.getMessage());
                }
            } else {

                misession.setAttribute("msg_iniciar_sesion", "Debe iniciar sesión para agendar una reserva");
                response.sendRedirect("ingresar.jsp");

            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
