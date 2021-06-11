
package servlet;

import daoImpl.PerfilDAOImp;
import daoImpl.UsuarioDAOImp;
import dto.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "CrearUsuario", urlPatterns = {"/CrearUsuario"})
public class CrearUsuario extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           Usuario dto = new Usuario();

            dto.setRutUsuario(request.getParameter("txtRut".trim()));
            dto.setPasswordUsuario(request.getParameter("password").trim());
            dto.setNombreUsuario(request.getParameter("txtNombre".trim()));
            dto.setApellidoUsuario(request.getParameter("txtApellido".trim()));           
            dto.setEmailUsuario(request.getParameter("txtEmail".trim()));            
            dto.setTelefonoUsuario(Integer.parseInt(request.getParameter("txtTelefono".trim())));



            if (!new UsuarioDAOImp().validarRut(dto.getRutUsuario())) {
                
                if (new UsuarioDAOImp().registrar(dto)) {
                    request.setAttribute("mensaje", "Usuario Registrado");
                } else {
                    request.setAttribute("mensaje", "No se puede Registrar...");
                }
                
            } else {
                request.setAttribute("mensaje", "El rut ya se encuentra registrado..");
            }
            
            request.getRequestDispatcher("Usuario/crearUsuario.jsp").forward(request, response);
            
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
