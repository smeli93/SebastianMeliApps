
package dao;

import dto.Usuario;
import java.util.ArrayList;


public interface UsuarioDao extends BaseDao<Usuario> {
    public ArrayList<Usuario> listarUsuarios();
    public boolean registrarPorAdmin(Usuario dto);
    public boolean validarRut(String rut);
}
