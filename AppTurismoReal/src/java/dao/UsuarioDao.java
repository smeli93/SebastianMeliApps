
package dao;
import dto.PersonaDto;
import dto.UsuarioDto;
import java.util.ArrayList;

public interface UsuarioDao extends BaseDao<UsuarioDto>{
    public boolean Login(String email, String password);
    public boolean validarEmail(String email);
    public ArrayList<UsuarioDto> buscarPorEmail(String email);
    public UsuarioDto retornarUsuario(String email, String password);
    public ArrayList<UsuarioDto> buscarPorRut(String rut);

}
