package servlet;

import daoImp.ContraseñaDaoImp;
import daoImp.PersonaDaoImp;
import daoImp.UsuarioDaoImp;
import dto.UsuarioDto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession misession = request.getSession();

        try (PrintWriter out = response.getWriter()) {

            UsuarioDaoImp dao = new UsuarioDaoImp();

            String email = request.getParameter("email".trim());
            String pass = new ContraseñaDaoImp().encriptarContraseña(request.getParameter("pass"));

            UsuarioDto usuario = dao.retornarUsuario(email, pass);

            if (usuario.getRutPersona() != null && usuario.isEstado()) {

                misession.setAttribute("dto", usuario);
                misession.setAttribute("msg_bienvenida", "Bienvenido a Turismo Real");      
                response.sendRedirect("home.jsp");

            } else {
                misession.setAttribute("msg_error", "Usuario o contraseña incorrecta");
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
