/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dto.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sql.Conexion;

/**
 *
 * @author PC
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String rut = request.getParameter("txtRut".trim());
            String pass = request.getParameter("txtPass".trim());

            try {
                Connection conexion = Conexion.getConexion();
                String query = "SELECT * FROM USUARIO WHERE rut_usuario='" + rut + "' and password_usuario='" + pass + "'";
                PreparedStatement valida = conexion.prepareStatement(query);
                ResultSet rs = valida.executeQuery(query);

                if (rs.next()) {
                    Usuario dto = new Usuario();

                    dto.setRutUsuario(rs.getString("RUT_USUARIO"));
                    dto.setPasswordUsuario(rs.getString("PASSWORD_USUARIO"));
                    dto.setNombreUsuario(rs.getString("NOMBRE_USUARIO"));
                    dto.setApellidoUsuario(rs.getString("APELLIDO_USUARIO"));
                    dto.setEmailUsuario(rs.getString("EMAIL_USUARIO"));
                    dto.setTelefonoUsuario(rs.getInt("TELEFONO_USUARIO"));
                    dto.setPerfilidPerfil(rs.getInt("PERFIL_IDPERFIL"));

                    
                    
                    HttpSession session = request.getSession();
                    session.setAttribute("dto", dto);
                    session.setAttribute("tipo_usuario", dto.getPerfilidPerfil());
                    session.setAttribute("rut", dto.getRutUsuario());
                    
                    request.setAttribute("mensaje", "Ingreso exitoso!");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensaje", "rut o Clave Incorrectos");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }

            } catch (SQLException w) {
                request.setAttribute("mensaje", "Error SQL " + w.getMessage());
            } catch (Exception e) {
                request.setAttribute("mensaje", "Error" + e.getMessage());
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
