
package dao;

import dto.Procedimiento;
import java.util.ArrayList;


public interface ProcedimientoDao extends BaseDao<Procedimiento>{
        public ArrayList<Procedimiento> listarProcedimientos();
        public ArrayList<Procedimiento> buscarProcedimientoMascota(int mascota);
    
}
