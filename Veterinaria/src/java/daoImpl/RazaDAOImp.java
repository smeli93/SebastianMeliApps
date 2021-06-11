
package daoImpl;

import dao.RazaDao;
import dto.Raza;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sql.Conexion;


public class RazaDAOImp implements RazaDao{
    
    public ArrayList<String> listarNombreRaza() {
         ArrayList<String> lista = new ArrayList<>();
      try{
          Connection conexion = Conexion.getConexion();
          String query= "SELECT DISTINCT DESCRIPCIONRAZA FROM RAZA ORDER BY DESCRIPCIONRAZA ASC";
          PreparedStatement buscar = conexion.prepareStatement(query);
          ResultSet rs=
                  buscar.executeQuery();
          while(rs.next()){
              lista.add(rs.getString("DESCRIPCIONRAZA"));
              
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
    public ArrayList<Raza> listarRaza() {
        ArrayList<Raza> lista = new ArrayList<Raza>();
        
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM RAZA ORDER BY IDRAZA ASC";
            PreparedStatement buscar = conexion.prepareStatement(query);
            ResultSet rs = buscar.executeQuery();
            
            while (rs.next()) {
                
                int id = rs.getInt(1);
                String descripcion = rs.getString(2);
                
                Raza dto = new Raza(id, descripcion);               
                
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
    public ArrayList<Raza> buscarPorId(int id) {
        ArrayList<Raza> lista1 = new ArrayList<Raza>();
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM RAZA WHERE IDRAZA=?";
            PreparedStatement buscar = conexion.prepareStatement(query);
            buscar.setInt(1, id);
            
            ResultSet rs = buscar.executeQuery();
            
            while (rs.next()) {
                Raza dto = new Raza();
                dto.setIdRaza(rs.getInt("IDRAZA"));
                dto.setDescripcionRaza(rs.getString("DESCRIPCIONRAZA"));
                lista1.add(dto);
            }
            buscar.close();
            conexion.close();
        } catch (SQLException w) {
            System.out.println("Error SQL al buscar " + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error al buscar " + e.getMessage());
        }
        return lista1;
    }

    @Override
    public int RazaToId(String raza) {
        int id=0;
        
        try{
            Connection conexion=Conexion.getConexion();
            String query="SELECT IDRAZA FROM RAZA WHERE DESCRIPCIONRAZA=?";
            PreparedStatement buscar=conexion.prepareStatement(query);
            buscar.setString(1, raza);
            ResultSet rs = buscar.executeQuery();
            if(rs.next()){
                id=rs.getInt("IDRAZA");
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
    public String idToRaza(int id) {
        String nombre = "";
        try{
            Connection conexion=Conexion.getConexion();
                String query="SELECT DESCRIPCIONRAZA FROM RAZA WHERE IDRAZA=?";
            PreparedStatement buscar=conexion.prepareStatement(query);
            buscar.setInt(1, id);
            ResultSet rs = buscar.executeQuery();
            if(rs.next()){
                nombre=rs.getString("DESCRIPCIONRAZA");
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
    public boolean modificar(Raza dto) {
                try {
            Connection conexion = Conexion.getConexion();
            String query = "UPDATE RAZA SET IDRAZA=?,DESCRIPCIONRAZA=? WHERE IDRAZA=?";
            PreparedStatement mod = conexion.prepareStatement(query);
            mod.setInt(1, dto.getIdRaza());
            mod.setString(2, dto.getDescripcionRaza());
            mod.setInt(3, dto.getIdRaza());
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
    public boolean registrar(Raza dto) {
        try {

            Connection conexion = Conexion.getConexion();
            String query = "INSERT INTO RAZA (descripcionRaza) VALUES (?)";
            PreparedStatement registra = conexion.prepareStatement(query);

            registra.setString(1, dto.getDescripcionRaza());
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
    public boolean eliminar(Raza dto) {
        try {
            Connection conexion = Conexion.getConexion();
            String query1 = "DELETE FROM RAZA WHERE IDRAZA=?";
            PreparedStatement del = conexion.prepareStatement(query1);
            del.setInt(1, dto.getIdRaza());
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
    public boolean ver(Raza dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
