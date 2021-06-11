
package dao;

import dto.Estado;
import java.util.ArrayList;


public interface EstadoDao extends BaseDao<Estado>{
    public ArrayList<Estado> listarEstados();
    public ArrayList<Estado> buscarPorId(int id);
    public int EstadoToId(String estado);
    public String idToEstado(int id);    
    
}
