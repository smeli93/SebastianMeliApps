
package daoImpl;

import dao.EspecialidadDao;
import dto.Especialidad;
import java.sql.*;
import java.util.ArrayList;
import sql.Conexion;

public class EspecialidadDAOImp implements EspecialidadDao {

    
    public ArrayList<String> listarEspecialidad() {
         ArrayList<String> lista = new ArrayList<>();
      try{
          Connection conexion = Conexion.getConexion();
          String query= "SELECT DISTINCT DESCRIPCIONESPECIALIDAD FROM ESPECIALIDAD ORDER BY DESCRIPCIONESPECIALIDAD ASC";
          PreparedStatement buscar = conexion.prepareStatement(query);
          ResultSet rs=
                  buscar.executeQuery();
          while(rs.next()){
              lista.add(rs.getString("DESCRIPCIONESPECIALIDAD"));
              
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
    public boolean modificar(Especialidad dto) {
        try {
            Connection conexion = Conexion.getConexion();
            String query = "UPDATE ESPECIALIDAD SET IDESPECIALIDAD=?,DESCRIPCIONESPECIALIDAD=? WHERE IDESPECIALIDAD=?";
            PreparedStatement mod = conexion.prepareStatement(query);
            mod.setInt(1, dto.getIdEspecialidad());
            mod.setString(2, dto.getDescripcionEspecialidad());
            mod.setInt(3, dto.getIdEspecialidad());
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
    public boolean registrar(Especialidad dto) {
         try {

            Connection conexion = Conexion.getConexion();
            String query = "INSERT INTO ESPECIALIDAD (descripcionEspecialidad) VALUES (?)";
            PreparedStatement registra = conexion.prepareStatement(query);

            registra.setString(1, dto.getDescripcionEspecialidad());
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
    public boolean eliminar(Especialidad dto) {
        try {
            Connection conexion = Conexion.getConexion();
            String query1 = "DELETE FROM ESPECIALIDAD WHERE IDESPECIALIDAD=?";
            PreparedStatement del = conexion.prepareStatement(query1);
            del.setInt(1, dto.getIdEspecialidad());
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
    public boolean ver(Especialidad dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Especialidad> listarEspecialidades() {
        ArrayList<Especialidad> lista = new ArrayList<Especialidad>();
        
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM ESPECIALIDAD ORDER BY IDESPECIALIDAD ASC";
            PreparedStatement buscar = conexion.prepareStatement(query);
            ResultSet rs = buscar.executeQuery();
            
            while (rs.next()) {
                
                int id = rs.getInt(1);
                String descripcion = rs.getString(2);
                
                Especialidad dto = new Especialidad(id, descripcion);               
                
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
    public ArrayList<Especialidad> buscarPorId(int id) {
                ArrayList<Especialidad> lista1 = new ArrayList<Especialidad>();
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM ESPECIALIDAD WHERE IDESPECIALIDAD=?";
            PreparedStatement buscar = conexion.prepareStatement(query);
            buscar.setInt(1, id);
            
            ResultSet rs = buscar.executeQuery();
            
            while (rs.next()) {
                Especialidad dto = new Especialidad();
                dto.setIdEspecialidad(rs.getInt("IDESPECIALIDAD"));
                dto.setDescripcionEspecialidad(rs.getString("DESCRIPCIONESPECIALIDAD"));
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
    public int EspecialidadToId(String especialidad) {
        
        int id=0;
        
        try{
            Connection conexion=Conexion.getConexion();
            String query="SELECT IDESPECIALIDAD FROM ESPECIALIDAD WHERE DESCRIPCIONESPECIALIDAD=?";
            PreparedStatement buscar=conexion.prepareStatement(query);
            buscar.setString(1, especialidad);
            ResultSet rs = buscar.executeQuery();
            if(rs.next()){
                id=rs.getInt("IDESPECIALIDAD");
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
    public String idToEspecialidad(int id) {
        String nombre = "";
        try{
            Connection conexion=Conexion.getConexion();
            String query="SELECT DESCRIPCIONESPECIALIDAD FROM ESPECIALIDAD WHERE IDESPECIALIDAD=?";
            PreparedStatement buscar=conexion.prepareStatement(query);
            buscar.setInt(1, id);
            ResultSet rs = buscar.executeQuery();
            if(rs.next()){
                nombre=rs.getString("DESCRIPCIONESPECIALIDAD");
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
    
}
