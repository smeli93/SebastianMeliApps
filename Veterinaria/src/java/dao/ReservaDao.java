
package dao;

import dto.Reserva;
import java.util.ArrayList;
import java.util.Date;


public interface ReservaDao extends BaseDao<Reserva> {
    
        public ArrayList<Reserva> listarReservas();
        public ArrayList<Reserva> buscarReservaPorCliente(String rut);
        public ArrayList<Reserva> buscarReservaPorFecha(Date fecha); 
        public boolean validarReserva(String hora,Date fecha, int id);

   
}
