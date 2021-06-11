
package dao;
import dto.PersonaDto;
import java.util.ArrayList;

public interface PersonaDao extends BaseDao<PersonaDto>{
    public boolean validarRut(String rut);
    /* revisar metodo para listar informacion personal personadto+usuariodto*/


}
