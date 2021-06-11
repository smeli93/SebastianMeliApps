package dao;

import java.util.ArrayList;



public interface BaseDao<T> {
    
     public boolean modificar(T dto);
     public boolean registrar(T dto);
     public boolean eliminar(T dto);
    
    
}
