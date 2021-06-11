
package dao;
import dto.ReservaDto;
import java.util.ArrayList;

public interface ReservaDao extends BaseDao<ReservaDto>{
    public ArrayList<ReservaDto> listarMisReservas(String rut);
    public int agregarReservaRetornandoId(ReservaDto dto);
}
