
package dao;

import dto.TipoMascota;
import java.util.ArrayList;


public interface TipoMascotaDao extends BaseDao<TipoMascota> {
    public ArrayList<TipoMascota> listarTipoMascota();
    public ArrayList<TipoMascota> buscarPorId(int id);
    public int TipoMascotaToId(String tipoMascota);
    public String idToTipoMascota(int id);    
}
