
package daoImpl;

import dao.UsuarioDao;
import dto.Usuario;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import sql.Conexion;

public class UsuarioDAOImp implements UsuarioDao{
    
    public ArrayList<String> listarRut() {
         ArrayList<String> lista = new ArrayList<>();
      try{
          Connection conexion = Conexion.getConexion();
          String query= "SELECT DISTINCT RUT_USUARIO FROM USUARIO ORDER BY RUT_USUARIO ASC";
          PreparedStatement buscar = conexion.prepareStatement(query);
          ResultSet rs=
                  buscar.executeQuery();
          while(rs.next()){
              lista.add(rs.getString("RUT_USUARIO"));
              
          }
          buscar.close();
          conexion.close();
          
      }catch(SQLException w)
      {
          System.out.println("Erro SQL"+w.getMessage());
      }catch(Exception e)
      {
          System.out.println("Error al listar "+e.getMessage());
      }
    return lista;
    }


    @Override
    public ArrayList<Usuario> listarUsuarios() {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM USUARIO ORDER BY RUT_USUARIO ASC";
            PreparedStatement buscar = conexion.prepareStatement(query);
            ResultSet rs = buscar.executeQuery();
            
            while (rs.next()) {
                
                String rut = rs.getString(1);
                String password = rs.getString(2);
                String nombre = rs.getString(3);
                String apellido = rs.getString(4);
                String email = rs.getString(5);
                int telefono = rs.getInt(6);
                int perfil = rs.getInt(7);
                
                Usuario dto = new Usuario(rut, password, nombre, apellido, email, telefono, perfil);
                
                lista.add(dto);
            }
            buscar.close();
            conexion.close();
        } catch (SQLException w) {
            System.out.println("Error SQL al listar " + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar " + e.getMessage());
        }
        return lista;
    }

    @Override
    public boolean registrarPorAdmin(Usuario dto) {
        try{
            Connection conexion=Conexion.getConexion();
            String query="INSERT INTO USUARIO VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ingresar=conexion.prepareStatement(query);
            ingresar.setString(1, dto.getRutUsuario());
            ingresar.setString(2, dto.getPasswordUsuario());
            ingresar.setString(3, dto.getNombreUsuario());
            ingresar.setString(4, dto.getApellidoUsuario());
            ingresar.setString(5, dto.getEmailUsuario());
            ingresar.setInt(6, dto.getTelefonoUsuario());
            ingresar.setInt(7, dto.getPerfilidPerfil());
            ingresar.execute();
            ingresar.close();
            conexion.close();
            return true;
        }catch(SQLException w){
            System.out.println("Error SQL al agregar "+w.getMessage());
        }catch(Exception e){
            System.out.println("Error al agregar "+e.getMessage());
        }
        return false;
    }

    @Override
    public boolean validarRut(String rut) {
        boolean resp = false;
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM USUARIO WHERE RUT_USUARIO=?";
            PreparedStatement valida = conexion.prepareStatement(query);
            valida.setString(1, rut);
            ResultSet rs = valida.executeQuery();

            if (rs.next()) {
                resp = true;
            } else {
                resp = false;
            }

        } catch (SQLException w) {
            System.out.println("Error SQL " + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        return resp;
    }

    @Override
    public boolean modificar(Usuario dto) {
        try {
            Connection conexion = Conexion.getConexion();
            String query = "UPDATE USUARIO SET NOMBRE_USUARIO=?, APELLIDO_USUARIO=?, EMAIL_USUARIO=?,"
                    + " TELEFONO_USUARIO=? WHERE IDVETERINARIO=?";
            PreparedStatement mod = conexion.prepareStatement(query);
            mod.setString(1, dto.getNombreUsuario());
            mod.setString(2, dto.getApellidoUsuario());
            mod.setString(3, dto.getEmailUsuario());
            mod.setInt(4, dto.getTelefonoUsuario());
            mod.setString(5, dto.getRutUsuario());
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

    @Override
    public boolean registrar(Usuario dto) {
        try{
            Connection conexion=Conexion.getConexion();
            String query="INSERT INTO USUARIO(RUT_USUARIO,PASSWORD_USUARIO,NOMBRE_USUARIO,"
                    + "APELLIDO_USUARIO, EMAIL_USUARIO,TELEFONO_USUARIO,PERFIL_IDPERFIL) VALUES(?,?,?,?,?,?,3)";
            
            PreparedStatement ingresar=conexion.prepareStatement(query);
            
            ingresar.setString(1, dto.getRutUsuario());
            ingresar.setString(2, dto.getPasswordUsuario());
            ingresar.setString(3, dto.getNombreUsuario());
            ingresar.setString(4, dto.getApellidoUsuario());
            ingresar.setString(5, dto.getEmailUsuario());
            ingresar.setInt(6, dto.getTelefonoUsuario());
            ingresar.execute();
            ingresar.close();
            conexion.close();
            return true;
        }catch(SQLException w){
            System.out.println("Error SQL al agregar "+w.getMessage());
        }catch(Exception e){
            System.out.println("Error al agregar "+e.getMessage());
        }
        return false;
    }

    @Override
    public boolean eliminar(Usuario dto) {
        try {
            Connection conexion = Conexion.getConexion();
            String query1 = "DELETE FROM USUARIO WHERE RUT_USUARIO=?";
            PreparedStatement del = conexion.prepareStatement(query1);
            del.setString(1, dto.getRutUsuario());
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
    public boolean ver(Usuario dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
