
package daoImpl;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import dao.MascotaDao;
import dto.Mascota;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import sql.Conexion;


public class MascotaDAOImp implements MascotaDao{

    @Override
    public ArrayList<Mascota> listarMascotas() {
        
        ArrayList<Mascota> lista = new ArrayList<Mascota>();
        
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM MASCOTA ORDER BY IDMASCOTA ASC";
            PreparedStatement buscar = conexion.prepareStatement(query);
            ResultSet rs = buscar.executeQuery();
            
            while (rs.next()) {
                
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                Date fecha = rs.getDate(3);
                String rut = rs.getString(4);
                int tipo = rs.getInt(5);
                int raza = rs.getInt(6);
                
                Mascota dto = new Mascota(id,nombre, fecha, rut, tipo, raza);
                
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
    public ArrayList<Mascota> buscarMascotaPorCliente(String rut) {
        ArrayList<Mascota> lista1 = new ArrayList<Mascota>();
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM MASCOTA WHERE USUARIO_RUT_USUARIO=?";
            PreparedStatement buscar = conexion.prepareStatement(query);
            buscar.setString(1, rut);
            
            ResultSet rs = buscar.executeQuery();
            
            while (rs.next()) {
                
                Mascota dto = new Mascota();
                dto.setIdMascota(rs.getInt("IDMASCOTA"));
                dto.setNombreMascota(rs.getString("NOMBRE_MASCOTA"));
                dto.setFechaNacimiento(rs.getDate("FECHA_NACIMIENTO"));
                dto.setUsuariorutusuario(rs.getString("USUARIO_RUT_USUARIO"));
                dto.setTipoMascotaidTipoMascota(rs.getInt("TIPO_MASCOTA_IDTIPOMASCOTA"));
                dto.setRazaidRaza(rs.getInt("RAZA_IDRAZA"));         
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
    public int MascotaToId(String nombre) {
        int id=0;
        
        try{
            Connection conexion=Conexion.getConexion();
            String query="SELECT IDMASCOTA FROM MASCOTA WHERE NOMBREMASCOTA=?";
            PreparedStatement buscar=conexion.prepareStatement(query);
            buscar.setString(1, nombre);
            ResultSet rs = buscar.executeQuery();
            if(rs.next()){
                id=rs.getInt("IDMASCOTA");
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
    public String idToMascota(int id) {
        String nombre = "";
        try{
            Connection conexion=Conexion.getConexion();
            String query="SELECT NOMBRE_MASCOTA FROM MASCOTA WHERE IDMASCOTA=?";
            PreparedStatement buscar=conexion.prepareStatement(query);
            buscar.setInt(1, id);
            ResultSet rs = buscar.executeQuery();
            if(rs.next()){
                nombre=rs.getString("NOMBRE_MASCOTA");
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
    public boolean modificar(Mascota dto) {
        try {
            Connection conexion = Conexion.getConexion();
            String query = "UPDATE MASCOTA SET NOMBRE_MASCOTA=?,FECHA_NACIMIENTO=?, "
                    + "TIPO_MASCOTA_IDTIPOMASCOTA=?, RAZA_IDRAZA=? WHERE IDMASCOTA=?";
            PreparedStatement mod = conexion.prepareStatement(query);
            mod.setString(1, dto.getNombreMascota());
            mod.setDate(2,new java.sql.Date(dto.getFechaNacimiento().getTime()));
            mod.setInt(3, dto.getTipoMascotaidTipoMascota());
            mod.setInt(4, dto.getRazaidRaza());
            mod.setInt(5, dto.getIdMascota());
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
    public boolean registrar(Mascota dto) {
        try {

            Connection conexion = Conexion.getConexion();
            String query = "INSERT INTO MASCOTA (nombre_mascota,fecha_Nacimiento,"
                    + "Usuario_rut_usuario,Tipo_Mascota_idTipoMascota,Raza_idRaza) VALUES (?,?,?,?,?)";
            PreparedStatement ingresar = conexion.prepareStatement(query);
            ingresar.setString(1, dto.getNombreMascota());
            ingresar.setDate(2, new java.sql.Date(dto.getFechaNacimiento().getTime()));
            ingresar.setString(3, dto.getUsuariorutusuario());
            ingresar.setInt(4, dto.getTipoMascotaidTipoMascota());
            ingresar.setInt(5, dto.getRazaidRaza());
            ingresar.execute();
            ingresar.close();
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
    public boolean eliminar(Mascota dto) {
        try {
            Connection conexion = Conexion.getConexion();
            String query1 = "DELETE FROM MASCOTA WHERE IDMASCOTA=?";
            PreparedStatement del = conexion.prepareStatement(query1);
            del.setInt(1, dto.getIdMascota());
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
    public boolean ver(Mascota dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
   public ArrayList<Mascota> buscarMisMascotas(String dueno) {
        
        ArrayList<Mascota> lista1 = new ArrayList<Mascota>();
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM MASCOTA WHERE USUARIO_RUT_USUARIO=?";
            PreparedStatement buscar = conexion.prepareStatement(query);
            buscar.setString(1, dueno);            
            ResultSet rs = buscar.executeQuery();
            
            while (rs.next()) {               
                Mascota dto = new Mascota();           
                dto.setIdMascota(rs.getInt("IDMASCOTA"));
                dto.setNombreMascota(rs.getString("NOMBRE_MASCOTA"));
                dto.setFechaNacimiento(rs.getDate("FECHA_NACIMIENTO"));
                dto.setUsuariorutusuario(rs.getString("USUARIO_RUT_USUARIO"));
                dto.setTipoMascotaidTipoMascota(rs.getInt("TIPO_MASCOTA_IDTIPOMASCOTA"));
                dto.setRazaidRaza(rs.getInt("RAZA_IDRAZA"));
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
    
}
