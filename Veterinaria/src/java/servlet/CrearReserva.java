
package servlet;

import daoImpl.ReservaDAOImp;
import daoImpl.VeterinarioDAOImp;
import dto.Reserva;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "CrearReserva", urlPatterns = {"/CrearReserva"})
public class CrearReserva extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = formato.parse(request.getParameter("txtFechaReserva"));
            
            String hora = request.getParameter("cmbHoras".trim());
            int id = new VeterinarioDAOImp().VeterinarioToId(request.getParameter("cmbVeterinario"));
            Reserva dto = new Reserva();
            
            dto.setMotivoReserva(request.getParameter("txtMotivo".trim()));
            dto.setHoraReserva(hora);
            dto.setUsuariorutusuario(request.getParameter("txtRut".trim()));
            dto.setMascotaidMascota(Integer.parseInt(request.getParameter("txtMascota".trim())));
            dto.setFechaReserva(fecha);            
            dto.setVeterinarioidVeterinario(id);
            
            
            
            if (!new ReservaDAOImp().validarReserva(hora, fecha,id)) {
                
                if (new ReservaDAOImp().registrar(dto)) {
                    request.setAttribute("mensaje", "Reserva Agendada Correctamente");
                } else {

                    request.setAttribute("mensaje", "No se puede Registrar...");
                }
                
            } else {
                request.setAttribute("mensaje", "El veterinario ya posee reservas en la Hora seleccionada!");
            }
            
            request.getRequestDispatcher("Reserva/crearReserva.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(CrearReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(CrearReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
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
