/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import daoImp.ContraseñaDaoImp;
import daoImp.PersonaDaoImp;
import daoImp.UsuarioDaoImp;
import dto.PersonaDto;
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
@WebServlet(name = "AgregarCliente", urlPatterns = {"/AgregarCliente"})
public class AgregarCliente extends HttpServlet {

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

            try {
                HttpSession misession = request.getSession();

                //ACCEDEMOS A RECUPERAR LOS DATOS DEL TIPO PERSONA DEL FORMULARIO 
                String rut = request.getParameter("rut").trim();
                String primer_nombre = request.getParameter("primerNombre");
                String segundo_nombre = request.getParameter("segundoNombre");
                String apellido_paterno = request.getParameter("apellidoPaterno");
                String apellido_materno = request.getParameter("apellidoMaterno");
                String d = request.getParameter("fechaNacimiento");

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date f = formatter.parse(d);

                java.sql.Date sql = new java.sql.Date(f.getTime());

                int telefono = Integer.parseInt(request.getParameter("fono"));
                String direccion = request.getParameter("direccion");

                //CREAMOS LA ISNTANCIA DE LA CLASE PERSONA Y "SETEAMOS" SUS PARAMETROS
                PersonaDto persona = new PersonaDto();

                persona.setRut(rut);
                persona.setPrimer_nombre(primer_nombre);
                persona.setSegundo_nombre(segundo_nombre);
                persona.setAp_paterno(apellido_paterno);
                persona.setAp_materno(apellido_materno);
                persona.setFecha_nacimiento(sql);
                persona.setTelefono(telefono);
                persona.setDireccion(direccion);

                //ACCEDEMOS A RECUPERAR LOS DATOS DEL TIPO USUARIO DEL FORMULARIO 
                String email = request.getParameter("email");
                String contraseña = new ContraseñaDaoImp().encriptarContraseña(request.getParameter("pass"));
                boolean estado_usuario = false;
                int cargo = 1;

                //CREAMOS UNA INSTANCIA DE LA CLASE USUARIO Y "SETEAMOS" SUS PARAMETROS
                UsuarioDto u = new UsuarioDto();

                u.setEmail(email);
                u.setContrasena(contraseña);
                u.setEstado(estado_usuario);
                u.setCargo_usuario(cargo);
                u.setRutPersona(persona);

                //HACEMOS LA LLAMADA AL MÉTODO CREAR PERSONA Y CREAR USUARIO Y REDIRIGIMOS SEGÚN LA SITUACIÓN
                if (new PersonaDaoImp().registrar(persona) && new UsuarioDaoImp().registrar(u)) {
                    misession.setAttribute("msg_cuenta_creada", "Cuenta creada exitosamente!!!");
                    response.sendRedirect("ingresar.jsp");
                } else {
                    request.setAttribute("msg", "La cuenta no se ha podido crear =(");
                    request.getRequestDispatcher("home.jsp").forward(request, response);
                }
            } catch (Exception ex) {

                System.out.println(ex.getMessage());
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
