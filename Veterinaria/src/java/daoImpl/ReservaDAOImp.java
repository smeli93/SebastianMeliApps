
package daoImpl;

import dao.ReservaDao;
import dto.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import sql.Conexion;


public class ReservaDAOImp implements ReservaDao{

    @Override
    public ArrayList<Reserva> listarReservas() {
         
        ArrayList<Reserva> lista = new ArrayList<Reserva>();
        
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM RESERVA ORDER BY IDRESERVA ASC";
            PreparedStatement buscar = conexion.prepareStatement(query);
            ResultSet rs = buscar.executeQuery();
            
            while (rs.next()) {
                
                int id = rs.getInt(1);
                String motivo = rs.getString(2);
                Date fecha = rs.getDate(3);
                String hora = rs.getString(4);
                int estado = rs.getInt(5);
                int vet = rs.getInt(6);
                String cliente = rs.getString(7);
                int mascota = rs.getInt(8);
                
                Reserva dto = new Reserva(id, motivo,fecha, hora, estado, vet,cliente, mascota);
                
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
    public ArrayList<Reserva> buscarReservaPorCliente(String rut) {
        ArrayList<Reserva> lista1 = new ArrayList<Reserva>();
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM Reserva WHERE USUARIO_RUT_USUARIO=?";
            PreparedStatement buscar = conexion.prepareStatement(query);
            buscar.setString(1, rut);
            
            ResultSet rs = buscar.executeQuery();
            
            while (rs.next()) {
                
                Reserva dto = new Reserva();
                dto.setIdReserva(rs.getInt("IDRESERVA"));
                dto.setMotivoReserva(rs.getString("MOTIVO_RESERVA"));
                dto.setFechaReserva(rs.getDate("FECHA_RESERVA"));
                dto.setHoraReserva(rs.getString("HORA_RESERVA"));
                dto.setEstadoidEstado(rs.getInt("ESTADO_IDESTADO"));
                dto.setUsuariorutusuario(rs.getString("USUARIO_RUT_USUARIO"));
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
    public ArrayList<Reserva> buscarReservaPorFecha(Date fecha) {
        ArrayList<Reserva> lista1 = new ArrayList<Reserva>();
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM RESERVA WHERE FECHA_RESERVA=?";
            PreparedStatement buscar = conexion.prepareStatement(query);
            buscar.setDate(1, new java.sql.Date(fecha.getTime()));
            
            ResultSet rs = buscar.executeQuery();
            
            while (rs.next()) {
                
                Reserva dto = new Reserva();
                dto.setIdReserva(rs.getInt("IDRESERVA"));
                dto.setMotivoReserva(rs.getString("MOTIVO_RESERVA"));
                dto.setFechaReserva(rs.getDate("FECHA_RESERVA"));
                dto.setHoraReserva(rs.getString("HORA_RESERVA"));
                dto.setEstadoidEstado(rs.getInt("ESTADO_IDESTADO"));
                dto.setUsuariorutusuario(rs.getString("USUARIO_RUT_USUARIO"));
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
    public boolean modificar(Reserva dto) {
        try {
            Connection conexion = Conexion.getConexion();
            String query = "UPDATE RESERVA SET MOTIVO_RESERVA=?,FECHA_RESERVA=?, "
                    + "HORA_RESERVA=?, ESTADO_IDESTADO=?, VETERINARIO_IDVETERINARIO=?,"
                    + "MASCOTA_IDMASCOTA WHERE IDRESERVA=?";
            
            PreparedStatement mod = conexion.prepareStatement(query);
            
            mod.setString(1, dto.getMotivoReserva());
            mod.setDate(2,new java.sql.Date(dto.getFechaReserva().getTime()));
            mod.setString(3, dto.getHoraReserva());
            mod.setInt(4, dto.getEstadoidEstado());
            mod.setInt(5, dto.getVeterinarioidVeterinario());
            mod.setInt(6, dto.getMascotaidMascota());
            mod.setInt(7, dto.getIdReserva());
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
    public boolean registrar(Reserva dto) {
        try {

            Connection conexion = Conexion.getConexion();
            String query = "INSERT INTO RESERVA (motivo_reserva, fecha_reserva, hora_reserva, "
                    + "Estado_idEstado, Veterinario_idVeterinario, Usuario_rut_usuario, Mascota_idMascota) "
                    + "VALUES (?,?,?,1,?,?,?)";
            PreparedStatement ingresar = conexion.prepareStatement(query);
            ingresar.setString(1, dto.getMotivoReserva());
            ingresar.setDate(2, new java.sql.Date(dto.getFechaReserva().getTime()));
            ingresar.setString(3, dto.getHoraReserva());
            ingresar.setInt(4, dto.getVeterinarioidVeterinario());
            ingresar.setString(5, dto.getUsuariorutusuario());
            ingresar.setInt(6, dto.getMascotaidMascota());
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
    public boolean eliminar(Reserva dto) {
        try {
            Connection conexion = Conexion.getConexion();
            String query1 = "DELETE FROM RESERVA WHERE IDRESERVA=?";
            PreparedStatement del = conexion.prepareStatement(query1);
            del.setInt(1, dto.getIdReserva());
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
    public boolean ver(Reserva dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validarReserva(String hora,Date fecha, int id) {
        boolean resp = false;
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM RESERVA WHERE VETERINARIO_IDVETERINARIO='?' "
                    + "and HORA_RESERVA='?' and FECHA_RESERVA=?";
            PreparedStatement valida = conexion.prepareStatement(query);
            valida.setString(1, hora);
            valida.setDate(2, new java.sql.Date(fecha.getTime()));
            valida.setInt(3, id);
            ResultSet rs = valida.executeQuery();

            if (rs.next()) {
                resp = true;
            } else {
                resp = false;
            }

        } catch (SQLException w) {
            System.out.println("Error SQL " + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        return resp;
    }

    
    public ArrayList<Reserva> buscarReservaPorVeterinario(int id) {
        ArrayList<Reserva> lista1 = new ArrayList<Reserva>();
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM RESERVA WHERE VETERINARIO_IDVETERINARIO=?";
            PreparedStatement buscar = conexion.prepareStatement(query);
            buscar.setInt(1, id);
            
            ResultSet rs = buscar.executeQuery();
            
            while (rs.next()) {
                
                Reserva dto = new Reserva();
                dto.setIdReserva(rs.getInt("IDRESERVA"));
                dto.setMotivoReserva(rs.getString("MOTIVO_RESERVA"));
                dto.setFechaReserva(rs.getDate("FECHA_RESERVA"));
                dto.setHoraReserva(rs.getString("HORA_RESERVA"));
                dto.setEstadoidEstado(rs.getInt("ESTADO_IDESTADO"));
                dto.setVeterinarioidVeterinario(rs.getInt("VETERINARIO_IDVETERINARIO"));
                dto.setUsuariorutusuario(rs.getString("USUARIO_RUT_USUARIO"));
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



    
}
