
package daoImp;

import dto.RegionDto;
import dao.RegionDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sql.Conexion;


public class RegionDaoImp implements RegionDao{

    @Override
    public ArrayList<String> listarNombreRegion() {
        ArrayList<String> lista = new ArrayList<>();
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT DISTINCT NOM_REGION FROM REGION";
            PreparedStatement buscar = conexion.prepareStatement(query);
            ResultSet rs = buscar.executeQuery();
            while (rs.next()) {
                lista.add(rs.getString("NOM_REGION"));

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
    public int RegionToId(String region) {
        int id=0;
        
        try{
            Connection conexion=Conexion.getConexion();
            String query="SELECT ID_REGION FROM REGION WHERE NOM_REGION=?";
            PreparedStatement buscar=conexion.prepareStatement(query);
            buscar.setString(1, region);
            ResultSet rs = buscar.executeQuery();
            if(rs.next()){
                id=rs.getInt("ID_REGION");
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
    public String idToRegion(int id) {
                String nombre = "";
        try{
            Connection conexion=Conexion.getConexion();
                String query="SELECT NOM_REGION FROM REGION WHERE ID_REGION=?";
            PreparedStatement buscar=conexion.prepareStatement(query);
            buscar.setInt(1, id);
            ResultSet rs = buscar.executeQuery();
            if(rs.next()){
                nombre=rs.getString("NOM_REGION");
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
