
package daoImpl;

import dao.ProcedimientoDao;
import dto.Procedimiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import sql.Conexion;


public class ProcedimientoDAOImp implements ProcedimientoDao{

    @Override
    public ArrayList<Procedimiento> listarProcedimientos() {
        ArrayList<Procedimiento> lista = new ArrayList<Procedimiento>();
        
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM PROCEDIMIENTO ORDER BY IDPROCEDIMIENTO ASC";
            PreparedStatement buscar = conexion.prepareStatement(query);
            ResultSet rs = buscar.executeQuery();
            
            while (rs.next()) {
                
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                Date fecha = rs.getDate(3);
                String descripcion = rs.getString(4);
                int reserva = rs.getInt(5);
                int mascota = rs.getInt(6);
                
                Procedimiento dto = new Procedimiento(id, nombre, fecha, descripcion, reserva, mascota);
                
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
    public ArrayList<Procedimiento> buscarProcedimientoMascota(int mascota) {
        
        ArrayList<Procedimiento> lista1 = new ArrayList<Procedimiento>();
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM PROCEDIMIENTO WHERE MASCOTA_IDMASCOTA=?";
            PreparedStatement buscar = conexion.prepareStatement(query);
            buscar.setInt(1, mascota);            
            ResultSet rs = buscar.executeQuery();
            
            while (rs.next()) {               
                Procedimiento dto = new Procedimiento();           
                dto.setIdProcedimiento(rs.getInt("IDPROCEDIMIENTO"));
                dto.setNombreProdecimiento(rs.getString("NOMBRE_PROCEDIMIENTO"));
                dto.setFechaProcedimiento(rs.getDate("FECHA_PROCEDIMIENTO"));
                dto.setDescripcionProcedimiento(rs.getString("DESCRIPCION_PROCEDIMIENTO"));
                dto.setReservaidReserva(rs.getInt("RESERVA_IDRESERVA"));
                dto.setMascotaidMascota(rs.getInt("MASCOTA_IDMASCOTA"));
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
    public boolean modificar(Procedimiento dto) {
        try {
            Connection conexion = Conexion.getConexion();
            String query = "UPDATE PROCEDIMIENTO SET NOMBRE_PROCEDIMIENTO=?,FECHA_PROCEDIMIENTO=?, "
                    + "DESCRIPCION_PROCEDIMIENTO=? WHERE IDPROCEDIMIENTO=?";
            
            PreparedStatement mod = conexion.prepareStatement(query);
            
            mod.setString(1, dto.getNombreProdecimiento());
            mod.setDate(2,new java.sql.Date(dto.getFechaProcedimiento().getTime()));
            mod.setString(3, dto.getDescripcionProcedimiento());
            mod.setInt(4, dto.getIdProcedimiento());
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
    public boolean registrar(Procedimiento dto) {
        try {
            Connection conexion = Conexion.getConexion();
            String query = "INSERT INTO PROCEDIMIENTO (nombre_procedimiento, fecha_Procedimiento, "
                    + "descripcion_Procedimiento, Reserva_idReserva, Mascota_idMascota) "
                    + "VALUES (?,?,?,?,?)";
            PreparedStatement ingresar = conexion.prepareStatement(query);
            
            ingresar.setString(1, dto.getNombreProdecimiento());
            ingresar.setDate(2, new java.sql.Date(dto.getFechaProcedimiento().getTime()));
            ingresar.setString(3, dto.getDescripcionProcedimiento());
            ingresar.setInt(4, dto.getReservaidReserva());
            ingresar.setInt(5, dto.getMascotaidMascota());
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
    public boolean eliminar(Procedimiento dto) {
        try {
            Connection conexion = Conexion.getConexion();
            String query1 = "DELETE FROM PROCEDIMIENTO WHERE IDPROCEDIMIENTO=?";
            PreparedStatement del = conexion.prepareStatement(query1);
            del.setInt(1, dto.getIdProcedimiento());
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
    public boolean ver(Procedimiento dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
