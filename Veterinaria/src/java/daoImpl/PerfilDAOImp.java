
package daoImpl;

import dao.PerfilDao;
import dto.Perfil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sql.Conexion;


public class PerfilDAOImp implements PerfilDao{

    public ArrayList<String> listarNombrePerfil() {
        ArrayList<String> lista = new ArrayList<>();
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT DISTINCT DESCRIPCIONPERFIL FROM PERFIL ORDER BY DESCRIPCIONPERFIL ASC";
            PreparedStatement buscar = conexion.prepareStatement(query);
            ResultSet rs
                    = buscar.executeQuery();
            while (rs.next()) {
                lista.add(rs.getString("DESCRIPCIONPERFIL"));

            }
            buscar.close();
            conexion.close();

        } catch (SQLException w) {
            System.out.println("Erro SQL" + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar " + e.getMessage());
        }
        return lista;
    }
        
    @Override
    public ArrayList<Perfil> listarPerfil() {
        ArrayList<Perfil> lista = new ArrayList<Perfil>();
        
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM PERFIL ORDER BY IDPERFIL ASC";
            PreparedStatement buscar = conexion.prepareStatement(query);
            ResultSet rs = buscar.executeQuery();
            
            while (rs.next()) {
                
                int id = rs.getInt(1);
                String descripcion = rs.getString(2);
                
                Perfil dto = new Perfil(id, descripcion);               
                
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
    public ArrayList<Perfil> buscarPorId(int id) {
        ArrayList<Perfil> lista1 = new ArrayList<Perfil>();
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM PERFIL WHERE IDPERFIL=?";
            PreparedStatement buscar = conexion.prepareStatement(query);
            buscar.setInt(1, id);
            
            ResultSet rs = buscar.executeQuery();
            
            while (rs.next()) {
                Perfil dto = new Perfil();
                dto.setIdPerfil(rs.getInt("IDPERFIL"));
                dto.setDescripcionPerfil(rs.getString("DESCRIPCIONPERFIL"));
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
    public int PerfilToId(String perfil) {
        int id=0;
        
        try{
            Connection conexion=Conexion.getConexion();
            String query="SELECT IDPERFIL FROM PERFIL WHERE DESCRIPCIONPERFIL=?";
            PreparedStatement buscar=conexion.prepareStatement(query);
            buscar.setString(1, perfil);
            ResultSet rs = buscar.executeQuery();
            if(rs.next()){
                id=rs.getInt("IDPERFIL");
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
    public String idToPerfil(int id) {
        String nombre = "";
        try{
            Connection conexion=Conexion.getConexion();
                String query="SELECT DESCRIPCIONPERFIL FROM PERFIL WHERE IDPERFIL=?";
            PreparedStatement buscar=conexion.prepareStatement(query);
            buscar.setInt(1, id);
            ResultSet rs = buscar.executeQuery();
            if(rs.next()){
                nombre=rs.getString("DESCRIPCIONPERFIL");
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
    public boolean modificar(Perfil dto) {
        try {
            Connection conexion = Conexion.getConexion();
            String query = "UPDATE PERFIL SET IDPERFIL=?,DESCRIPCIONPERFIL=? WHERE IDPERFIL=?";
            PreparedStatement mod = conexion.prepareStatement(query);
            mod.setInt(1, dto.getIdPerfil());
            mod.setString(2, dto.getDescripcionPerfil());
            mod.setInt(3, dto.getIdPerfil());
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
    public boolean registrar(Perfil dto) {
        try {

            Connection conexion = Conexion.getConexion();
            String query = "INSERT INTO PERFIL (descripcionPerfil) VALUES (?)";
            PreparedStatement registra = conexion.prepareStatement(query);

            registra.setString(1, dto.getDescripcionPerfil());
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
    public boolean eliminar(Perfil dto) {
        try {
            Connection conexion = Conexion.getConexion();
            String query1 = "DELETE FROM PERFIL WHERE IDPERFIL=?";
            PreparedStatement del = conexion.prepareStatement(query1);
            del.setInt(1, dto.getIdPerfil());
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
    public boolean ver(Perfil dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
