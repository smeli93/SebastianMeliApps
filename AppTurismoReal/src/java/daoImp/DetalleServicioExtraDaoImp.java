package daoImp;

import dao.DetalleServicioExtraDao;
import dto.DetalleServicioExtraDto;
import sql.Conexion;
import java.sql.*;

public class DetalleServicioExtraDaoImp implements DetalleServicioExtraDao {

    @Override
    public boolean registrar(DetalleServicioExtraDto dto) {

        try {
            Connection conexion = Conexion.getConexion();
            String query = "INSERT INTO DETALLE_SERVICIO(FECHA_CONTRATO_SERVICIO, SERVICIO_EXTRA_ID_SERVICIO_EXTRA, RESERVA_ID_RESERVA) VALUES (NOW(),?,?) ";

            PreparedStatement ingresar = conexion.prepareStatement(query);

            ingresar.setInt(1, dto.getServicio_extra().getId_servicioExtra());
            ingresar.setInt(2, dto.getReserva().getId_reserva());

            ingresar.execute();
            ingresar.close();
            conexion.close();
            return true;
        } catch (SQLException w) {
            System.out.println("Error SQL al agregar detalle servicio" + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error al agregar detalle servicio" + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean modificarTotalServicios(int id) {

        try {
            Connection conexion = Conexion.getConexion();
            String query = "UPDATE reserva SET total_servicios = (select sum(valor_Servicio) from detalle_servicio inner join servicio_extra on detalle_servicio.servicio_extra_id_servicio_extra = servicio_extra.id_servicio_extra where detalle_servicio.reserva_id_reserva='" + id + "') where reserva.id_reserva='"+ id + "'";
            PreparedStatement mod = conexion.prepareStatement(query);
            mod.execute();
            mod.close();
            conexion.close();
            return true;
        } catch (SQLException w) {
            System.out.println("ERROR SQL AL MODIFICAR RESERVA " + w.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR A MODIFICAR RESERVA" + e.getMessage());
        }
        return false;
    }

}
