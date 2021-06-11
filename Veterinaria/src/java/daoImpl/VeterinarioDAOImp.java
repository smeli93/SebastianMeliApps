
package daoImpl;

import dao.VeterinarioDao;
import dto.Veterinario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import sql.Conexion;


public class VeterinarioDAOImp implements VeterinarioDao {
   
    public ArrayList<String> listarNombreVeterinario() {
         ArrayList<String> lista = new ArrayList<>();
      try{
          Connection conexion = Conexion.getConexion();
          String query= "SELECT DISTINCT CONCAT(NOMBRE,' ',APELLIDO) as NOMBRE FROM VETERINARIO ORDER BY NOMBRE ASC";
          PreparedStatement buscar = conexion.prepareStatement(query);
          ResultSet rs=
                  buscar.executeQuery();
          while(rs.next()){
              lista.add(rs.getString("NOMBRE"));
              
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
    public ArrayList<Veterinario> listarVeterinarios() {
        ArrayList<Veterinario> lista = new ArrayList<Veterinario>();
        
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM VETERINARIO ORDER BY IDVETERINARIO ASC";
            PreparedStatement buscar = conexion.prepareStatement(query);
            ResultSet rs = buscar.executeQuery();
            
            while (rs.next()) {
                
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                String email = rs.getString(4);
                String direccion = rs.getString(5);
                String telefono = rs.getString(6);
                Date fecha = rs.getDate(7);
                int Especialidad = rs.getInt(8);
                
                Veterinario dto = new Veterinario(id,nombre, apellido, email, direccion, telefono , fecha, Especialidad);
                
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
    public ArrayList<Veterinario> buscarPorNombre(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Veterinario> buscarPorEspecialidad(int especialidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Veterinario dto) {
        try {
            Connection conexion = Conexion.getConexion();
            String query = "UPDATE VETERINARIO SET NOMBRE=?, APELLIDO=?, EMAIL=?, DIRECCION=?, FECHA_DE_INGRESO=?"
                    + ",ESPECIALIDAD_IDESPECIALIDAD=? WHERE IDVETERINARIO=?";
            PreparedStatement mod = conexion.prepareStatement(query);
            mod.setString(1, dto.getNombre());
            mod.setString(2, dto.getApellido());
            mod.setString(3, dto.getEmail());
            mod.setString(4, dto.getDireccion());
            mod.setDate(5,new java.sql.Date(dto.getFechaDeIngreso().getTime()));
            mod.setInt(6, dto.getIdEspecialidad());
            mod.setInt(7, dto.getIdVeterinario());
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
    public boolean registrar(Veterinario dto) {
        try{
            Connection conexion=Conexion.getConexion();
            String query="INSERT INTO VETERINARIO(NOMBRE, APELLIDO, "
                    + "EMAIL, DIRECCION, TELEFONO, FECHA_DE_INGRESO, ESPECIALIDAD_IDESPECIALIDAD) "
                    + "VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ingresar=conexion.prepareStatement(query);
            ingresar.setString(1, dto.getNombre());
            ingresar.setString(2, dto.getApellido());
            ingresar.setString(3, dto.getEmail());
            ingresar.setString(4, dto.getDireccion());
            ingresar.setString(5, dto.getTelefono());
            ingresar.setDate(6, new java.sql.Date(dto.getFechaDeIngreso().getTime()));
            ingresar.setInt(7, dto.getIdEspecialidad());
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
    public boolean eliminar(Veterinario dto) {
        try {
            Connection conexion = Conexion.getConexion();
            String query1 = "DELETE FROM VETERINARIO WHERE IDVETERINARIO=?";
            PreparedStatement del = conexion.prepareStatement(query1);
            del.setInt(1, dto.getIdVeterinario());
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
    public boolean ver(Veterinario dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int VeterinarioToId(String veterinario) {
        int id=0;
        
        try{
            Connection conexion=Conexion.getConexion();
            String query="SELECT idveterinario FROM `veterinario` WHERE concat(nombre,' ',apellido)=?";
            PreparedStatement buscar=conexion.prepareStatement(query);
            buscar.setString(1, veterinario);
            ResultSet rs = buscar.executeQuery();
            if(rs.next()){
                id=rs.getInt("IDVETERINARIO");
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
    public String idToVeterinario(int id) {
        String nombre = "";
        try{
            Connection conexion=Conexion.getConexion();
                String query="SELECT CONCAT(NOMBRE,' ',APELLIDO) as NOMBRE  FROM VETERINARIO WHERE IDVETERINARIO=?";
            PreparedStatement buscar=conexion.prepareStatement(query);
            buscar.setInt(1, id);
            ResultSet rs = buscar.executeQuery();
            if(rs.next()){
                nombre=rs.getString("NOMBRE");
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
