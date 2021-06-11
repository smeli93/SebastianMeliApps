package daoImp;

import dao.ServicioExtraDao;
import dto.ServicioExtraDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sql.Conexion;

public class ServicioExtraDaoImp implements ServicioExtraDao {
    
    @Override
    public ArrayList<ServicioExtraDto> listarServicioExtra() {
        
        ArrayList<ServicioExtraDto> lista = new ArrayList<>();
        
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM SERVICIO_EXTRA";
            PreparedStatement buscar = conexion.prepareStatement(query);
            ResultSet rs = buscar.executeQuery();
            
            while (rs.next()) {
                
                ServicioExtraDto dto = new ServicioExtraDto();
                
                dto.setId_servicioExtra(rs.getInt("id_servicio_extra"));
                dto.setNombre_servicioExtra(rs.getString("nombre_servicio_extra"));
                dto.setValor_servicioExtra(rs.getInt("valor_servicio"));
                
                lista.add(dto);
            }
            buscar.close();
            conexion.close();
        } catch (SQLException w) {
            System.out.println("Error SQL al listar servicio extra " + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar listar servicio extra " + e.getMessage());
        }
        return lista;
    }
    
    @Override
    public ArrayList<ServicioExtraDto> listarServicioExtraPorId(int id) {
        ArrayList<ServicioExtraDto> lista = new ArrayList<>();
        
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM SERVICIO_EXTRA WHERE ID_SERVICIO_EXTRA=?";
            PreparedStatement buscar = conexion.prepareStatement(query);
            buscar.setInt(1, id);
            ResultSet rs = buscar.executeQuery();
            
            while (rs.next()) {
                
                ServicioExtraDto dto = new ServicioExtraDto();
                
                dto.setId_servicioExtra(rs.getInt("id_servicio_extra"));
                dto.setNombre_servicioExtra(rs.getString("nombre_servicio_extra"));
                dto.setValor_servicioExtra(rs.getInt("valor_servicio"));
                
                lista.add(dto);
            }
            buscar.close();
            conexion.close();
        } catch (SQLException w) {
            System.out.println("Error SQL al listar servicio extra por id " + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar listar servicio extra por id " + e.getMessage());
        }
        return lista;
    }
    
}
