package daoImp;

import dao.UsuarioDao;
import dto.PersonaDto;
import dto.UsuarioDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sql.Conexion;

public class UsuarioDaoImp implements UsuarioDao {

    // Metodo Iniciar Sesion
    @Override
    public boolean Login(String email, String password) {
        boolean respuesta = false;
        try {

            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM USUARIO WHERE EMAIL_USUARIO=? AND CONTRASENA=? ";
            PreparedStatement mod = conexion.prepareStatement(query);
            mod.setString(1, email);
            mod.setString(2, password);
            ResultSet rs = mod.executeQuery();

            if (rs.next()) {
                respuesta = true;
            } else {
                respuesta = false;
            }

            conexion.close();

        } catch (SQLException w) {
            System.out.println("ERROR SQL AL MODIFICAR " + w.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR A MODIFICAR " + e.getMessage());
        }
        return respuesta;
    }

    // Metodo Validar Email
    @Override
    public boolean validarEmail(String email) {
        boolean resp = false;
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM USUARIO WHERE email=?";
            PreparedStatement valida = conexion.prepareStatement(query);
            valida.setString(1, email);
            ResultSet rs = valida.executeQuery();

            if (rs.next()) {
                resp = true;
            } else {
                resp = false;
            }

        } catch (SQLException w) {
            System.out.println("Error SQL al validar email" + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error al validar email" + e.getMessage());
        }
        return resp;
    }

    // Metodo Modificar Usuario
    @Override
    public boolean modificar(UsuarioDto dto) {
        try {
            Connection conexion = Conexion.getConexion();
            String query = "UPDATE USUARIO SET EMAIL_USUARIO=?, CONTRASENA=? "
                    + " WHERE PERSONA_RUT_PERSONA=?";
            PreparedStatement mod = conexion.prepareStatement(query);
            mod.setString(1, dto.getEmail());
            mod.setString(2, dto.getContrasena());
            mod.setString(3, dto.getRutPersona().getRut());
            mod.execute();
            mod.close();
            conexion.close();
            return true;
        } catch (SQLException w) {
            System.out.println("ERROR SQL AL MODIFICAR " + w.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR A MODIFICAR " + e.getMessage());
        }
        return false;
    }

    // Metodo Insertar Usuario
    @Override
    public boolean registrar(UsuarioDto dto) {
        try {
            Connection conexion = Conexion.getConexion();
            String query = "INSERT INTO USUARIO(EMAIL_USUARIO,CONTRASENA,ACTIVADA,"
                    + "CARGO_USUARIO, PERSONA_RUT_PERSONA) VALUES(?,?,?,?,?)";

            PreparedStatement ingresar = conexion.prepareStatement(query);

            ingresar.setString(1, dto.getEmail());
            ingresar.setString(2, dto.getContrasena());
            ingresar.setBoolean(3, dto.isEstado());
            ingresar.setInt(4, dto.getCargo_usuario());
            ingresar.setString(5, dto.getRutPersona().getRut());
            ingresar.execute();
            ingresar.close();
            conexion.close();
            return true;
        } catch (SQLException w) {
            System.out.println("Error SQL al agregar " + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error al agregar " + e.getMessage());
        }
        return false;
    }

    // Metodo Eliminar Usuario
    @Override
    public boolean eliminar(UsuarioDto dto) {
        try {
            Connection conexion = Conexion.getConexion();
            String query1 = "DELETE FROM USUARIO WHERE ID_USUARIO=?";
            PreparedStatement del = conexion.prepareStatement(query1);
            del.setInt(1, dto.getId_usuario());
            del.execute();
            del.close();
            conexion.close();

            return true;

        } catch (SQLException w) {
            System.out.println("Error SQL al eliminar " + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error al eliminar " + e.getMessage());
        }
        return false;
    }

    @Override
    public ArrayList<UsuarioDto> buscarPorEmail(String email) {
        ArrayList<UsuarioDto> lista1 = new ArrayList<UsuarioDto>();
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM USUARIO WHERE EMAIL_USUARIO=?";
            PreparedStatement buscar = conexion.prepareStatement(query);
            buscar.setString(1, email);

            ResultSet rs = buscar.executeQuery();

            while (rs.next()) {

                UsuarioDto dto = new UsuarioDto();
                dto.setId_usuario(rs.getInt(""));
                dto.setEmail(rs.getString(""));
                dto.setContrasena(rs.getString(""));
                dto.setEstado(rs.getBoolean(""));
                dto.getRutPersona().setRut(rs.getString(""));
                dto.getRutPersona().setPrimer_nombre(rs.getString(""));
                dto.getRutPersona().setSegundo_nombre(rs.getString(""));
                dto.getRutPersona().setAp_paterno(rs.getString(""));
                dto.getRutPersona().setAp_materno(rs.getString(""));
                dto.getRutPersona().setFecha_nacimiento(rs.getDate(""));
                dto.getRutPersona().setTelefono(rs.getInt(""));
                dto.getRutPersona().setDireccion(rs.getString(""));
                lista1.add(dto);

            }
            buscar.close();
            conexion.close();
        } catch (SQLException w) {
            System.out.println("Error SQL al buscar tipo Usuarios " + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error al buscar Tipode usuarios " + e.getMessage());
        }
        return lista1;
    }

    @Override
    public UsuarioDto retornarUsuario(String email, String password) {
        ArrayList<UsuarioDto> lista = new ArrayList<UsuarioDto>();
        UsuarioDto usuario = new UsuarioDto();
        PersonaDto persona = new PersonaDto();
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM USUARIO inner JOIN persona on usuario.persona_rut_persona = persona.rut_persona WHERE EMAIL_USUARIO=? AND CONTRASENA=?";
            PreparedStatement buscar = conexion.prepareStatement(query);
            buscar.setString(1, email);
            buscar.setString(2, password);
            ResultSet rs = buscar.executeQuery();

            while (rs.next()) {

                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setEmail(rs.getString("email_usuario"));
                usuario.setContrasena(rs.getString("contrasena"));
                usuario.setEstado(rs.getBoolean("activada"));
                usuario.setCargo_usuario(rs.getInt("cargo_usuario"));
                persona.setRut(rs.getString("persona_rut_persona"));
                persona.setPrimer_nombre(rs.getString("primer_nombre"));
                persona.setSegundo_nombre(rs.getString("segundo_nombre"));
                persona.setAp_paterno(rs.getString("apellido_paterno"));
                persona.setAp_materno(rs.getString("apellido_materno"));
                persona.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                persona.setTelefono(rs.getInt("telefono"));
                persona.setDireccion(rs.getString("direccion"));
                usuario.setRutPersona(persona);

            }
            buscar.close();
            conexion.close();
        } catch (SQLException w) {
            System.out.println("Error SQL al retornar usuario para login " + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error al retornar usuario para login" + e.getMessage());
        }
        return usuario;
    }

    @Override
    public ArrayList<UsuarioDto> buscarPorRut(String rut) {
        ArrayList<UsuarioDto> lista = new ArrayList<UsuarioDto>();
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM USUARIO JOIN persona on persona_rut_persona = rut_persona "
                    + "WHERE Rut_Persona=?";
            PreparedStatement buscar = conexion.prepareStatement(query);
            buscar.setString(1, rut);

            ResultSet rs = buscar.executeQuery();

            while (rs.next()) {

                UsuarioDto usuario = new UsuarioDto();
                PersonaDto persona = new PersonaDto();

                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setEmail(rs.getString("email_usuario"));
                usuario.setContrasena(rs.getString("contrasena"));
                usuario.setEstado(rs.getBoolean("activada"));
                usuario.setCargo_usuario(rs.getInt("cargo_usuario"));
                usuario.setRutPersona(persona);
                persona.setRut(rs.getString("Rut_persona"));
                persona.setPrimer_nombre(rs.getString("primer_nombre"));
                persona.setSegundo_nombre(rs.getString("segundo_nombre"));
                persona.setAp_paterno(rs.getString("apellido_paterno"));
                persona.setAp_materno(rs.getString("apellido_materno"));
                persona.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                persona.setTelefono(rs.getInt("telefono"));
                persona.setDireccion(rs.getString("direccion"));

                lista.add(usuario);
            }
            buscar.close();
            conexion.close();
        } catch (SQLException w) {
            System.out.println("Error SQL al buscar tipo Usuarios " + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error al buscar Tipode usuarios " + e.getMessage());
        }
        return lista;
    }

}
