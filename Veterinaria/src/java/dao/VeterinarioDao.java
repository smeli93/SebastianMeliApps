
package dao;

import dto.Veterinario;
import java.util.ArrayList;


public interface VeterinarioDao extends BaseDao<Veterinario>{
    public ArrayList<Veterinario> listarVeterinarios();
    public ArrayList<Veterinario> buscarPorNombre(String nombre);
    public ArrayList<Veterinario> buscarPorEspecialidad(int especialidad); 
    public int VeterinarioToId(String veterinario);
    public String idToVeterinario(int id);
}
