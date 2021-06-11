
package servlet;

import daoImpl.MascotaDAOImp;
import daoImpl.RazaDAOImp;
import daoImpl.TipoMascotaDAOImp;
import dto.Mascota;
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


@WebServlet(name = "CrearMascota", urlPatterns = {"/CrearMascota"})
public class CrearMascota extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = formato.parse(request.getParameter("txtFechaNacimiento"));
            
            Mascota dto = new Mascota();
            
            dto.setNombreMascota(request.getParameter("txtNombre".trim()));
            dto.setFechaNacimiento(fecha);
            dto.setUsuariorutusuario(request.getParameter("txtDueno".trim()));    
            dto.setTipoMascotaidTipoMascota(new TipoMascotaDAOImp().TipoMascotaToId(request.getParameter("cmbTipo")));
            dto.setRazaidRaza(new RazaDAOImp().RazaToId(request.getParameter("cmbRaza")));           
            
            if(new MascotaDAOImp().registrar(dto))
            {
                    request.setAttribute("mensaje", "Mascota Registrada");
                    request.getRequestDispatcher("Mascota/crearMascota.jsp").forward(request, response);

            } else 
            {
                request.setAttribute("mensaje", "No se puede Grabar!");
                request.getRequestDispatcher("Mascota/crearMascota.jsp").forward(request, response);
            }
            
            System.out.println("--->"+dto);
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
            Logger.getLogger(CrearMascota.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CrearMascota.class.getName()).log(Level.SEVERE, null, ex);
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
