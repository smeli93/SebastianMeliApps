
package dao;

import dto.Raza;
import java.util.ArrayList;


public interface RazaDao extends BaseDao<Raza> {
    public ArrayList<Raza> listarRaza();
    public ArrayList<Raza> buscarPorId(int id);
    public int RazaToId(String raza);
    public String idToRaza(int id);     
}
