
package dao;

import dto.ServicioExtraDto;
import java.util.ArrayList;


public interface ServicioExtraDao {
    public ArrayList<ServicioExtraDto> listarServicioExtra();
    public ArrayList<ServicioExtraDto> listarServicioExtraPorId(int id);
}
