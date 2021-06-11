
package daoImpl;

import dao.TipoMascotaDao;
import dto.TipoMascota;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sql.Conexion;


public class TipoMascotaDAOImp implements TipoMascotaDao{
    
    public ArrayList<String> listarNombreTipoMascota() {
         ArrayList<String> lista = new ArrayList<>();
      try{
          Connection conexion = Conexion.getConexion();
          String query= "SELECT DISTINCT DESCRIPCIONTIPOMASCOTA FROM TIPO_MASCOTA ORDER BY DESCRIPCIONTIPOMASCOTA ASC";
          PreparedStatement buscar = conexion.prepareStatement(query);
          ResultSet rs=
                  buscar.executeQuery();
          while(rs.next()){
              lista.add(rs.getString("DESCRIPCIONTIPOMASCOTA"));
              
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
    public ArrayList<TipoMascota> listarTipoMascota() {
        ArrayList<TipoMascota> lista = new ArrayList<TipoMascota>();
        
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM TIPO_MASCOTA ORDER BY IDTIPOMASCOTA ASC";
            PreparedStatement buscar = conexion.prepareStatement(query);
            ResultSet rs = buscar.executeQuery();
            
            while (rs.next()) {
                
                int id = rs.getInt(1);
                String descripcion = rs.getString(2);
                
                TipoMascota dto = new TipoMascota(id, descripcion);               
                
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
    public ArrayList<TipoMascota> buscarPorId(int id) {
        ArrayList<TipoMascota> lista1 = new ArrayList<TipoMascota>();
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM TIPO_MASCOTA WHERE IDTIPOMASCOTA=?";
            PreparedStatement buscar = conexion.prepareStatement(query);
            buscar.setInt(1, id);
            
            ResultSet rs = buscar.executeQuery();
            
            while (rs.next()) {
                TipoMascota dto = new TipoMascota();
                dto.setIdTipoMascota(rs.getInt("IDTIPOMASCOTA"));
                dto.setDescripcionTipoMascota(rs.getString("DESCRIPCIONTIPOMASCOTA"));
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
    public int TipoMascotaToId(String tipoMascota) {
        int id=0;
        
        try{
            Connection conexion=Conexion.getConexion();
            String query="SELECT IDTIPOMASCOTA FROM TIPO_MASCOTA WHERE DESCRIPCIONTIPOMASCOTA=?";
            PreparedStatement buscar=conexion.prepareStatement(query);
            buscar.setString(1, tipoMascota);
            ResultSet rs = buscar.executeQuery();
            if(rs.next()){
                id=rs.getInt("IDTIPOMASCOTA");
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
    public String idToTipoMascota(int id) {
        String nombre = "";
        try{
            Connection conexion=Conexion.getConexion();
                String query="SELECT DESCRIPCIONTIPOMASCOTA FROM TIPO_MASCOTA WHERE IDTIPOMASCOTA=?";
            PreparedStatement buscar=conexion.prepareStatement(query);
            buscar.setInt(1, id);
            ResultSet rs = buscar.executeQuery();
            if(rs.next()){
                nombre=rs.getString("DESCRIPCIONTIPOMASCOTA");
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
    public boolean modificar(TipoMascota dto) {
        try {
            Connection conexion = Conexion.getConexion();
            String query = "UPDATE TIPO_MASCOTA SET IDTIPOMASCOTA=?,DESCRIPCIONTIPOMASCOTA=? WHERE IDTIPOMASCOTA=?";
            PreparedStatement mod = conexion.prepareStatement(query);
            mod.setInt(1, dto.getIdTipoMascota());
            mod.setString(2, dto.getDescripcionTipoMascota());
            mod.setInt(3, dto.getIdTipoMascota());
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
    public boolean registrar(TipoMascota dto) {
        try {

            Connection conexion = Conexion.getConexion();
            String query = "INSERT INTO TIPO_MASCOTA (descripcionTipoMascota) VALUES (?)";
            PreparedStatement registra = conexion.prepareStatement(query);

            registra.setString(1, dto.getDescripcionTipoMascota());
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
    public boolean eliminar(TipoMascota dto) {
        try {
            Connection conexion = Conexion.getConexion();
            String query1 = "DELETE FROM TIPO_MASCOTA WHERE IDTIPOMASCOTA=?";
            PreparedStatement del = conexion.prepareStatement(query1);
            del.setInt(1, dto.getIdTipoMascota());
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
    public boolean ver(TipoMascota dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
