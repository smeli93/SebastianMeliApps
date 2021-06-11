
package daoImpl;

import dao.EstadoDao;
import dto.Estado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sql.Conexion;


public class EstadoDAOImp implements EstadoDao{
    
    public ArrayList<String> listarNombreEstado() {
         ArrayList<String> lista = new ArrayList<>();
      try{
          Connection conexion = Conexion.getConexion();
          String query= "SELECT DISTINCT DESCRIPCIONESTADO FROM ESTADO ORDER BY DESCRIPCIONESTADO ASC";
          PreparedStatement buscar = conexion.prepareStatement(query);
          ResultSet rs=
                  buscar.executeQuery();
          while(rs.next()){
              lista.add(rs.getString("DESCRIPCIONESTADO"));
              
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
    public ArrayList<Estado> listarEstados() {
        ArrayList<Estado> lista = new ArrayList<Estado>();
        
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM ESTADO ORDER BY IDESTADO ASC";
            PreparedStatement buscar = conexion.prepareStatement(query);
            ResultSet rs = buscar.executeQuery();
            
            while (rs.next()) {
                
                int id = rs.getInt(1);
                String descripcion = rs.getString(2);
                
                Estado dto = new Estado(id, descripcion);               
                
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
    public ArrayList<Estado> buscarPorId(int id) {
        ArrayList<Estado> lista1 = new ArrayList<Estado>();
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM ESTADO WHERE IDESTADO=?";
            PreparedStatement buscar = conexion.prepareStatement(query);
            buscar.setInt(1, id);
            
            ResultSet rs = buscar.executeQuery();
            
            while (rs.next()) {
                Estado dto = new Estado();
                dto.setIdEstado(rs.getInt("IDESTADO"));
                dto.setDescripcionEstado(rs.getString("DESCRIPCIONESTADO"));
                lista1.add(dto);
            }
            buscar.close();
            conexion.close();
        } catch (SQLException w) {
            System.out.println("Error SQL al buscar" + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error al buscar" + e.getMessage());
        }
        return lista1;
    }

    @Override
    public int EstadoToId(String estado) {
        int id=0;
        
        try{
            Connection conexion=Conexion.getConexion();
            String query="SELECT IDESTADO FROM ESTADO WHERE DESCRIPCIONESTADO=?";
            PreparedStatement buscar=conexion.prepareStatement(query);
            buscar.setString(1, estado);
            ResultSet rs = buscar.executeQuery();
            if(rs.next()){
                id=rs.getInt("IDESTADO");
            }
            buscar.close();
            conexion.close();
        }catch(SQLException w){
            System.out.println("Error SQL al buscar "+w.getMessage());
        }catch(Exception e){
            System.out.println("Error al buscar "+e.getMessage());
        }
        return id;
    }

    @Override
    public String idToEstado(int id) {
        String nombre = "";
        try{
            Connection conexion=Conexion.getConexion();
            String query="SELECT DESCRIPCIONESTADO FROM ESTADO WHERE IDESTADO=?";
            PreparedStatement buscar=conexion.prepareStatement(query);
            buscar.setInt(1, id);
            ResultSet rs = buscar.executeQuery();
            if(rs.next()){
                nombre=rs.getString("DESCRIPCIONESTADO");
            }
            buscar.close();
            conexion.close();
        }catch(SQLException w){
            System.out.println("Error SQL al buscar "+w.getMessage());
        }catch(Exception e){
            System.out.println("Error al buscar "+e.getMessage());
        }
        return nombre;
    }

    @Override
    public boolean modificar(Estado dto) {
        try {
            Connection conexion = Conexion.getConexion();
            String query = "UPDATE ESTADO SET IDESTADO=?,DESCRIPCIONESTADO=? WHERE IDESTADO=?";
            PreparedStatement mod = conexion.prepareStatement(query);
            mod.setInt(1, dto.getIdEstado());
            mod.setString(2, dto.getDescripcionEstado());
            mod.setInt(3, dto.getIdEstado());
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
    public boolean registrar(Estado dto) {
        try {

            Connection conexion = Conexion.getConexion();
            String query = "INSERT INTO ESTADO (descripcionEstado) VALUES (?)";
            PreparedStatement registra = conexion.prepareStatement(query);
            registra.setString(1, dto.getDescripcionEstado());
            registra.execute();
            registra.close();
            conexion.close();

            return true;

        } catch (SQLException sq) {
            System.out.println("ERROR SQL: " + sq.getMessage());
        } catch (Exception ex) {
            System.out.println("ERROR OPERACION: " + ex.getMessage());
        }

        return false;
    }

    @Override
    public boolean eliminar(Estado dto) {
        try {
            Connection conexion = Conexion.getConexion();
            String query1 = "DELETE FROM ESTADO WHERE IDESTADO=?";
            PreparedStatement del = conexion.prepareStatement(query1);
            del.setInt(1, dto.getIdEstado());
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
    public boolean ver(Estado dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
