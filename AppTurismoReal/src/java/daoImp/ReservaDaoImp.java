package daoImp;

import dao.ReservaDao;
import dto.ReservaDto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import sql.Conexion;

public class ReservaDaoImp implements ReservaDao {

    @Override
    public ArrayList<ReservaDto> listarMisReservas(String rut) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(ReservaDto dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean registrar(ReservaDto dto) {

        try {
            Connection conexion = Conexion.getConexion();
            String query = "INSERT INTO RESERVA (FECHA_RESERVA, DIAS_RESERVA, INICIO_RESERVA, TERMINO_RESERVA, PAGO_GARANTIA,"
                    + "METODO_PAGO_ID_METODO_PAGO, PERSONA_RUT_PERSONA, DEPARTAMENTO_ID_DEPARTAMENTO) VALUES (NOW(),?,?,?,?,?,?,?)";

            PreparedStatement registrar = conexion.prepareStatement(query);

            registrar.setInt(1, dto.getCant_dias());
            registrar.setDate(2, (Date) dto.getInicio_reserva());
            registrar.setDate(3, (Date) dto.getTermino_reserva());
            registrar.setInt(4, dto.getPago_garantia());
            registrar.setInt(5, dto.getMetodoPago().getId_metodo_pago());
            registrar.setString(6, dto.getPersona().getRut());
            registrar.setInt(7, dto.getDepartamento().getId_depto());

            registrar.execute();
            registrar.close();
            conexion.close();
            return true;
        } catch (SQLException w) {
            System.out.println("Error SQL al registrar una reserva" + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error al registrar una reserva" + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean eliminar(ReservaDto dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int agregarReservaRetornandoId(ReservaDto dto) {

        int rows = 0;
        int idGenerado = 0;

        try {
            Connection conexion = Conexion.getConexion();
            String query = "INSERT INTO RESERVA (FECHA_RESERVA, DIAS_RESERVA, INICIO_RESERVA, TERMINO_RESERVA, PAGO_GARANTIA,"
                    + "METODO_PAGO_ID_METODO_PAGO, PERSONA_RUT_PERSONA, DEPARTAMENTO_ID_DEPARTAMENTO) VALUES (NOW(),?,?,?,?,?,?,?)";

            PreparedStatement registrar = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            registrar.setInt(1, dto.getCant_dias());
            registrar.setDate(2, (Date) dto.getInicio_reserva());
            registrar.setDate(3, (Date) dto.getTermino_reserva());
            registrar.setInt(4, dto.getPago_garantia());
            registrar.setInt(5, dto.getMetodoPago().getId_metodo_pago());
            registrar.setString(6, dto.getPersona().getRut());
            registrar.setInt(7, dto.getDepartamento().getId_depto());

            rows = registrar.executeUpdate();

            if (rows == 0) {
                throw new SQLException("No se pudo guardar");
            }

            ResultSet generatedKeys = registrar.getGeneratedKeys();
            if (generatedKeys.next()) {
                idGenerado = generatedKeys.getInt(1);
            }

            registrar.close();
            conexion.close();

        } catch (SQLException w) {
            System.out.println("Error SQL al registrar una reserva" + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error al registrar una reserva" + e.getMessage());
        }
        return idGenerado;
    }

}
