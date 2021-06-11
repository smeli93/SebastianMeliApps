
package dao;
import dto.Especialidad;
import java.util.ArrayList;

public interface EspecialidadDao extends BaseDao<Especialidad>{
    public ArrayList<Especialidad> listarEspecialidades();
    public ArrayList<Especialidad> buscarPorId(int id);
    public int EspecialidadToId(String especialidad);
    public String idToEspecialidad(int id);

}
