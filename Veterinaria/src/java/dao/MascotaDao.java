
package dao;

import dto.Mascota;
import java.util.ArrayList;


public interface MascotaDao extends BaseDao<Mascota>{

    public ArrayList<Mascota> listarMascotas();
    public ArrayList<Mascota> buscarMascotaPorCliente(String rut);
    public int MascotaToId(String nombre);
    public String idToMascota(int id);   
}
