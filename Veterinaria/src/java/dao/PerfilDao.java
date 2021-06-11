
package dao;

import dto.Perfil;
import java.util.ArrayList;


public interface PerfilDao extends BaseDao<Perfil>{
    public ArrayList<Perfil> listarPerfil();
    public ArrayList<Perfil> buscarPorId(int id);
    public int PerfilToId(String perfil);
    public String idToPerfil(int id);    
}
