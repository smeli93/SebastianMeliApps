
package dao;
import dto.DetalleServicioExtraDto;

public interface DetalleServicioExtraDao {
    public boolean registrar(DetalleServicioExtraDto dto);
    public boolean modificarTotalServicios(int id);
}
