/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import daoImpl.EspecialidadDAOImp;
import daoImpl.VeterinarioDAOImp;
import dto.Veterinario;
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

/**
 *
 * @author PC
 */
@WebServlet(name = "CrearVeterinario", urlPatterns = {"/CrearVeterinario"})
public class CrearVeterinario extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date ingreso = formato.parse(request.getParameter("txtFechaIngreso"));
            
            Veterinario dto = new Veterinario();
            
            dto.setNombre(request.getParameter("txtNombre".trim()));
            dto.setApellido(request.getParameter("txtApellido".trim()));
            dto.setEmail(request.getParameter("txtEmail".trim()));
            dto.setDireccion(request.getParameter("txtDireccion".trim()));
            dto.setTelefono(request.getParameter("txtTelefono".trim()));
            dto.setFechaDeIngreso(ingreso);            
            dto.setIdEspecialidad(new EspecialidadDAOImp().EspecialidadToId(request.getParameter("cmbEspecialidad")));
            
             System.err.println("--->"+dto);
            if(new VeterinarioDAOImp().registrar(dto))
            {
                    request.setAttribute("mensaje", "Veterinario Registrada");
            } else 
            {
                request.setAttribute("mensaje", "No se puede Grabar!");
            }
            
            request.getRequestDispatcher("Veterinario/crearVeterinario.jsp").forward(request, response);

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
            Logger.getLogger(CrearVeterinario.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CrearVeterinario.class.getName()).log(Level.SEVERE, null, ex);
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
